package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;

public class ViewScheduleSingleDay extends AppCompatActivity {

    ListView classesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewscheduleday);

        Intent intent = getIntent();
        final String selectedDay = intent.getStringExtra("day");
        final String userID = intent.getStringExtra("userID");

        TextView dayTextView = (TextView) findViewById(R.id.dayTextView);
        dayTextView.setText(selectedDay+"'s Classes");

        classesListView = (ListView) findViewById(R.id.classesListView);

        /*
        firebaseAdapter = new FirebaseListAdapter<Contact>(this, Contact.class,
                android.R.layout.simple_list_item_1, appData.firebaseReference) {
            @Override
            protected void populateView(View v, Contact model, int position) {
                /*
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.buisnessname);
                *//*
            }
        };
        classesListView.setAdapter(firebaseAdapter);
        classesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(ViewScheduleSingleDay.this, ViewScheduleSingleDayDetail.class);


            }
        });
        */

    }
}
