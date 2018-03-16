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

        Intent intent = getIntent();
        final String message = intent.getStringExtra("data");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("subjects");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String course1 = dataSnapshot.child("computer science").child("course 1").child("courseID").getValue(String.class);
                String course2 = dataSnapshot.child("computer science").child("course 2").child("courseID").getValue(String.class);
                String course3 = dataSnapshot.child("computer science").child("course 3").child("courseID").getValue(String.class);
                String course4 = dataSnapshot.child("computer science").child("course 4").child("courseID").getValue(String.class);
                String course5 = dataSnapshot.child("math").child("course 1").child("courseID").getValue(String.class);
                String course6 = dataSnapshot.child("math").child("course 2").child("courseID").getValue(String.class);
                String course7 = dataSnapshot.child("math").child("course 3").child("courseID").getValue(String.class);
                String course8 = dataSnapshot.child("math").child("course 4").child("courseID").getValue(String.class);
                String course9 = dataSnapshot.child("Statistics").child("course 4").child("courseID").getValue(String.class);
                String course10 = dataSnapshot.child("Statistics").child("course 4").child("courseID").getValue(String.class);
                String course11 = dataSnapshot.child("Statistics").child("course 4").child("courseID").getValue(String.class);
                String course12 = dataSnapshot.child("Statistics").child("course 4").child("courseID").getValue(String.class);
                if(message.equals("Computer Science"))
                {
                    checkbox11.setText(course1);
                    checkbox12.setText(course2);
                    checkbox13.setText(course3);
                    checkbox14.setText(course4);
                }
                if(message.equals("Mathematics"))

                {
                    checkbox11.setText(course5);
                    checkbox12.setText(course6);
                    checkbox13.setText(course7);
                    checkbox14.setText(course8);
                }
                if(message.equals("Statistic"))

                {
                    checkbox11.setText(course9);
                    checkbox12.setText(course10);
                    checkbox13.setText(course11);
                    checkbox14.setText(course12);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        if(message.equals("Economic"))

        {
            checkbox11.setText("ECON1015");
            checkbox12.setText("ECON1016");
            checkbox13.setText("ECON2015");
            checkbox14.setText("ECON3015");
        }
        if(message.equals("Commence"))

        {
            checkbox11.setText("COMM1231");
            checkbox12.setText("COMM1232");
            checkbox13.setText("COMM2231");
            checkbox14.setText("COMM3231");
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message1 = "";
                if(checkbox11.isChecked())

                {
                    message1 = checkbox11.getText().toString();
                    checkbox12.setEnabled(false);
                    checkbox13.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox12.isChecked())

                {
                    message1 = checkbox12.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox13.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox13.isChecked())

                {
                    message1 = checkbox13.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox12.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox14.isChecked())

                {
                    message1 = checkbox14.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox12.setEnabled(false);
                    checkbox13.setEnabled(false);
                }
                Intent intent = new Intent();
                intent.setClass(Coursechoose.this, Adddroptable.class);
                intent.putExtra("data1", message1);
                startActivity(intent);
            }
        });
    }
}
