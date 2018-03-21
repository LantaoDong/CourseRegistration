package com.example.courseregistration.DBHelper;

import com.example.courseregistration.interfaces.CourseCallbacks;
import com.example.courseregistration.interfaces.MajorCallbacks;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-02-24.
 */

public class FirebaseHelper{

    private DatabaseReference db;
    private ArrayList<Major> majors = new ArrayList<>();
    private ArrayList<CourseInfo> courseInfos = new ArrayList<>();

    //////
//    CourseInfo courseInfo = new CourseInfo();


    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //Save the Major info. into db
    public Boolean saveMajor(Major major)
    {
        Boolean saved = null;
        if(major==null)
        {
            saved =false;
        }else
        {
            try
            {
                db.child("Major").push().setValue(major);
                saved =true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved =false;
            }
        }

        return saved;
    }

    //Save the Course info. into db
    public Boolean saveCourse(CourseInfo courseInfo)
    {
        Boolean saved = null;
        if(courseInfo==null)
        {
            saved =false;
        }else
        {
            try
            {
                db.child("CourseInfo").push().setValue(courseInfo);
                saved =true;

            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved =false;
            }
        }

        return saved;
    }

    //TEST
    public void retrieveMajor(final MajorCallbacks majorCallbacks){

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Major major = ds.getValue(Major.class);

                    if (major != null && major.getMajor_id() != null) {
                        majors.add(major);
                    }

                }

                majorCallbacks.onMajorCallback(majors);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//
//                    if (major != null && major.getMajor_id() != null) {
//                        majors.add(major);
//                    }
//
//                }
//
//                majorCallbacks.onMajorCallback(majors);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        ChildEventListener childEventListener = new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
////                ////////////////
////                System.out.println("------Major_datasnapshot: "+dataSnapshot.child("Major").child("-L7fwyCsWVMvJ4CK_aSF").child("major_id").getValue());
//
//                // majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
////                    majors.add(major);
//
//                    if (major != null && major.getMajor_id() != null) {
//                        majors.add(major);
//                    }
//
//                }
//
//                majorCallbacks.onMajorCallback(majors);
//
////                if (!majors.isEmpty()){
////                    db.removeEventListener(this);
////                }
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
////                majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//
//                    if (major != null && major.getMajor_id() != null) {
//                        majors.add(major);
//                    }
//                }
//                majorCallbacks.onMajorCallback(majors);
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
//        };
//
//        db.addChildEventListener(childEventListener);
//
//        if (!majors.isEmpty()){
//            db.removeEventListener(childEventListener);
//        }

//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                majors.clear();
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Major major = ds.getValue(Major.class);
//                    majors.add(major);
//                }
//
//                majorCallbacks.onMajorCallback(majors);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }
