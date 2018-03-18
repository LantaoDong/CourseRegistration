package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Coursechoose extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursechoose);

        final Button button = (Button) findViewById(R.id.button3);

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


        Intent intent = getIntent();
        final String message = intent.getStringExtra("data");
        final String userID = intent.getStringExtra("userID");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                String course1 = dataSnapshot.child("subjects").child(message).child("course 1").child("courseID").getValue(String.class);
                String course2 = dataSnapshot.child("subjects").child(message).child("course 2").child("courseID").getValue(String.class);
                String course3 = dataSnapshot.child("subjects").child(message).child("course 3").child("courseID").getValue(String.class);
                String course4 = dataSnapshot.child("subjects").child(message).child("course 4").child("courseID").getValue(String.class);

                if (message.equals("Computer Science")) {
                    checkbox11.setText(course1);
                    String wcnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistcapacity").getValue().toString();
                    String wnnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("capacity").getValue(String.class);
                    String curnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum1);
                    c1wntextView.setText(wnnum1);
                    c1maxtextView.setText(maxnum1);
                    c1curtextView.setText(curnum1);
                    checkbox12.setText(course2);
                    String wcnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistcapacity").getValue().toString();
                    String wnnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistnum").getValue().toString();
                    String maxnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("capacity").getValue(String.class);
                    String curnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum2);
                    c1wntextView.setText(wnnum2);
                    c1maxtextView.setText(maxnum2);
                    c1curtextView.setText(curnum2);
                    checkbox13.setText(course3);
                    String wcnum3 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistcapacity").getValue().toString();
                    String wnnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("capacity").getValue(String.class);
                    String curnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum3);
                    c1wntextView.setText(wnnum3);
                    c1maxtextView.setText(maxnum3);
                    c1curtextView.setText(curnum3);
                    checkbox14.setText(course4);
                    String wcnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistcapacity").getValue().toString();
                    String wnnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    String curnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum4);
                    c1wntextView.setText(wnnum4);
                    c1maxtextView.setText(maxnum4);
                    c1curtextView.setText(curnum4);
                }
                if (message.equals("Mathematics"))
                {
                    checkbox11.setText(course1);
                    String wcnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistcapacity").getValue().toString();
                    String wnnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("capacity").getValue(String.class);
                    String curnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum1);
                    c1wntextView.setText(wnnum1);
                    c1maxtextView.setText(maxnum1);
                    c1curtextView.setText(curnum1);
                    checkbox12.setText(course2);
                    String wcnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistcapacity").getValue().toString();
                    String wnnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistnum").getValue().toString();
                    String maxnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("capacity").getValue(String.class);
                    String curnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum2);
                    c1wntextView.setText(wnnum2);
                    c1maxtextView.setText(maxnum2);
                    c1curtextView.setText(curnum2);
                    checkbox13.setText(course3);
                    String wcnum3 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistcapacity").getValue().toString();
                    String wnnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("capacity").getValue(String.class);
                    String curnum3 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum3);
                    c1wntextView.setText(wnnum3);
                    c1maxtextView.setText(maxnum3);
                    c1curtextView.setText(curnum3);
                    checkbox14.setText(course4);
                    String wcnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistcapacity").getValue().toString();
                    String wnnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();
                    String maxnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    String curnum4 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);
                    c1wctextView.setText(wcnum4);
                    c1wntextView.setText(wnnum4);
                    c1maxtextView.setText(maxnum4);
                    c1curtextView.setText(curnum4);
                }
                if (message.equals("Statistic"))
                {
                    checkbox11.setText(course1);
                    String wcnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistcapacity").getValue().toString();

                    String wnnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("waitlistnum").getValue().toString();

                    String maxnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("capacity").getValue(String.class);

                    String curnum1 = dataSnapshot.child("subjects").child(message).child("course1").child("numberOfStudents").getValue(String.class);

                    c1wctextView.setText(wcnum1);
                    c1wntextView.setText(wnnum1);
                    c1maxtextView.setText(maxnum1);
                    c1curtextView.setText(curnum1);
                    checkbox12.setText(course2);
                    String wcnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistcapacity").getValue().toString();

                    String wnnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("waitlistnum").getValue().toString();

                    String maxnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("capacity").getValue(String.class);

                    String curnum2 = dataSnapshot.child("subjects").child(message).child("course2").child("numberOfStudents").getValue(String.class);

                    c1wctextView.setText(wcnum2);
                    c1wntextView.setText(wnnum2);
                    c1maxtextView.setText(maxnum2);
                    c1curtextView.setText(curnum2);
                    checkbox13.setText(course3);
                    String wcnum3 = dataSnapshot.child("subjects").child(message).child("course3").child("waitlistcapacity").getValue().toString();

                    String wnnum3 = dataSnapshot.child("subjects").child(message).child("course3").child("waitlistnum").getValue().toString();

                    String maxnum3 = dataSnapshot.child("subjects").child(message).child("course3").child("capacity").getValue(String.class);

                    String curnum3 = dataSnapshot.child("subjects").child(message).child("course3").child("numberOfStudents").getValue(String.class);

                    c1wctextView.setText(wcnum3);
                    c1wntextView.setText(wnnum3);
                    c1maxtextView.setText(maxnum3);
                    c1curtextView.setText(curnum3);
                    checkbox14.setText(course4);
                    String wcnum4 = dataSnapshot.child("subjects").child(message).child("course4").child("waitlistcapacity").getValue().toString();

                    String wnnum4 = dataSnapshot.child("subjects").child(message).child("course4").child("waitlistnum").getValue().toString();

                    String maxnum4 = dataSnapshot.child("subjects").child(message).child("course4").child("numberOfStudents").getValue(String.class);

                    String curnum4 = dataSnapshot.child("subjects").child(message).child("course4").child("numberOfStudents").getValue(String.class);

                    c1wctextView.setText(wcnum4);
                    c1wntextView.setText(wnnum4);
                    c1maxtextView.setText(maxnum4);
                    c1curtextView.setText(curnum4);
                }

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message1 = "";
                        int counter = 0;
                        if (checkbox11.isChecked())
                        {
                            message1 = checkbox11.getText().toString();
                            checkbox12.setEnabled(false);
                            checkbox13.setEnabled(false);
                            checkbox14.setEnabled(false);
                            myRef.child("user").child(userID).child("registered courses").child("course1").push().setValue(message1);
                            String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(num+1);
                            counter = 1;
                        }
                        if (checkbox12.isChecked())
                        {
                            message1 = checkbox12.getText().toString();
                            checkbox11.setEnabled(false);
                            checkbox13.setEnabled(false);
                            checkbox14.setEnabled(false);
                            myRef.child("user").child(userID).child("registered courses").child("course2").push().setValue(message1);
                            String num = dataSnapshot.child("subjects").child(message).child("course 2").child("numberOfStudents").getValue().toString();
                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(num+1);
                            counter = 1;
                        }
                        if (checkbox13.isChecked())
                        {
                            message1 = checkbox13.getText().toString();
                            checkbox11.setEnabled(false);
                            checkbox12.setEnabled(false);
                            checkbox14.setEnabled(false);
                            myRef.child("user").child(userID).child("registered courses").child("course3").push().setValue(message1);
                            String num = dataSnapshot.child("subjects").child(message).child("course 3").child("numberOfStudents").getValue().toString();
                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(num+1);
                            counter = 1;
                        }
                        if (checkbox14.isChecked())
                        {
                            message1 = checkbox14.getText().toString();
                            checkbox11.setEnabled(false);
                            checkbox12.setEnabled(false);
                            checkbox13.setEnabled(false);
                            myRef.child("user").child(userID).child("registered courses").child("course4").push().setValue(message1);
                            String num = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                            myRef.child("subjects").child(message).child("course 4").child("numberOfStudents").setValue(num+1);

                                String check = dataSnapshot.child("users").child(userID).child("learned courses").getValue().toString();
                                if(check.contains("CSCI 1100")){
                                    counter = 1;
                                }
                        }
                        if(counter == 1) {
                            Intent intent = new Intent();
                            intent.setClass(Coursechoose.this, Adddroptable.class);
                            intent.putExtra("userID", userID);
                            startActivity(intent);
                        }
                        else{
                            System.out.print("You need a pre courses.");
                        }
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
