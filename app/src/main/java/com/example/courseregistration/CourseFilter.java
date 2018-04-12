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
 * Created by Haofan & Tianyi on 2018-04-08.
 */
public class CourseFilter extends AppCompatActivity{
    Button back;
    ListView subjects;
    final ArrayList<String> majors = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_filter);
        back = (Button) findViewById(R.id.back);
        subjects = (ListView) findViewById(R.id.subject);
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    majors.add(snapshot.getKey());

                }
                ListAdapter adapter = new ArrayAdapter<String>(CourseFilter.this,android.R.layout.simple_list_item_1,majors);
                subjects = (ListView) findViewById(R.id.subject);
                subjects.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        subjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String subject = String.valueOf(adapterView.getItemAtPosition(i));
                if(subject.equals("Statistics")){
                    Intent intentToStatistics = new Intent(CourseFilter.this,StatisticsCourses.class);
                    startActivity(intentToStatistics);
                }
                if(subject.equals("computer science")){
                    Intent intentToCS = new Intent(CourseFilter.this, ComputerScienceCourses.class);
                    startActivity(intentToCS);
                }
                if(subject.equals("math")){
                    Intent intentToMath = new Intent(CourseFilter.this,MathCourses.class);
                    startActivity(intentToMath);
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToUser = new Intent(CourseFilter.this, UserActivity.class);
                startActivity(intentToUser);
            }
        });






    }



}

