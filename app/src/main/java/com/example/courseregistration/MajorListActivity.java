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
import com.example.courseregistration.interfaces.ModelCallBacks;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MajorListActivity extends AppCompatActivity implements ModelCallBacks {

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



//        //////TEST
//        System.out.println("onCreate");
//
//        ArrayList<Major> majors = new ArrayList<>();
//        majors = firebasehelper.retrieveMajor(this);
////
////        try {
////            synchronized (majors) {
////                majors.wait();
////            }
////        } catch (InterruptedException e1) {
////            e1.printStackTrace();
////        }


//        System.out.println("firebasehelper.retrieveMajor():" + majors);
//        Major m = new Major();
//        for (int i = 0; i < majors.size(); i++) {
//            m = (Major) majors.get(i);
//            System.out.println("id: " + m.getMajor_id());
//            System.out.println("name: " + m.getMajor_name());
//        }

        //ADAPTER
        adapter = new MajorListAdapter(getApplicationContext(),firebasehelper.retrieveMajor(this));

//        db= new Firebase("");

//        myAdapter = new FirebaseListAdapter<String>(this,String.class,android.R.layout.simple_list_item_1,db) {
//            @Override
//            protected void populateView(View view, String s, int i) {
//                TextView text = (TextView) view.findViewById(android.R.id.text1);
//                text.setText(s);
//            }
//        };

        adapter.notifyDataSetChanged();
        lv_MajorList.setAdapter(adapter);


    }


    /////////////
    @Override
    public void onModelUpdated(ArrayList<Major> majors) {

        adapter = new MajorListAdapter(getApplicationContext(),firebasehelper.retrieveMajor(this));
        lv_MajorList.setAdapter(adapter);

        majors = firebasehelper.retrieveMajor(this);

        System.out.println("/////////firebasehelper.retrieveMajor():" + majors);
        Major m = new Major();
        for (int i = 0; i < majors.size(); i++) {
            m = (Major) majors.get(i);
            System.out.println("id: " + m.getMajor_id());
            System.out.println("name: " + m.getMajor_name());
        }
    }
}
