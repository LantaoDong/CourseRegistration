package com.example.courseregistration.DBHelper;

import com.example.courseregistration.interfaces.ModelCallBacks;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Haofan on 2018-02-24.
 */

public class FirebaseHelper{

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<Major> majors = new ArrayList<>();



    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //Save the Major info. into db
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


    public interface MajorCallbacks {
        void onCallback(ArrayList<Major> majors);
    }


    public ArrayList<Major> retrieveMajor(final ModelCallBacks modelCallBacks){


        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Major major = ds.getValue(Major.class);
                    majors.add(major);
                }

                modelCallBacks.onModelUpdated(majors);




//                fetchDataFromMajor(dataSnapshot);

                ////////
//                Major m = new Major();
//                for (int i = 0; i < majors.size(); i++) {
//                    m = (Major) majors.get(i);
//                    System.out.println("id: " + m.getMajor_id());
//                    System.out.println("name: " + m.getMajor_name());
//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                fetchDataFromMajor(dataSnapshot);

//                majors.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Major major = ds.getValue(Major.class);
                    majors.add(major);
                }

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


    //READ BY HOOKING ONTO DATABASE OPERATION CALLBACKS
//    public ArrayList<Major> retrieveMajor() {
//
//        db.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                System.out.println("retrieveMajor childevent listener");
//
////                majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//                    majors.add(major);
//                }
//
//
//
//
//
////                fetchDataFromMajor(dataSnapshot);
//
//                ////////
////                Major m = new Major();
////                for (int i = 0; i < majors.size(); i++) {
////                    m = (Major) majors.get(i);
////                    System.out.println("id: " + m.getMajor_id());
////                    System.out.println("name: " + m.getMajor_name());
////                }
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
////                fetchDataFromMajor(dataSnapshot);
//
////                majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//                    majors.add(major);
//                }
//
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        try {
//            synchronized (majors) {
//                majors.wait();
//            }
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }

//

//        return majors;
//    }
}
