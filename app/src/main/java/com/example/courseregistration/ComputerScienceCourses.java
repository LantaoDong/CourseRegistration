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

/**
 *
 * This activity retrieves all the CS courses from firebase into a listview
 *
 * Created by Lantao & Haining on 2018-03-25.
 */
public class ComputerScienceCourses extends AppCompatActivity {

    ListView courses;
    ArrayList<String> course = new ArrayList<String>();
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science_courses);
        courses = (ListView) findViewById(R.id.CS);
        back = (Button) findViewById(R.id.back);
        //retrieve cs courses from Firebase into a listview
        //information about computer science courses
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects/computer science");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String courseName = snapshot.child("courseID").getValue().toString();
                    courseName += " "+snapshot.child("courseName").getValue().toString();
                    course.add(courseName);
                }
                ListAdapter adapter = new ArrayAdapter<String>(ComputerScienceCourses.this,android.R.layout.simple_list_item_1,course);
                courses = (ListView) findViewById(R.id.CS);
                courses.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //set click listener for each item of the list
        courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {
                String courseName = String.valueOf(adapterView.getItemAtPosition(i));
                Intent courseDescription = new Intent(ComputerScienceCourses.this,ComputerScienceCoursesDescription.class);
                courseDescription.putExtra("name",courseName);
                startActivity(courseDescription);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToSubject = new Intent(ComputerScienceCourses.this, CourseFilter.class);
                startActivity(backToSubject);
            }
        });
    }
}
