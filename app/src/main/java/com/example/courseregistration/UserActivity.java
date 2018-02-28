package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {
    private Button back;
    private Button add;
    private Button drop;
    private Button timeTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        back = (Button) findViewById(R.id.backToLogin);
        timeTable = (Button) findViewById(R.id.timeTable);
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

    }
}
