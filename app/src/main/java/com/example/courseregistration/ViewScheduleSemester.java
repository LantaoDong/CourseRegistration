package com.example.courseregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewScheduleSemester extends AppCompatActivity{


    private ListView semestersListView;
    ArrayAdapter semesteradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewschedulesemester);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");

        semestersListView = (ListView) findViewById(R.id.semesterListView);
        ArrayList<String> semesters = new ArrayList<String>();
        semesters.add("Fall");
        semesters.add("Winter");
        semesters.add("Summer");
        semesteradapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, semesters);
        semestersListView.setAdapter(semesteradapter);

        semestersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedSemester = String.valueOf(parent.getItemAtPosition(position));

                Intent intent = new Intent(ViewScheduleSemester.this, ViewSchedule.class);
                intent.putExtra("semester", selectedSemester);
                intent.putExtra("userID", userID);

                startActivity(intent);
            }
        });

    }
}