package com.example.courseregistration;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MajorListActivity extends AppCompatActivity {

    //DatabaseReference db;
    //FirebaseHelper firebasehelper;
    //MajorListAdapter adapter;
    //ListView lv_MajorList;
    //EditText nameEditTxt,propTxt,descTxt;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //configureNextButtom();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        lv_MajorList = (ListView) findViewById(R.id.lv_MajorList);*(/
        //INITIALIZE FIREBASE DB
        /*if(!FirebaseApp.getApps(this).isEmpty()){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        /*DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://courseregistration-314f3.firebaseio.com/");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(){
            @overide
            protected void populateView(View v, String model, int postition){
            }
        }
        db= FirebaseDatabase.getInstance().getReference();
        firebasehelper=new FirebaseHelper(db);
        //ADAPTER
        adapter = new MajorListAdapter(this,firebasehelper.retrieveMajor());
        lv_MajorList.setAdapter(adapter);*/


    /*public void configureNextButtom(){
        Button nextButton = (Button) findViewById(R.id.lv_MajorList);
        nextButton.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MajorListActivity.this, AddMajorsActivity.class));
            }
        }};
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_list);
        final String[] majors = {
                "Biology",
                "Commerce",
                "Computer Science",
                "Economics",
                "Engineering"
        };
        ListAdapter adapter = new ArrayAdapter<String>(MajorListActivity.this, android.R.layout.simple_list_item_1, majors);
        ListView listviews = (ListView) findViewById(R.id.listviews);
        listviews.setAdapter(adapter);

        listviews.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String courses = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(MajorListActivity.this,courses,Toast.LENGTH_LONG).show();;
                        Intent intent = new Intent(MajorListActivity.this,CourseInfo.class);
                        startActivityForResult(intent,i);

                    }
                }
        );
    }


    //check if the input username is in database
    public void performLogin(String major){
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String majorKey = snapshot.getKey();
                    String major = snapshot.child("computerscience").getValue(String.class);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

