package com.example.courseregistration;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.example.courseregistration.interfaces.MajorCallbacks;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * The Activity is to list majors.
 *
 * @author Haofan & Tianyi
 */

public class MajorListActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    MajorListAdapter adapter;
    ListView lv_MajorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_list);

        //get intent
        Intent intent = getIntent();
        final int course_term = intent.getIntExtra("term", 0);

        lv_MajorList = (ListView) findViewById(R.id.lv_MajorList);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper=new FirebaseHelper(db);

        //retrieve data
        firebasehelper.retrieveMajor(new MajorCallbacks() {
            @Override
            public void onMajorCallback(ArrayList<Major> majors) {
                adapter = new MajorListAdapter(MajorListActivity.this, majors, course_term);
                lv_MajorList.setAdapter(adapter);
            }
        });

    }
}