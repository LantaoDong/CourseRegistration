package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_courses);
        courses = (ListView) findViewById(R.id.statistics);
        back = (Button) findViewById(R.id.back);
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects/Statistics");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String courseName = snapshot.child("courseID").getValue().toString();
                    courseName+=" "+snapshot.child("courseName").getValue().toString();
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
        courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                String courseName = String.valueOf(adapterView.getItemAtPosition(i));
                Intent courseDescription = new Intent(StatisticsCourses.this,StatisticsCoursesDescription.class);
                courseDescription.putExtra("name",courseName);
                startActivity(courseDescription);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToSubject = new Intent(StatisticsCourses.this, CourseFilter.class);
                startActivity(backToSubject);
            }
        });
    }
}
