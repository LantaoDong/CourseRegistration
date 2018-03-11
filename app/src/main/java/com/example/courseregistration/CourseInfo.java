package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class CourseInfo extends AppCompatActivity {
    private TextView textview1;
    private Button but1;

    /*public void init(){
        but1= (Button) findViewById(R.id.button2);
        but1.setOnClickListener(View.OnClickListener(){
            @Override
            Intent intent = new Intent(CourseInfo.this, CourseInfo.class);
        };
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MajorListActivity mj = new MajorListActivity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_list);
        final String[] majors ={
                "BIOL 1020 Introductory Biology Cr Hrs: 3, Max: 120, Cur: 75, Instructor: Staff, Time: 8:25-9:35",
                "Commerce 2200 Micro Economics Cr Hrs: 3, Max: 150, Cur 50, Instructor: Staff Time: 10:35-11:45",
                "Computer Science 330 Software Engineering Cr Hrs: 3, Max: 120, Cur 80, Instructor: Staff, Time: 12:00-13:25",
                "Economics 2200 Macrco Economics Cr Hrs: 3, Max: 150, Cur 50, Instructor: Staff, Time: 10:00-10:55",
                "Engineering ENGI 1103 Engineering Design Cr Hrs: 3, Max: 90, Cur 40, Instructor: Staff, Time: 14:35-15:45"
        };
        mj.getIntent();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,majors);
        ListView listviews1 = (ListView)findViewById(R.id.listviews );
        listviews1.setAdapter(adapter);
        listviews1.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String courses = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(CourseInfo.this,courses,Toast.LENGTH_LONG).show();;
                        //Intent intent = new Intent(CourseInfo.this,CourseInfo.class);
                        //startActivityForResult(intent,i);
                    }
                }
        );
        //init();
    }
}