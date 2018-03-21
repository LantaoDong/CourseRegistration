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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import java.util.ArrayList;

public class MajorListActivity extends AppCompatActivity {



    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
