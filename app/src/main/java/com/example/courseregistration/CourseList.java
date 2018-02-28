package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CourseList extends AppCompatActivity {
    ListView listView;

    public class MajorListActivity extends AppCompatActivity {
        ListView listView;
        //DatabaseReference db;
        // FirebaseHelper firebasehelper;
        // MajorListAdapter adapter;
        //ListView lv_MajorList;
        // EditText nameEditTxt,propTxt,descTxt;

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
    }

}