package com.example.courseregistration;
import com.example.courseregistration.DBHelper.FirebaseHelper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.courseregistration.models.Courses;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class Coursechoose extends AppCompatActivity {
    Button back;
    Button next;

    //FirebaseHelper firebasehelper;
    /**
     * Created by Yiran Deng & Jiabin Liu on 2018-04-08.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursechoose);

        back = (Button) findViewById(R.id.back);

        next = (Button) findViewById(R.id.button3);
        final Button summer = (Button) findViewById(R.id.button10);
        final Button fall = (Button) findViewById(R.id.button11);

        final CheckBox checkbox11 = (CheckBox) findViewById(R.id.checkBox11);
        final CheckBox checkbox12 = (CheckBox) findViewById(R.id.checkBox12);
        final CheckBox checkbox13 = (CheckBox) findViewById(R.id.checkBox13);
        final CheckBox checkbox14 = (CheckBox) findViewById(R.id.checkBox14);

        final TextView c1wctextView = (TextView) findViewById(R.id.c1wctextView);
        final TextView c1wntextView = (TextView) findViewById(R.id.c1wntextView);
        final TextView c1maxtextView = (TextView) findViewById(R.id.c1maxtextView);
        final TextView c1curtextView = (TextView) findViewById(R.id.c1curtextView);
        final TextView c2wctextView = (TextView) findViewById(R.id.c2wctextView);
        final TextView c2wntextView = (TextView) findViewById(R.id.c2wntextView);
        final TextView c2maxtextView = (TextView) findViewById(R.id.c2maxtextView);
        final TextView c2curtextView = (TextView) findViewById(R.id.c2curtextView);
        final TextView c3wctextView = (TextView) findViewById(R.id.c3wctextView);
        final TextView c3wntextView = (TextView) findViewById(R.id.c3wntextView);
        final TextView c3maxtextView = (TextView) findViewById(R.id.c3maxtextView);
        final TextView c3curtextView = (TextView) findViewById(R.id.c3curtextView);
        final TextView c4wctextView = (TextView) findViewById(R.id.c4wctextView);
        final TextView c4wntextView = (TextView) findViewById(R.id.c4wntextView);
        final TextView c4maxtextView = (TextView) findViewById(R.id.c4maxtextView);
        final TextView c4curtextView = (TextView) findViewById(R.id.c4curtextView);
        checkbox11.setText("No course");
        checkbox12.setText("No course");
        checkbox13.setText("No course");
        checkbox14.setText("No course");
        checkbox11.setEnabled(false);
        checkbox12.setEnabled(false);
        checkbox13.setEnabled(false);
        checkbox14.setEnabled(false);

        Intent intent = getIntent();
        final String message = intent.getStringExtra("data");
        final String userID = intent.getStringExtra("userID");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final DatabaseReference courseRef = myRef.child("subjects").child(message);

        //notification build
        final NotificationManager notificationManager = (NotificationManager) getSystemService
                (NOTIFICATION_SERVICE);
        final String NOTIFICATION_CHANNEL_ID = "4565";
        final String NOTIFICATION_CHANNEL_NAME="conflict";
        CharSequence channelName = NOTIFICATION_CHANNEL_NAME;
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importance);
        notificationManager.createNotificationChannel(notificationChannel);

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);





        //add term function well
        courseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                summer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> courses = new ArrayList<String>();
                        checkbox11.setEnabled(true);
                        checkbox12.setEnabled(true);
                        checkbox13.setEnabled(true);
                        checkbox14.setEnabled(true);
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if(snapshot.child("term").getValue().toString().equals("1")) {
                                String courseKey = snapshot.getKey().toString();
                                courses.add(courseKey);
                            }
                        }

                        if(courses.size() <= 4 && courses.size() > 0) {

                            checkbox11.setText(courses.get(0).toString());
                            String wcnum1 = dataSnapshot.child(courses.get(0).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum1 = dataSnapshot.child(courses.get(0).toString()).child("waitlistnum").getValue().toString();
                            String maxnum1 = dataSnapshot.child(courses.get(0).toString()).child("capacity").getValue().toString();
                            String curnum1 = dataSnapshot.child(courses.get(0).toString()).child("numberOfStudents").getValue().toString();
                            c1wctextView.setText(wcnum1);
                            c1wntextView.setText(wnnum1);
                            c1maxtextView.setText(maxnum1);
                            c1curtextView.setText(curnum1);
                        }
                        if(courses.size() <= 4 && courses.size() > 1) {

                            checkbox12.setText(courses.get(1).toString());
                            String wcnum2 = dataSnapshot.child(courses.get(1).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum2 = dataSnapshot.child(courses.get(1).toString()).child("waitlistnum").getValue().toString();
                            String maxnum2 = dataSnapshot.child(courses.get(1).toString()).child("capacity").getValue().toString();
                            String curnum2 = dataSnapshot.child(courses.get(1).toString()).child("numberOfStudents").getValue().toString();
                            c2wctextView.setText(wcnum2);
                            c2wntextView.setText(wnnum2);
                            c2maxtextView.setText(maxnum2);
                            c2curtextView.setText(curnum2);
                        }
                        if(courses.size() <= 4 && courses.size() > 2) {

                            checkbox13.setText(courses.get(2).toString());
                            String wcnum3 = dataSnapshot.child(courses.get(2).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum3 = dataSnapshot.child(courses.get(2).toString()).child("waitlistnum").getValue().toString();
                            String maxnum3 = dataSnapshot.child(courses.get(2).toString()).child("capacity").getValue().toString();
                            String curnum3 = dataSnapshot.child(courses.get(2).toString()).child("numberOfStudents").getValue().toString();
                            c3wctextView.setText(wcnum3);
                            c3wntextView.setText(wnnum3);
                            c3maxtextView.setText(maxnum3);
                            c3curtextView.setText(curnum3);
                        }
                        if(courses.size() <= 4 && courses.size() > 3) {

                            checkbox14.setText(courses.get(3).toString());
                            String wcnum4 = dataSnapshot.child(courses.get(3).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum4 = dataSnapshot.child(courses.get(3).toString()).child("waitlistnum").getValue().toString();
                            String maxnum4 = dataSnapshot.child(courses.get(3).toString()).child("capacity").getValue().toString();
                            String curnum4 = dataSnapshot.child(courses.get(3).toString()).child("numberOfStudents").getValue().toString();
                            c4wctextView.setText(wcnum4);
                            c4wntextView.setText(wnnum4);
                            c4maxtextView.setText(maxnum4);
                            c4curtextView.setText(curnum4);
                        }
                        if(checkbox11.getText().toString().equals("No course")){
                            checkbox11.setEnabled(false);
                        }
                        if(checkbox12.getText().toString().equals("No course")){
                            checkbox12.setEnabled(false);
                        }
                        if(checkbox13.getText().toString().equals("No course")){
                            checkbox13.setEnabled(false);
                        }
                        if(checkbox14.getText().toString().equals("No course")){
                            checkbox14.setEnabled(false);
                        }
                    }
                });
                fall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> courses = new ArrayList<String>();
                        checkbox11.setEnabled(true);
                        checkbox12.setEnabled(true);
                        checkbox13.setEnabled(true);
                        checkbox14.setEnabled(true);
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if(snapshot.child("term").getValue().toString().equals("2")) {
                                String courseKey = snapshot.getKey().toString();
                                courses.add(courseKey);
                            }
                        }
                        if(courses.size() <= 4 && courses.size() > 0) {

                            checkbox11.setText(courses.get(0).toString());
                            String wcnum1 = dataSnapshot.child(courses.get(0).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum1 = dataSnapshot.child(courses.get(0).toString()).child("waitlistnum").getValue().toString();
                            String maxnum1 = dataSnapshot.child(courses.get(0).toString()).child("capacity").getValue().toString();
                            String curnum1 = dataSnapshot.child(courses.get(0).toString()).child("numberOfStudents").getValue().toString();
                            c1wctextView.setText(wcnum1);
                            c1wntextView.setText(wnnum1);
                            c1maxtextView.setText(maxnum1);
                            c1curtextView.setText(curnum1);
                        }
                        if(courses.size() <= 4 && courses.size() > 1) {

                            checkbox12.setText(courses.get(1).toString());
                            String wcnum2 = dataSnapshot.child(courses.get(1).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum2 = dataSnapshot.child(courses.get(1).toString()).child("waitlistnum").getValue().toString();
                            String maxnum2 = dataSnapshot.child(courses.get(1).toString()).child("capacity").getValue().toString();
                            String curnum2 = dataSnapshot.child(courses.get(1).toString()).child("numberOfStudents").getValue().toString();
                            c2wctextView.setText(wcnum2);
                            c2wntextView.setText(wnnum2);
                            c2maxtextView.setText(maxnum2);
                            c2curtextView.setText(curnum2);
                        }
                        if(courses.size() <= 4 && courses.size() > 2) {

                            checkbox13.setText(courses.get(2).toString());
                            String wcnum3 = dataSnapshot.child(courses.get(2).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum3 = dataSnapshot.child(courses.get(2).toString()).child("waitlistnum").getValue().toString();
                            String maxnum3 = dataSnapshot.child(courses.get(2).toString()).child("capacity").getValue().toString();
                            String curnum3 = dataSnapshot.child(courses.get(2).toString()).child("numberOfStudents").getValue().toString();
                            c3wctextView.setText(wcnum3);
                            c3wntextView.setText(wnnum3);
                            c3maxtextView.setText(maxnum3);
                            c3curtextView.setText(curnum3);
                        }
                        if(courses.size() <= 4 && courses.size() > 3) {

                            checkbox14.setText(courses.get(3).toString());
                            String wcnum4 = dataSnapshot.child(courses.get(3).toString()).child("waitlistcapacity").getValue().toString();
                            String wnnum4 = dataSnapshot.child(courses.get(3).toString()).child("waitlistnum").getValue().toString();
                            String maxnum4 = dataSnapshot.child(courses.get(3).toString()).child("capacity").getValue().toString();
                            String curnum4 = dataSnapshot.child(courses.get(3).toString()).child("numberOfStudents").getValue().toString();
                            c4wctextView.setText(wcnum4);
                            c4wntextView.setText(wnnum4);
                            c4maxtextView.setText(maxnum4);
                            c4curtextView.setText(curnum4);
                        }
                        if(checkbox11.getText().toString().equals("No course")){
                            checkbox11.setEnabled(false);
                        }
                        if(checkbox12.getText().toString().equals("No course")){
                            checkbox12.setEnabled(false);
                        }
                        if(checkbox13.getText().toString().equals("No course")){
                            checkbox13.setEnabled(false);
                        }
                        if(checkbox14.getText().toString().equals("No course")){
                            checkbox14.setEnabled(false);
                        }
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // set checkbox with the courses user can choose
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String message1 = "";
                        if (checkbox11.isChecked()) {
                            message1 = checkbox11.getText().toString();
                            ArrayList<String> rcourses = new ArrayList<String>();
                            for (DataSnapshot snapshot : dataSnapshot.child("users").child(userID).child("registered courses").getChildren()) {
                                String courseKey = snapshot.getKey().toString();
                                rcourses.add(courseKey);
                            }
                            String courseID = dataSnapshot.child("subjects").child(message).child(message1).child("courseID").getValue().toString();
                            String subject = message;
                            String starttime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString();
                            String endtime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString();
                            String term = dataSnapshot.child("subjects").child(message).child(message1).child("term").getValue().toString();

                            Courses r = new Courses(courseID, subject, starttime, endtime, days,term);
                            myRef.child("users").child(userID).child("registered courses").child(courseID).setValue(r);
                            int check = 1 ;
                            for (int i = 0; i < rcourses.size(); i++) {
                                if (dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("days").getValue().toString().equals(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString())) {
                                    int start1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("starttime").getValue().toString());
                                    int end1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("endtime").getValue().toString());
                                    int start = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString());
                                    int end = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString());
                                    if ((end >= start1 && end <= end1) || (start1 <= start && start <= end1)&&!rcourses.get(i).toString().equals(message1)) {
                                        check = 0;
                                    }
                                    if(rcourses.get(i).toString().equals(message1)) {
                                        check = 2;
                                    }
                                }
                            }

                            if(check == 0) {
                                Toast.makeText(Coursechoose.this, "You have registered a conflict course.", Toast.LENGTH_LONG).show();
                                myRef.child("users").child(userID).child("registered courses").child(message1).removeValue();

                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a conflict course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(1, mBuilder.build());
                            }
                            if(check == 2) {
                                Toast.makeText(Coursechoose.this, "You have registered a repeated course.", Toast.LENGTH_LONG).show();

                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a repeated course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(1, mBuilder.build());
                            }
                            //used to check the conflict class
                            String num = dataSnapshot.child("subjects").child(message).child(message1).child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child(message1).child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child(message1).child("waitlistnum").getValue().toString();

                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap == numint) {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child(message1).child("waitlistnum").setValue(numintwaitnum1);
                                checkbox11.setChecked(false);
                            } else {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child(message1).child("numberOfStudents").setValue(numint1);
                                checkbox11.setChecked(false);
                            }
                        }

                        if (checkbox12.isChecked()) {
                            message1 = checkbox12.getText().toString();
                            ArrayList<String> rcourses = new ArrayList<String>();
                            for (DataSnapshot snapshot : dataSnapshot.child("users").child(userID).child("registered courses").getChildren()) {
                                String courseKey = snapshot.getKey().toString();
                                rcourses.add(courseKey);
                            }
                            String courseID = dataSnapshot.child("subjects").child(message).child(message1).child("courseID").getValue().toString();
                            String subject = message;
                            String starttime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString();
                            String endtime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString();
                            String term = dataSnapshot.child("subjects").child(message).child(message1).child("term").getValue().toString();
                            Courses r = new Courses(courseID, subject, starttime, endtime, days, term);
                            myRef.child("users").child(userID).child("registered courses").child(courseID).setValue(r);
                            int check = 1;
                            for (int i = 0; i < rcourses.size(); i++) {
                                if (dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("days").getValue().toString().equals(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString())) {
                                    int start1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("starttime").getValue().toString());
                                    int end1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("endtime").getValue().toString());
                                    int start = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString());
                                    int end = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString());
                                    if ((end >= start1 && end <= end1) || (start1 <= start && start <= end1)&&!rcourses.get(i).toString().equals(message1)) {
                                        check = 0;
                                    }
                                    if(rcourses.get(i).toString().equals(message1)) {
                                        check = 2;
                                    }
                                }
                            }

                            if(check == 0) {
                                Toast.makeText(Coursechoose.this, "You have registered a conflict course.", Toast.LENGTH_LONG).show();
                                myRef.child("users").child(userID).child("registered courses").child(message1).removeValue();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a conflict course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            if(check == 2) {
                                Toast.makeText(Coursechoose.this, "You have registered a repeated course.", Toast.LENGTH_LONG).show();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a repeated course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            String num = dataSnapshot.child("subjects").child(message).child(message1).child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child(message1).child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child(message1).child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);

                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child(message1).child("numberOfStudents").setValue(numint1);
                                checkbox12.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child(message1).child("waitlistnum").setValue(numintwaitnum1);
                                checkbox12.setChecked(false);
                            }
                        }
                        if (checkbox13.isChecked()) {
                            message1 = checkbox13.getText().toString();
                            ArrayList<String> rcourses = new ArrayList<String>();
                            for (DataSnapshot snapshot : dataSnapshot.child("users").child(userID).child("registered courses").getChildren()) {
                                String courseKey = snapshot.getKey().toString();
                                rcourses.add(courseKey);
                            }
                            String courseID = dataSnapshot.child("subjects").child(message).child(message1).child("courseID").getValue().toString();
                            String subject = message;
                            String starttime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString();
                            String endtime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString();
                            String term = dataSnapshot.child("subjects").child(message).child(message1).child("term").getValue().toString();
                            Courses r = new Courses(courseID, subject, starttime, endtime, days, term);
                            myRef.child("users").child(userID).child("registered courses").child(courseID).setValue(r);
                            int check = 1;
                            for (int i = 0; i < rcourses.size(); i++) {
                                if (dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("days").getValue().toString().equals(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString())) {
                                    int start1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("starttime").getValue().toString());
                                    int end1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("endtime").getValue().toString());
                                    int start = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString());
                                    int end = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString());
                                    if ((end >= start1 && end <= end1) || (start1 <= start && start <= end1)&&!rcourses.get(i).toString().equals(message1)) {
                                        check = 0;
                                    }
                                    if(rcourses.get(i).toString().equals(message1)) {
                                        check = 2;
                                    }
                                }
                            }

                            if(check == 0) {
                                Toast.makeText(Coursechoose.this, "You have registered a conflict course.", Toast.LENGTH_LONG).show();
                                myRef.child("users").child(userID).child("registered courses").child(message1).removeValue();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a conflict course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            if(check == 2) {
                                Toast.makeText(Coursechoose.this, "You have registered a repeated course.", Toast.LENGTH_LONG).show();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a repeated course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            String num = dataSnapshot.child("subjects").child(message).child(message1).child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child(message1).child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child(message1).child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child(message1).child("numberOfStudents").setValue(numint1);
                                checkbox13.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child(message1).child("waitlistnum").setValue(numintwaitnum1);
                                checkbox13.setChecked(false);
                            }
                        }

                        if (checkbox14.isChecked()) {
                            message1 = checkbox14.getText().toString();
                            ArrayList<String> rcourses = new ArrayList<String>();
                            for (DataSnapshot snapshot : dataSnapshot.child("users").child(userID).child("registered courses").getChildren()) {
                                String courseKey = snapshot.getKey().toString();
                                rcourses.add(courseKey);
                            }
                            String courseID = dataSnapshot.child("subjects").child(message).child(message1).child("courseID").getValue().toString();
                            String subject = message;
                            String starttime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString();
                            String endtime = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString();
                            String days = dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString();
                            String term = dataSnapshot.child("subjects").child(message).child(message1).child("term").getValue().toString();
                            Courses r = new Courses(courseID, subject, starttime, endtime, days, term);
                            myRef.child("users").child(userID).child("registered courses").child(courseID).setValue(r);
                            int check = 1;
                            for (int i = 0; i < rcourses.size(); i++) {
                                if (dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("days").getValue().toString().equals(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("days").getValue().toString())) {
                                    int start1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("starttime").getValue().toString());
                                    int end1 = Integer.parseInt(dataSnapshot.child("users").child(userID).child("registered courses").child(rcourses.get(i).toString()).child("endtime").getValue().toString());
                                    int start = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("start").getValue().toString());
                                    int end = Integer.parseInt(dataSnapshot.child("subjects").child(message).child(message1).child("time").child("end").getValue().toString());
                                    if ((end >= start1 && end <= end1) || (start1 <= start && start <= end1)&&!rcourses.get(i).toString().equals(message1)) {
                                        check = 0;
                                    }
                                    if(rcourses.get(i).toString().equals(message1)) {
                                        check = 2;
                                    }
                                }
                            }

                            if(check == 0) {
                                Toast.makeText(Coursechoose.this, "You have registered a conflict course.", Toast.LENGTH_LONG).show();
                                myRef.child("users").child(userID).child("registered courses").child(message1).removeValue();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a conflict course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            if(check == 2) {
                                Toast.makeText(Coursechoose.this, "You have registered a repeated course.", Toast.LENGTH_LONG).show();
                                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                                mBuilder.setContentTitle("conflict");
                                mBuilder.setContentText("You have registered a repeated course.");
                                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                                mBuilder.setTicker("CONFLICT!!!");
                                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                notificationManager.notify(10, mBuilder.build());
                            }
                            String num = dataSnapshot.child("subjects").child(message).child(message1).child("numberOfStudents").getValue().toString();
                            String numcap = dataSnapshot.child("subjects").child(message).child(message1).child("capacity").getValue().toString();
                            String numwaitnum = dataSnapshot.child("subjects").child(message).child(message1).child("waitlistnum").getValue().toString();
                            int numint = Integer.parseInt(num);
                            int numintcap = Integer.parseInt(numcap);
                            int numintwaitnum = Integer.parseInt(numwaitnum);
                            if (numintcap > numint) {
                                int numint1 = numint + 1;
                                myRef.child("subjects").child(message).child(message1).child("numberOfStudents").setValue(numint1);
                                checkbox14.setChecked(false);
                            } else {
                                int numintwaitnum1 = numintwaitnum + 1;
                                myRef.child("subjects").child(message).child(message1).child("waitlistnum").setValue(numintwaitnum1);
                                checkbox14.setChecked(false);
                            }

                            Toast.makeText(Coursechoose.this, "This courses need a special pre courses", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent();
                            intent.setClass(Coursechoose.this, Adddroptable.class);
                        }

                        Intent intent = new Intent();
                        intent.setClass(Coursechoose.this, Adddroptable.class);
                        intent.putExtra("userID", userID);
                        intent.putExtra("message", message);

                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Coursechoose.this, Departmentchoose.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
                finish();
            }
        });


    }

}





