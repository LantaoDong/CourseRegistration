package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatisticsCourses extends AppCompatActivity {
    ListView courses;
    ArrayList<String> course = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_courses);
        courses = (ListView) findViewById(R.id.statistics);
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects/Statistics");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String courseName = snapshot.child("courseID").getValue().toString();
                    course.add(courseName);
                }
                ListAdapter adapter = new ArrayAdapter<String>(StatisticsCourses.this,android.R.layout.simple_list_item_1,course);
                courses = (ListView) findViewById(R.id.statistics);
                courses.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
