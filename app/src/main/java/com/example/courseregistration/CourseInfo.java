package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseInfo extends AppCompatActivity {
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MajorListActivity mj = new MajorListActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        textview1 = (TextView) findViewById(R.id.textView1);
        textview1.setText("BIOL 1020 Introductory Biology Cr Hrs: 3, Max: 120, Cur: 75, Instructor Staff");
    }
}
