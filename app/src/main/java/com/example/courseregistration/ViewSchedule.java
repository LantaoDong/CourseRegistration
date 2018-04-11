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


public class ViewSchedule extends AppCompatActivity{


    private ListView daysListView;
    private Button returnToUser;
    ArrayAdapter daysadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewschedule);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final String selectedSemester = intent.getStringExtra("semester");

        returnToUser = (Button) findViewById(R.id.ReturnToUser);


        daysListView = (ListView) findViewById(R.id.lstView);
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        daysadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, days);
        daysListView.setAdapter(daysadapter);

        daysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedDay = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(ViewSchedule.this, ViewScheduleSingleDay.class);
                intent.putExtra("day", selectedDay);
                intent.putExtra("userID", userID);
                intent.putExtra("semester", selectedSemester);

                startActivity(intent);
            }
        });

        returnToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToD = new Intent(ViewSchedule.this, ViewScheduleSemester.class);
                intentToD.putExtra("userID", userID);
                startActivity(intentToD);
            }


        });

    }
}