package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {

    TextView tv_courseid, tv_coursename, tv_coursesection, tv_coursetype, tv_coursecrdhrs,
            tv_coursedays, tv_coursetimes, tv_courselocation, tv_coursemax, tv_coursecur,
            tv_courseavailable, tv_coursewl, tv_courseper, tv_courseinstructor, tv_coursedescription,
            tv_courseprerequire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = this.getIntent();

        //GET EXTRAs FROM INTENT
        String course_id = intent.getStringExtra("course_id");
        String course_name = intent.getStringExtra("course_name");
        int course_section = intent.getIntExtra("course_section",0);
        String course_type = intent.getStringExtra("course_type");
        double course_crdhrs = intent.getDoubleExtra("course_crdhrs", 0);
        String course_days = intent.getStringExtra("course_days");
        String course_times = intent.getStringExtra("course_times");
        String course_location = intent.getStringExtra("course_location");
        int course_max = intent.getIntExtra("course_max",0);
        int course_cur = intent.getIntExtra("course_cur",0);
        int course_available = intent.getIntExtra("course_available",0);
        int course_wl = intent.getIntExtra("course_wl",0);
        double course_per = intent.getIntExtra("course_per",0);
        String course_instructor = intent.getStringExtra("course_instructor");
        String course_description = intent.getStringExtra("course_description");
        String course_prerequire = intent.getStringExtra("course_prerequire");

        //DEFINE TEXTVIEWs
        tv_courseid = (TextView)findViewById(R.id.tv_courseid);
        tv_coursename = (TextView)findViewById(R.id.tv_coursename);
        tv_coursesection = (TextView)findViewById(R.id.tv_coursesection);
        tv_coursetype = (TextView)findViewById(R.id.tv_coursetype);
        tv_coursecrdhrs = (TextView)findViewById(R.id.tv_coursecrdhrs);
        tv_coursedays = (TextView)findViewById(R.id.tv_coursedays);
        tv_coursetimes = (TextView)findViewById(R.id.tv_coursetimes);
        tv_courselocation = (TextView)findViewById(R.id.tv_courselocation);
        tv_coursemax = (TextView)findViewById(R.id.tv_coursemax);
        tv_coursecur = (TextView)findViewById(R.id.tv_coursecur);
        tv_courseavailable = (TextView)findViewById(R.id.tv_courseavailable);
        tv_coursewl = (TextView)findViewById(R.id.tv_coursewl);
        tv_courseper = (TextView)findViewById(R.id.tv_courseper);
        tv_courseinstructor = (TextView)findViewById(R.id.tv_courseinstructor);
        tv_coursedescription = (TextView)findViewById(R.id.tv_coursedescription);
        tv_courseprerequire = (TextView)findViewById(R.id.tv_courseprerequire);

        tv_courseid.setText(course_id);
        tv_coursename.setText(course_name);
        tv_coursesection.setText(String.valueOf(course_section));
        tv_coursetype.setText(course_type);
        tv_coursecrdhrs.setText(String.valueOf(course_crdhrs));
        tv_coursedays.setText(course_days);
        tv_coursetimes.setText(course_times);
        tv_courselocation.setText(course_location);
        tv_coursemax.setText(String.valueOf(course_max));
        tv_coursecur.setText(String.valueOf(course_cur));
        tv_courseavailable.setText(String.valueOf(course_available));
        tv_coursewl.setText(String.valueOf(course_wl));
        tv_courseper.setText(String.valueOf(course_per));
        tv_courseinstructor.setText(course_instructor);
        tv_coursedescription.setText(course_description);
        tv_courseprerequire.setText(course_prerequire);

    }
}
