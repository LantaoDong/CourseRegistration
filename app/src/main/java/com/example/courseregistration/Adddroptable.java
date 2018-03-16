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


public class Adddroptable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddroptable);

        final TextView textView1=(TextView) findViewById(R.id.textView4);
        final TextView textView2=(TextView) findViewById(R.id.textView5);
        final TextView textView3=(TextView) findViewById(R.id.textView6);
        final TextView textView4=(TextView) findViewById(R.id.textView7);

        final Button button2=(Button) findViewById(R.id.button4);
        final Button button3=(Button) findViewById(R.id.button5);
        final Button button4=(Button) findViewById(R.id.button6);
        final Button button5=(Button) findViewById(R.id.button7);
        final Button button6 = (Button) findViewById(R.id.button8);

        Intent intent2 = getIntent();
        String message2 = intent2.getStringExtra("data1");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("subjects");

        if(message2.equals("CSCI1100")) {

            textView1.setText("100001 CSCI1100 Jack");
        }
        if(message2.equals("CSCI1101")) {
            textView1.setText("100002 CSCI1101 Jack");
        }
        if(message2.equals("CSCI2200")) {
            textView1.setText("100003 CSCI2200 Tom");
        }
        if(message2.equals("CSCI3300")) {
            textView1.setText("100004 CSCI3300 Rose");
        }
        if(message2.equals("MATH1020")) {
            textView1.setText("120001 MATH1020 Kitty");
        }
        if(message2.equals("MATH1030")) {
            textView1.setText("120002 MATH1030 John");
        }
        if(message2.equals("MATH2050")) {
            textView1.setText("120003 MATH2050 John");
        }
        if(message2.equals("MATH3070")) {
            textView1.setText("120004 MATH3070 White");
        }
        if(message2.equals("STAT1330")) {
            textView1.setText("210001 STAT1330 Black");
        }
        if(message2.equals("STAT1340")) {
            textView1.setText("210002 STAT1340 Kim");
        }
        if(message2.equals("STAT2330")) {
            textView1.setText("210003 STAT2330 Black");
        }
        if(message2.equals("STAT3330")) {
            textView1.setText("210004 STAT3330 Green");
        }
        if(message2.equals("ECON1015")) {
            textView1.setText("170001 ECON1015 Kimmy");
        }
        if(message2.equals("ECON1016")) {
            textView1.setText("170002 ECON1016 Jewel");
        }
        if(message2.equals("ECON2015")) {
            textView1.setText("170003 ECON2015 Kimmy");
        }
        if(message2.equals("ECON3015")) {
            textView1.setText("170004 ECON3015 Jewel");
        }
        if(message2.equals("COMM1231")) {
            textView1.setText("190201 COMM1231 Lina");
        }
        if(message2.equals("COMM1232")) {
            textView1.setText("190202 COMM1232 Lina");
        }
        if(message2.equals("COMM2231")) {
            textView1.setText("190203 COMM2231 Miya");
        }
        if(message2.equals("COMM3231")) {
            textView1.setText("190204 COMM2231 Miya");
        }

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView1.setText("");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView2.setText("");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView3.setText("");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView4.setText("");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Adddroptable.this, Departmentchoose.class);
                startActivity(intent);
            }
        });

    }
}
