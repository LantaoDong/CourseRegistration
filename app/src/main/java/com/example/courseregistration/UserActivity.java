package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    private Button back;
    private Button drop;
    private Button timeTable;
    private Button viewSchedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        back = (Button) findViewById(R.id.backToLogin);
        timeTable = (Button) findViewById(R.id.timeTable);
        viewSchedule = (Button) findViewById(R.id.schedule);
        drop = (Button) findViewById(R.id.drop);
        //.
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToLogin = new Intent(UserActivity.this,LoginActivity.class);
                startActivity(backToLogin);
            }
        });

        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToTimeTable = new Intent(UserActivity.this,MajorListActivity.class);
                startActivity(intentToTimeTable);
            }
        });
        viewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewSche = new Intent(UserActivity.this,SchduleActivity.class);
                startActivity(viewSche);
            }
        });
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToD = new Intent(UserActivity.this, Departmentchoose.class);
                startActivity(intentToD);
            }
        });


    }
}
