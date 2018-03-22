package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class Adddroptable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddroptable);

        final TextView textView1 = (TextView) findViewById(R.id.textView4);
        final TextView textView2 = (TextView) findViewById(R.id.textView5);
        final TextView textView3 = (TextView) findViewById(R.id.textView6);
        final TextView textView4 = (TextView) findViewById(R.id.textView7);

        final Button button2 = (Button) findViewById(R.id.button4);
        final Button button3 = (Button) findViewById(R.id.button5);
        final Button button4 = (Button) findViewById(R.id.button6);
        final Button button5 = (Button) findViewById(R.id.button7);
        final Button button6 = (Button) findViewById(R.id.button8);

        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        Intent intent = getIntent();
        final String userID = intent.getStringExtra("userID");

        final DatabaseReference usRef = myRef.child("users");
        final DatabaseReference usidRef = usRef.child(userID);
        final DatabaseReference rcRef = usidRef.child("registered courses");
        Intent intentget = getIntent();

        final String message = intentget.getStringExtra("message");

        final ArrayList<Object> rcourses = new ArrayList<Object>();

        rcRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            ArrayList<Object> rcourses = new ArrayList<Object>();
                                            for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                                                String courseKey = snapshot.getKey();
                                                rcourses.add(courseKey);
                                            }
                                            if(rcourses.size()==4) {
                                                String course1 = dataSnapshot.child(rcourses.get(0).toString()).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child(rcourses.get(1).toString()).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                                String course3 = dataSnapshot.child(rcourses.get(2).toString()).child("courseID").getValue().toString();
                                                textView3.setText(course3);
                                                String course4 = dataSnapshot.child(rcourses.get(3).toString()).child("courseID").getValue().toString();
                                                textView4.setText(course4);
                                            }
                                            if(rcourses.size()==3) {
                                                String course1 = dataSnapshot.child(rcourses.get(0).toString()).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child(rcourses.get(1).toString()).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                                String course3 = dataSnapshot.child(rcourses.get(2).toString()).child("courseID").getValue().toString();
                                                textView3.setText(course3);
                                            }
                                            if(rcourses.size()==2) {
                                                String course1 = dataSnapshot.child(rcourses.get(0).toString()).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child(rcourses.get(1).toString()).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                            }
                                            if(rcourses.size()==1) {
                                                String course1 = dataSnapshot.child(rcourses.get(0).toString()).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                            }
                                            if(rcourses.size()==0) {
                                                textView1.setText("You have no courses registered.");
                                            }
                                        }

            @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("users").child("registered courses").child(rcourses.get(0).toString()).setValue(null);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 1").child("waitlistnum").setValue(numintwaitnum1);

                        } else if(numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(numint1);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("users").child("registered courses").child(rcourses.get(1).toString()).removeValue();

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {

                        String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();

                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 1").child("waitlistnum").setValue(numintwaitnum1);

                        } else if(numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(numint1);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("users").child("registered courses").child(rcourses.get(2).toString()).setValue(null);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {

                        String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();

                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 1").child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(numint1);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("users").child("registered courses").child(rcourses.get(3).toString()).setValue(null);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 1").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 1").child("waitlistnum").setValue(numintwaitnum1);

                        } else if(numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 1").child("numberOfStudents").setValue(numint1);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Adddroptable.this, Departmentchoose.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
                finish();
            }
        });

    }
}
