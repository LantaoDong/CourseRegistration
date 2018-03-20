package com.example.courseregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Jaspering21 on 2018-03-20.
 */

public class SchduleActivity extends AppCompatActivity {
    ListView schdule;
    final ArrayList<String> schList =  new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schdule_list);
        //schdule = (ListView) findViewById(R.id.schdulelist);
        schdule = (ListView) findViewById(R.id.schdulelist);
        final String[] majors = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SchduleActivity.this, android.R.layout.simple_list_item_1, majors);
        schdule.setAdapter(adapter);
        schdule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String subject = String.valueOf(adapterView.getItemAtPosition(i));
                if(subject.equals("Monday")){
                    Intent intentToMon = new Intent(SchduleActivity.this,MondaySchdule.class);
                    startActivity(intentToMon);
                }
            }
        });
    }
}

