package com.example.courseregistration.DBHelper;

import com.example.courseregistration.models.Major;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-02-24.
 */

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<Major> majors = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //WRITE IF NOT NULL
    public Boolean saveMajor(Major major)
    {
        if(major==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Major").push().setValue(major);
                saved=true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;
    }

    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchDataFromMajor(DataSnapshot dataSnapshot)
    {
        majors.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Major major=ds.getValue(Major.class);
            majors.add(major);
        }
    }

    //READ BY HOOKING ONTO DATABASE OPERATION CALLBACKS
    public ArrayList<Major> retrieveMajor() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchDataFromMajor(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchDataFromMajor(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return majors;
    }
}
