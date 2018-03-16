package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.example.courseregistration.UI.TimeTableAdapter;
import com.example.courseregistration.interfaces.CourseCallbacks;
import com.example.courseregistration.interfaces.MajorCallbacks;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    TimeTableAdapter adapter;
    ListView lv_CourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //GET INTENT
        Intent intent = this.getIntent();
        String majorID = intent.getStringExtra("MAJOR_ID");
//
        lv_CourseList = (ListView) findViewById(R.id.lv_CourseList);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper=new FirebaseHelper(db);

        //ADAPTER
        adapter = new TimeTableAdapter(getApplicationContext(),firebasehelper.retrieveCourse(majorID, new CourseCallbacks() {
                    @Override
                    public void onCourseCallback(ArrayList<CourseInfo> courseInfos) {

                        lv_CourseList.setAdapter(adapter);

                        ////////////
//                        majors = firebasehelper.retrieveMajor(this);
//                        System.out.println("/////////firebasehelper.retrieveMajor():" + majors);
//                        Major m = new Major();
//                        for (int i = 0; i < majors.size(); i++) {
//                            m = (Major) majors.get(i);
//                            System.out.println("id: " + m.getMajor_id());
//                            System.out.println("name: " + m.getMajor_name());
//                        }

                    }
                }));

        lv_CourseList.setAdapter(adapter);
    }
}
