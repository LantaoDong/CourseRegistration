package com.example.courseregistration;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MajorListActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    MajorListAdapter adapter;
    ListView lv_MajorList;
    EditText nameEditTxt,propTxt,descTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        lv_MajorList = (ListView) findViewById(R.id.lv_MajorList);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper=new FirebaseHelper(db);

        //ADAPTER
        adapter = new MajorListAdapter(this,firebasehelper.retrieveMajor());
        lv_MajorList.setAdapter(adapter);
    }

}
