package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCoursesActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    EditText et_courseid, et_coursename, et_coursesection, et_coursetype, et_coursecrdhrs,
            et_coursedays, et_coursetimes, et_courselocation, et_coursemax, et_coursecur,
            et_coursewl, et_courseinstructor, et_coursedescription, et_courseprerequire, et_majorid;
    Button btn_addCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper = new FirebaseHelper(db);

        et_courseid= (EditText) findViewById(R.id.et_courseid);
        et_coursename= (EditText) findViewById(R.id.et_coursename);
        et_coursesection= (EditText) findViewById(R.id.et_coursesection);
        et_coursetype= (EditText) findViewById(R.id.et_coursetype);
        et_coursecrdhrs= (EditText) findViewById(R.id.et_coursecrdhrs);
        et_coursedays= (EditText) findViewById(R.id.et_coursedays);
        et_coursetimes= (EditText) findViewById(R.id.et_coursetimes);
        et_courselocation= (EditText) findViewById(R.id.et_courselocation);
        et_coursemax= (EditText) findViewById(R.id.et_coursemax);
        et_coursecur= (EditText) findViewById(R.id.et_coursecur);
        et_coursewl= (EditText) findViewById(R.id.et_coursewl);
        et_courseinstructor= (EditText) findViewById(R.id.et_courseinstructor);
        et_coursedescription= (EditText) findViewById(R.id.et_coursedescription);
        et_courseprerequire= (EditText) findViewById(R.id.et_courseprerequire);
        et_majorid= (EditText) findViewById(R.id.et_majorid);

        btn_addCourse = (Button) findViewById(R.id.btn_addCourse);



        //SAVE
        btn_addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String course_id=et_courseid.getText().toString();
                String course_name=et_coursename.getText().toString();
                int course_section=Integer.parseInt(et_coursesection.getText().toString());
                String course_type=et_coursetype.getText().toString();
                double course_crdhrs=Double.parseDouble(et_coursecrdhrs.getText().toString());
                String course_days=et_coursedays.getText().toString();
                String course_times=et_coursetimes.getText().toString();
                String course_location=et_courselocation.getText().toString();
                int course_max=Integer.parseInt(et_coursemax.getText().toString());
                int course_cur=Integer.parseInt(et_coursecur.getText().toString());
                int course_wl=Integer.parseInt(et_coursewl.getText().toString());
                String course_instructor=et_courseinstructor.getText().toString();
                String course_description=et_coursedescription.getText().toString();
                String course_prerequire=et_courseprerequire.getText().toString();
                String major_id=et_majorid.getText().toString();



                //SET DATA
                CourseInfo course = new CourseInfo(course_id, course_name, course_section, course_type,
                        course_crdhrs, course_days, course_times, course_location, course_max,
                        course_cur, 1, course_wl, 1, course_instructor, course_description,
                        course_prerequire, major_id);


                //SIMPLE VALIDATION
                if(course_id != null && course_id.length()>0)
                {
                    //THEN SAVE
                    if(firebasehelper.saveCourse(course))
                    {
                        //IF SAVED CLEAR EDITXT
                        et_courseid.setText("");
                        et_coursename.setText("");
                        et_coursesection.setText("");
                        et_coursetype.setText("");
                        et_coursename.setText("");
                        et_coursecrdhrs.setText("");
                        et_coursedays.setText("");
                        et_coursetimes.setText("");
                        et_courselocation.setText("");
                        et_coursemax.setText("");
                        et_coursecur.setText("");
                        et_coursewl.setText("");
                        et_courseinstructor.setText("");
                        et_coursedescription.setText("");
                        et_courseprerequire.setText("");
                        et_majorid.setText("");

                        Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();

                    }
                }else
                {
                    Toast.makeText(AddCoursesActivity.this, "ID Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}