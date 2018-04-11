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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Lantao & Haining on 2018-04-08.
 */
public class HelpContact extends AppCompatActivity {

    Button back;
    ListView help;
    final ArrayList<String> contact = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_contact);
        back = (Button) findViewById(R.id.back);
        help = (ListView) findViewById(R.id.help);
        //retrieve contactIndex for each technical team from firebase
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("ContactInformation");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    contact.add(snapshot.getKey());
                }
                ListAdapter adapter = new ArrayAdapter<String>(HelpContact.this,android.R.layout.simple_list_item_1,contact);
                help.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //put the name of technical team into a list view
        help.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String part = String.valueOf(parent.getItemAtPosition(position));
                Intent contactDetail = new Intent(HelpContact.this,HelpContactDetail.class);
                contactDetail.putExtra("name", part);
                startActivity(contactDetail);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToUser = new Intent(HelpContact.this,UserActivity.class);
                startActivity(backToUser);
            }
        });
    }
}
