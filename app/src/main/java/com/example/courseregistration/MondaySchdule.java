package com.example.courseregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Jaspering21 on 2018-03-19.
 */

public class MondaySchdule  extends AppCompatActivity {

    TextView courseText;
    String courseName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        courseText = (TextView)findViewById(R.id.courseText);
        DatabaseReference cs = FirebaseDatabase.getInstance().getReference("users/registered courses");
        cs.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("courseID").getValue().toString();
                    name += " " + snapshot.child("courseName").getValue().toString();
                    if (courseName.equals(name)) {
                        courseText.setText(name);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}