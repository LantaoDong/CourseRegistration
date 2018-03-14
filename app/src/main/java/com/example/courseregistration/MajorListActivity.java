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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorListActivity extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper firebasehelper;
    MajorListAdapter adapter;
    ListView lv_MajorList;
    EditText nameEditTxt,propTxt,descTxt;
    private List<String> majors = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //INITIALIZE FIREBASE DB
        //ADAPTER
        adapter = new MajorListAdapter(this,firebasehelper.retrieveMajor());
        lv_MajorList.setAdapter(adapter);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference("subjects");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //String majorKey = snapshot.getKey();
                    //String major = snapshot.child("computerscience").getValue(String.class);
                    majors.add(snapshot.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_list);
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

    /*class Major{
        String major;
        String course;
        public Major(String major,String course){
            this.major=major;
            this.course=course;
        }
        public String getMajor(){return major;}
        public String getCourse(){return course;}
        public Map<String, Object> toMap(){
            HashMap<String, Object> result = new HashMap<>();
            result.put("major",major);
            result.put("course",course);
            return result;
        }
    }*/
}

