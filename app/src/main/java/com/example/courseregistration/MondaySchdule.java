package com.example.courseregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Jaspering21 on 2018-03-19.
 */

public class MondaySchdule  extends AppCompatActivity {

    ListView courseL;
    String courseName = "";
    ArrayList<String> course = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        DatabaseReference cs = FirebaseDatabase.getInstance().getReference("users");
        cs.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //String name = snapshot.child("registered courses").getValue().toString();
                    String name = snapshot.child("registered courses").getValue().toString();
                    //name += " " + snapshot.child("courseName").getValue().toString();
                    //courseText.setText(name);
                    course.add(name);
                }
                ListAdapter adapter = new ArrayAdapter<String>(MondaySchdule.this,android.R.layout.simple_list_item_1,course);
                courseL = (ListView)findViewById(R.id.courseList);
                courseL.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}