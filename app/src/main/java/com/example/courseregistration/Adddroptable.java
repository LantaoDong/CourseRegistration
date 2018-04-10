package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;

public class Adddroptable extends AppCompatActivity {

    /**
     * Created by dengyiran on 2018-04-08.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddroptable);

        final TextView textView1 = (TextView) findViewById(R.id.textView4);
        final TextView textView2 = (TextView) findViewById(R.id.textView5);
        final TextView textView3 = (TextView) findViewById(R.id.textView6);
        final TextView textView4 = (TextView) findViewById(R.id.textView7);
        final TextView textView5 = (TextView) findViewById(R.id.textView13);

        final Button button2 = (Button) findViewById(R.id.button4);
        final Button button3 = (Button) findViewById(R.id.button5);
        final Button button4 = (Button) findViewById(R.id.button6);
        final Button button5 = (Button) findViewById(R.id.button7);
        final Button button6 = (Button) findViewById(R.id.button8);
        final Button button7 = (Button) findViewById(R.id.button9);

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

        final ArrayList<String> rcourses = new ArrayList<String>();

        //show courses the user has already choosen

       rcRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                rcourses.clear();

                for(DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    String courseKey = snapshot.getKey().toString();
                    rcourses.add(courseKey);
                }


                if(rcourses.size()==5) {

                    String course1 = rcourses.get(0);
                    textView1.setText(course1);
                    String course2 = rcourses.get(1);
                    textView2.setText(course2);
                    String course3 = rcourses.get(2);
                    textView3.setText(course3);
                    String course4 = rcourses.get(3);
                    textView4.setText(course4);
                    String course5 = rcourses.get(4);
                    textView5.setText(course5);
                }

                if(rcourses.size()==4) {

                    String course1 = rcourses.get(0);
                    textView1.setText(course1);
                    String course2 = rcourses.get(1);
                    textView2.setText(course2);
                    String course3 = rcourses.get(2);
                    textView3.setText(course3);
                    String course4 = rcourses.get(3);
                    textView4.setText(course4);
                    textView5.setText("No registered courses");
                }

                if(rcourses.size()==3) {

                    String course1 = rcourses.get(0);
                    textView1.setText(course1);
                    String course2 = rcourses.get(1);
                    textView2.setText(course2);
                    String course3 = rcourses.get(2);
                    textView3.setText(course3);
                    textView4.setText("No registered courses");
                    textView5.setText("No registered courses");
                }
                if(rcourses.size()==2) {

                    String course1 = rcourses.get(0);
                    textView1.setText(course1);
                    String course2 = rcourses.get(1);
                    textView2.setText(course2);
                    textView3.setText("No registered courses");
                    textView4.setText("No registered courses");
                    textView5.setText("No registered courses");

                }
                if(rcourses.size()==1) {

                    String course1 =rcourses.get(0);
                    textView1.setText(course1);
                    textView2.setText("No registered courses");
                    textView3.setText("No registered courses");
                    textView4.setText("No registered courses");
                    textView5.setText("No registered courses");

                }
                if(rcourses.size()==0) {

                    textView1.setText("You have no courses registered.");
                    textView2.setText("No registered courses");
                    textView3.setText("No registered courses");
                    textView4.setText("No registered courses");
                    textView5.setText("No registered courses");

                }
                if(rcourses.size()>5) {
                    Toast.makeText(Adddroptable.this, "You have already have 5 courses.", Toast.LENGTH_LONG).show();
                    //rcourses.remove(5);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        // drop function
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String depart= "";
                        if(textView1.getText().toString().contains("CSCI")) {
                            depart = "computer science";
                        }
                        if(textView1.getText().toString().contains("MATH")) {
                            depart = "math";
                        }
                        if(textView1.getText().toString().contains("STAT")) {
                            depart = "Statistics";
                        }
                        if(textView1.getText().toString().equals("No registered courses")){
                            Toast.makeText(Adddroptable.this,"You have no course to drop.", Toast.LENGTH_LONG);
                        }

                        String num = dataSnapshot.child("subjects").child(depart).child(textView1.getText().toString()).child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(depart).child(textView1.getText().toString()).child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(depart).child(textView1.getText().toString()).child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(depart).child(textView1.getText().toString()).child("numberOfStudents").setValue(numint1);
                        }
                        myRef.child("users").child(userID).child("registered courses").child(textView1.getText().toString()).removeValue();
                        rcourses.remove(0);


                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String depart= "";
                        if(textView2.getText().toString().contains("CSCI")) {
                            depart = "computer science";
                        }
                        if(textView2.getText().toString().contains("MATH")) {
                            depart = "math";
                        }
                        if(textView2.getText().toString().contains("STAT")) {
                            depart = "Statistics";
                        }
                        if(textView2.getText().toString().equals("No registered courses")){
                            Toast.makeText(Adddroptable.this,"You have no course to drop.", Toast.LENGTH_LONG);
                            finish();
                        }

                        String num = dataSnapshot.child("subjects").child(depart).child(textView2.getText().toString()).child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(depart).child(textView2.getText().toString()).child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(depart).child(textView2.getText().toString()).child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(depart).child(textView2.getText().toString()).child("numberOfStudents").setValue(numint1);
                        }
                        myRef.child("users").child(userID).child("registered courses").child(textView2.getText().toString()).removeValue();

                        rcourses.remove(1);

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String depart= "";
                        if(textView3.getText().toString().contains("CSCI")) {
                            depart = "computer science";
                        }
                        if(textView3.getText().toString().contains("MATH")) {
                            depart = "math";
                        }
                        if(textView3.getText().toString().contains("STAT")) {
                            depart = "Statistics";
                        }
                        if(textView3.getText().toString().equals("No registered courses")){
                            Toast.makeText(Adddroptable.this,"You have no course to drop.", Toast.LENGTH_LONG);
                            finish();
                        }

                        String num = dataSnapshot.child("subjects").child(depart).child(textView3.getText().toString()).child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(depart).child(textView3.getText().toString()).child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(depart).child(textView3.getText().toString()).child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(depart).child(textView3.getText().toString()).child("numberOfStudents").setValue(numint1);
                        }
                        myRef.child("users").child(userID).child("registered courses").child(textView3.getText().toString()).removeValue();
                        rcourses.remove(2);

                    }
                });
           }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String depart= "";
                        if(textView4.getText().toString().contains("CSCI")) {
                            depart = "computer science";
                        }
                        if(textView4.getText().toString().contains("MATH")) {
                            depart = "math";
                        }
                        if(textView4.getText().toString().contains("STAT")) {
                            depart = "Statistics";
                        }
                        if(textView4.getText().toString().equals("No registered courses")){
                            Toast.makeText(Adddroptable.this,"You have no course to drop.", Toast.LENGTH_LONG);
                            finish();
                        }

                        String num = dataSnapshot.child("subjects").child(depart).child(textView4.getText().toString()).child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(depart).child(textView4.getText().toString()).child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(depart).child(textView4.getText().toString()).child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(depart).child(textView4.getText().toString()).child("numberOfStudents").setValue(numint1);
                        }
                        myRef.child("users").child(userID).child("registered courses").child(textView4.getText().toString()).removeValue();
                        rcourses.remove(3);

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                button7.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String depart= "";
                        if(textView5.getText().toString().contains("CSCI")) {
                            depart = "computer science";
                        }
                        if(textView5.getText().toString().contains("MATH")) {
                            depart = "math";
                        }
                        if(textView5.getText().toString().contains("STAT")) {
                            depart = "Statistics";
                        }
                        if(textView5.getText().toString().equals("No registered courses")){
                            Toast.makeText(Adddroptable.this,"You have no course to drop.", Toast.LENGTH_LONG);
                            finish();
                        }

                        String num = dataSnapshot.child("subjects").child(depart).child(textView5.getText().toString()).child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(depart).child(textView5.getText().toString()).child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(depart).child(textView5.getText().toString()).child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;
                            myRef.child("subjects").child(depart).child(textView5.getText().toString()).child("numberOfStudents").setValue(numint1);
                        }
                        myRef.child("users").child(userID).child("registered courses").child(textView5.getText().toString()).removeValue();
                        rcourses.remove(4);

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

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
