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
    private Button search;
    private Button help;
    private Button changePassword;
    private Button registeredCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        back = (Button) findViewById(R.id.backToLogin);
        timeTable = (Button) findViewById(R.id.timeTable);
        viewSchedule = (Button) findViewById(R.id.schedule);
        drop = (Button) findViewById(R.id.drop);
        changePassword = (Button) findViewById(R.id.changePassword);
        registeredCourses =(Button) findViewById(R.id.registeredCourses);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");


        search = (Button) findViewById(R.id.searchCourse);
        help = (Button) findViewById(R.id.help);

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
                Intent intentToTimeTable = new Intent(UserActivity.this,TermListActivity.class);
                startActivity(intentToTimeTable);
            }
        });
        viewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewSche = new Intent(UserActivity.this,ViewScheduleSemester.class);
                viewSche.putExtra("userID",userID);
                startActivity(viewSche);
            }
        });
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToD = new Intent(UserActivity.this, Departmentchoose.class);
                intentToD.putExtra("userID", userID);
                startActivity(intentToD);
            }
        });
        //button to transit to course search activity
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToSearch = new Intent(UserActivity.this, CourseFilter.class);
                intentToSearch.putExtra("userID",userID);
                startActivity(intentToSearch);
            }
        });
        //button to transit to help activity
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToHelp = new Intent (UserActivity.this,HelpContact.class);
                startActivity(intentToHelp);
            }
        });
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent changeP = new Intent(UserActivity.this, ChangePassword.class);
               changeP.putExtra("userID", userID);
               startActivity(changeP);
            }
        });
        registeredCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCourses = new Intent(UserActivity.this,Semesters.class);
                viewCourses.putExtra("userID",userID);
                startActivity(viewCourses);
            }
        });

    }
}
