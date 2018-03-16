package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        //        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

//        nameTxt = (TextView) findViewById(R.id.nameDetailTxt);
//        descTxt= (TextView) findViewById(R.id.descDetailTxt);
//        propTxt = (TextView) findViewById(R.id.propellantDetailTxt);
//
//        //GET INTENT
//        Intent i=this.getIntent();
//
//
//        //RECEIVE DATA
//        String name=i.getExtras().getString("NAME_KEY");
//        String desc=i.getExtras().getString("DESC_KEY");
//        String propellant=i.getExtras().getString("PROP_KEY");
//
//        //BIND DATA
//        nameTxt.setText(name);
//        descTxt.setText(desc);
//        propTxt.setText(propellant);
//
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    public void writeNewCourse(String course_id, String course_name, int course_section,
//                               String course_type, double course_crdhrs, String course_days,
//                               String course_times, String course_location, int course_max,
//                               int course_cur, int course_available, int course_wl,
//                               double course_per, String course_instructor){
//
//        CourseInfo courseInfo = new CourseInfo(course_id, course_name, course_section, course_type,
//                course_crdhrs, course_days, course_times, course_location, course_max,
//                course_cur, course_available, course_wl, course_per, course_instructor);
    }
}
