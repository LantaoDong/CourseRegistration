package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jaspering21 & Justin on 2018-03-20.
 */
public class Semesters extends AppCompatActivity {
    private ListView semestersListView;
    private Button back;
    ArrayAdapter semesterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesters);
        back = (Button) findViewById(R.id.back);
        final Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        semestersListView = (ListView) findViewById(R.id.semester);
        ArrayList<String> semesters = new ArrayList<String>();
        semesters.add("Fall");
        semesters.add("Summer");
        semesterAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, semesters);
        semestersListView.setAdapter(semesterAdapter);
        semestersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedSemester = String.valueOf(parent.getItemAtPosition(position));

                Intent intent = new Intent(Semesters.this, ViewCourses.class);
                intent.putExtra("semester", selectedSemester);
                intent.putExtra("userID", userID);

                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Semesters.this, UserActivity.class);
                intent1.putExtra("userID",userID);
                startActivity(intent1);
            }
        });
    }
}
