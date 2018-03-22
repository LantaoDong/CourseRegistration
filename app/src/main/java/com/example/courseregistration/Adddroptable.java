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

        /*final ArrayList<String> rcourses = new ArrayList<String>();

        rcRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                                                String courseKey = snapshot.child("course 1").getKey();
                                                rcourses.add(courseKey);
                                            }
                                            if(rcourses.size()==4) {
                                                String course1 = dataSnapshot.child("course 1").child(rcourses.get(0)).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child("course 2").child(rcourses.get(1)).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                                String course3 = dataSnapshot.child("course 3").child(rcourses.get(2)).child("courseID").getValue().toString();
                                                textView3.setText(course3);
                                                String course4 = dataSnapshot.child("course 4").child(rcourses.get(3)).child("courseID").getValue().toString();
                                                textView4.setText(course4);
                                            }
                                            if(rcourses.size()==3) {
                                                String course1 = dataSnapshot.child("course 1").child(rcourses.get(0)).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child("course 2").child(rcourses.get(1)).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                                String course3 = dataSnapshot.child("course 3").child(rcourses.get(2)).child("courseID").getValue().toString();
                                                textView3.setText(course3);
                                            }
                                            if(rcourses.size()==2) {
                                                String course1 = dataSnapshot.child("course 1").child(rcourses.get(0)).child("courseID").getValue().toString();
                                                textView1.setText(course1);
                                                String course2 = dataSnapshot.child("course 2").child(rcourses.get(1)).child("courseID").getValue().toString();
                                                textView2.setText(course2);
                                            }
                                            if(rcourses.size()==1) {
                                                String course1 =dataSnapshot.child("course 1").child(rcourses.get(0)).getValue().toString();
                                                textView1.setText(course1);
                                            }
                                            if(rcourses.size()==0) {
                                                textView1.setText("You have no courses registered.");
                                            }
                                            if(rcourses.size()>4) {
                                                textView1.setText("You have too many courses registered.");
                                            }
                                        }

            @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });*/
        rcRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("course 1").child("courseID").getValue()!=null){
                    String course1 = dataSnapshot.child("course 1").child("courseID").getValue().toString();
                    textView1.setText(course1);
                }
                else{
                    textView1.setText(" ");
                }
                if(dataSnapshot.child("course 2").child("courseID").getValue()!=null){
                    String course2 = dataSnapshot.child("course 2").child("courseID").getValue().toString();
                    textView2.setText(course2);
                }
                else{
                    textView2.setText(" ");
                }
                if(dataSnapshot.child("course 3").child("courseID").getValue()!=null){
                    String course3 = dataSnapshot.child("course 3").child("courseID").getValue().toString();
                    textView3.setText(course3);
                }
                else{
                    textView3.setText(" ");
                }
                if(dataSnapshot.child("course 4").child("courseID").getValue()!=null){
                    String course4 = dataSnapshot.child("course 4").child("courseID").getValue().toString();
                    textView4.setText(course4);
                }
                else{
                    textView4.setText(" ");
                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("users").child(userID).child("registered courses").child("course 1").removeValue();
                textView1.setText(" ");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        String num = dataSnapshot.child("subjects").child(message).child("course 1").child("numberOfStudents").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 1").child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
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
                myRef.child("users").child(userID).child("registered courses").child("course 2").removeValue();
                textView2.setText(" ");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {

                        String num = dataSnapshot.child("subjects").child(message).child("course 2").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 2").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 2").child("waitlistnum").getValue().toString();

                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 2").child("waitlistnum").setValue(numintwaitnum1);

                        } else if(numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 2").child("numberOfStudents").setValue(numint1);
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
                myRef.child("users").child(userID).child("registered courses").child("course 3").removeValue();
                textView3.setText(" ");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {

                        String num = dataSnapshot.child("subjects").child(message).child("course 3").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 3").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 3").child("waitlistnum").getValue().toString();

                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 3").child("waitlistnum").setValue(numintwaitnum1);

                        } else if (numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 3").child("numberOfStudents").setValue(numint1);
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
                myRef.child("users").child(userID).child("registered courses").child("course 4").removeValue();
                textView4.setText(" ");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        String num = dataSnapshot.child("subjects").child(message).child("course 4").child("numberOfStudents").getValue().toString();
                        String numcap = dataSnapshot.child("subjects").child(message).child("course 4").child("capacity").getValue().toString();
                        String numwaitnum = dataSnapshot.child("subjects").child(message).child("course 4").child("waitlistnum").getValue().toString();
                        int numint = Integer.parseInt(num);
                        int numintcap = Integer.parseInt(numcap);
                        int numintwaitnum = Integer.parseInt(numwaitnum);
                        if (numintwaitnum > 0) {
                            int numintwaitnum1 = numintwaitnum - 1;
                            myRef.child("subjects").child(message).child("course 4").child("waitlistnum").setValue(numintwaitnum1);

                        } else if(numint > 0) {
                            int numint1 = numint - 1;

                            myRef.child("subjects").child(message).child("course 4").child("numberOfStudents").setValue(numint1);
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
