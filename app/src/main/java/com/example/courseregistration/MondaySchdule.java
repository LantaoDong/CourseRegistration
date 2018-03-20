package com.example.courseregistration;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.courseregistration.models.MyApplicationData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Jaspering21 on 2018-03-19.
 */

public class MondaySchdule  extends Activity {

    TextView courseText;
    String courseName = "";
    MyApplicationData appstate;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_monday);
        courseText = (TextView)findViewById(R.id.courseText);
        DatabaseReference monday = FirebaseDatabase.getInstance().getReference("users");
        monday.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String uid = appstate.firebaseReference.push().getKey();
                    String userkey=snapshot.getKey();
                    String name = snapshot.child("registered courses").getValue().toString();
                    //name += " " + snapshot.child("courseName").getValue().toString();
                    courseText.setText(name);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}