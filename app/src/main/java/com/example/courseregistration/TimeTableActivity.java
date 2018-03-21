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
    String majorID;

    //////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //GET INTENT
        Intent intent = this.getIntent();
        majorID = intent.getStringExtra("MAJOR_ID");

        //////////////////////
//        System.out.println("MAJORID from intent: "+majorID);

        lv_CourseList = (ListView) findViewById(R.id.lv_CourseList);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();

        db.child("CourseInfo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<CourseInfo> courseInfos = new ArrayList<>();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    CourseInfo courseInfo = ds.getValue(CourseInfo.class);

                    //TEST
                    System.out.println("$$$$$CourseInfo_ID: "+courseInfo.getCourse_id());

                    if (courseInfo != null && courseInfo.getCourse_id() != null) {
                        courseInfos.add(courseInfo);
                    }

//                    courseCallbacks.onCourseCallback(courseInfos);

                }

                ////TEST
                System.out.println("*****courseInfos " + courseInfos);
                CourseInfo c = new CourseInfo();
                for (int i = 0; i < courseInfos.size(); i++) {
                    c = (CourseInfo) courseInfos.get(i);
                    System.out.println("course_id: " + c.getCourse_id());
                    System.out.println("course_name: " + c.getCourse_name());
                    System.out.println("course_section: " + c.getCourse_section());
                    System.out.println("course_type: " + c.getCourse_type());
                    System.out.println("course_crdhrs: " + c.getCourse_crdhrs());
                    System.out.println("course_avaliable: " + c.getCourse_available());


                }


                if (!courseInfos.isEmpty()){
                    adapter= new TimeTableAdapter(getApplicationContext(), courseInfos);
                    lv_CourseList.setAdapter(adapter);
                }


//                courseCallbacks.onCourseCallback(courseInfos);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        ///////////test1
//        adapter= new TimeTableAdapter(getApplicationContext(), readCourses(majorID, new CourseCallbacks() {
//            @Override
//            public void onCourseCallback(ArrayList<CourseInfo> courseInfos) {
//                lv_CourseList.setAdapter(adapter);
//
//            }
//        }));

//        lv_CourseList.setAdapter(adapter);


//        firebasehelper=new FirebaseHelper(db);
//
//        //ADAPTER
//        adapter = new TimeTableAdapter(getApplicationContext(),firebasehelper.retrieveCourse(majorID, new CourseCallbacks() {
//                    @Override
//                    public void onCourseCallback(ArrayList<CourseInfo> courseInfos) {
//
//                        ////////////
//                        courseInfos = firebasehelper.retrieveCourse("0001",this);
//                        System.out.println("*****firebasehelper.retrieveCourse():" + courseInfos);
//                        CourseInfo c = new CourseInfo();
//                        for (int i = 0; i < courseInfos.size(); i++) {
//                            c = (CourseInfo) courseInfos.get(i);
//                            System.out.println("course_id: " + c.getCourse_id());
//                            System.out.println("course_name: " + c.getCourse_name());
//                        }
//
//                        lv_CourseList.setAdapter(adapter);
//
//
//                    }
//                }));

//        lv_CourseList.setAdapter(adapter);
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
////        readCourses(new CourseCallbacks() {
////            @Override
////            public void onCourseCallback(ArrayList<CourseInfo> courseInfos) {
////                adapter = new TimeTableAdapter(getApplicationContext(), courseInfos);
////                lv_CourseList.setAdapter(adapter);
////            }
////        });
//
////        readCourses();
//
//
////        db.addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////
////                ArrayList<CourseInfo> courseInfos = new ArrayList<>();
////
////                for (DataSnapshot ds : dataSnapshot.getChildren()) {
////                    CourseInfo courseInfo = ds.getValue(CourseInfo.class);
////
////                    //TEST
////                    System.out.println("$$$$$CourseInfo_ID: "+courseInfo.getCourse_id());
////
////                    if (courseInfo != null && courseInfo.getCourse_id() != null) {
////                        courseInfos.add(courseInfo);
////                    }
////
//////                    courseCallbacks.onCourseCallback(courseInfos);
////
////                }
////                adapter= new TimeTableAdapter(getApplicationContext(), courseInfos);
////                lv_CourseList.setAdapter(adapter);
////
//////                courseCallbacks.onCourseCallback(courseInfos);
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////
////            }
////
////
////        });
//    }
//
//    public void readCourses(){
//
//        final ArrayList<CourseInfo> courseInfos = new ArrayList<>();
//
//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    CourseInfo courseInfo = ds.getValue(CourseInfo.class);
//
//                    //////////
//                    System.out.println("$$$$$CourseInfo_ID: "+courseInfo.getCourse_id());
//
//                    if (courseInfo != null && courseInfo.getCourse_id() != null) {
//                        courseInfos.add(courseInfo);
//                    }
//
////                    courseCallbacks.onCourseCallback(courseInfos);
//
//                }
//                adapter= new TimeTableAdapter(getApplicationContext(), courseInfos);
//                lv_CourseList.setAdapter(adapter);
//
////                courseCallbacks.onCourseCallback(courseInfos);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//
//
//        });
//
//    }
//
}
