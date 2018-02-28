package com.example.courseregistration;

import android.app.Dialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MajorListActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    MajorListAdapter adapter;
    ListView lv_MajorList;

//    com.firebase.ui.FirebaseListAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_list);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        lv_MajorList = (ListView) findViewById(R.id.lv_MajorList);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper=new FirebaseHelper(db);

        //ADAPTER
        adapter = new MajorListAdapter(getApplicationContext(),firebasehelper.retrieveMajor());

        ////////////
        System.out.println("retrieve"+firebasehelper.retrieveMajor().toString());

//        db= new Firebase("");

//        myAdapter = new FirebaseListAdapter<String>(this,String.class,android.R.layout.simple_list_item_1,db) {
//            @Override
//            protected void populateView(View view, String s, int i) {
//                TextView text = (TextView) view.findViewById(android.R.id.text1);
//                text.setText(s);
//            }
//        };

        lv_MajorList.setAdapter(adapter);
    }

}
