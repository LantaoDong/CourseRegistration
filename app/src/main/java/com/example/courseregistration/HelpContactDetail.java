package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Lantao Haining on 2018-04-08.
 */
public class HelpContactDetail extends AppCompatActivity {
    Button back;
    TextView detail;
    String contactIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_contact_detail);
        back = (Button) findViewById(R.id.back);
        detail = (TextView) findViewById(R.id.detail);
        Intent getIndex =   getIntent();
        Bundle index = getIndex.getExtras();
        if(index!=null){
            contactIndex = (String) index.get("name");
        }
        //retrieve contact information of technical team from firebase
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("ContactInformation");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String name = snapshot.getKey().toString();
                    if(contactIndex.equals(name)){
                        String contactDetail = snapshot.child("contact").getValue().toString();
                        detail.setText(contactDetail);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToIndex = new Intent(HelpContactDetail.this, HelpContact.class);
                startActivity(backToIndex);
            }
        });
    }
}
