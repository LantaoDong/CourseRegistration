package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * This activity allows users to view registered courses for a specific term
 *
 * Created by Lantao & Haining on 2018-03-29.
 */
public class ViewCourses extends AppCompatActivity {
    private Button back;
    private ListView courseListView;
    String courseName;
    ArrayList<String> courses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //view the course
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");
        final String selectedSemester = intent.getStringExtra("semester");
        back = (Button) findViewById(R.id.back);
        courseListView = (ListView) findViewById(R.id.courses);
        String directory = "users/"+userID+"/registered courses";
        DatabaseReference db = FirebaseDatabase.getInstance().getReference(directory);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    // makes sure class is in selected term
                    // 1 = summer, 2 = fall
                    if (Integer.parseInt(snapshot.child("term").getValue().toString()) == getTermCode(selectedSemester)) {
                        courseName = snapshot.child("courseID").getValue().toString();
                        courses.add(courseName);

                    }
                }



                ListAdapter adapter = new ArrayAdapter<String>(ViewCourses.this,android.R.layout.simple_list_item_1,courses);
                courseListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ViewCourses.this, Semesters.class);
                intent1.putExtra("semester", selectedSemester);
                intent1.putExtra("userID", userID);
                startActivity(intent1);
            }
        });


    }
    public static int getTermCode(String term) {
        int returncode = -1;
        switch (term.toLowerCase()) {
            case "summer":
                returncode = 1;
                break;
            case "fall":
                returncode = 2;
                break;
            default:
        }
        return returncode;
    }
}
