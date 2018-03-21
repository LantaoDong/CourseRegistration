package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.*;

public class Adddroptable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddroptable);

        final TextView textView1 = (TextView) findViewById(R.id.textView4);
        final TextView textView2 = (TextView) findViewById(R.id.textView5);
        final TextView textView3 = (TextView) findViewById(R.id.textView6);
        final TextView textView4 = (TextView) findViewById(R.id.textView7);

        final Button button2 = (Button) findViewById(R.id.button4);
        final Button button3 = (Button) findViewById(R.id.button5);
        final Button button4 = (Button) findViewById(R.id.button6);
        final Button button5 = (Button) findViewById(R.id.button7);
        final Button button6 = (Button) findViewById(R.id.button8);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");

        final DatabaseReference usRef = myRef.child("users");
        final DatabaseReference usidRef = usRef.child(userID);
        final DatabaseReference rcRef = usidRef.child("registered courses");


        rcRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            String course1 = dataSnapshot.child("course 1").child("courseID").getValue().toString();
                                            textView1.setText(course1);
                                            String course2 = dataSnapshot.child("course 2").child("courseID").getValue().toString();
                                            textView2.setText(course2);
                                            String course3 = dataSnapshot.child("course 3").child("courseID").getValue().toString();
                                            textView3.setText(course3);
                                            String course4 = dataSnapshot.child("course 4").child("courseID").getValue().toString();
                                            textView4.setText(course4);
                                        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView1.setText("null");
                rcRef.child("course 1").child("courseID").setValue("null");
                rcRef.child("course 1").child("subject").setValue("null");
                rcRef.child("course 1").child("time").setValue("null");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView2.setText("null");
                rcRef.child("course 2").child("courseID").setValue("null");
                rcRef.child("course 2").child("subject").setValue("null");
                rcRef.child("course 2").child("time").setValue("null");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView3.setText("null");
                rcRef.child("course 3").child("courseID").setValue("null");
                rcRef.child("course 3").child("subject").setValue("null");
                rcRef.child("course 3").child("time").setValue("null");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView4.setText("null");
                rcRef.child("course 4").child("courseID").setValue("null");
                rcRef.child("course 4").child("subject").setValue("null");
                rcRef.child("course 4").child("time").setValue("null");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Adddroptable.this, Departmentchoose.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });

    }
}
