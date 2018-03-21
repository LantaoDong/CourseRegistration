package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewScheduleSingleDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewscheduleday);

        Intent intent = getIntent();
        final String selectedDay = intent.getStringExtra("day");
        final String userID = intent.getStringExtra("userID");

        TextView dayTextView = (TextView) findViewById(R.id.dayTextView);
        dayTextView.setText(selectedDay+"'s Classes");
        


    }
}
