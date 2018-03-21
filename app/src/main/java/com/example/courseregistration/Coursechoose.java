package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Coursechoose extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursechoose);

        final Button button = (Button) findViewById(R.id.button3);
        //button.setOnClickListener(new View.OnClickListener() {
        //public void onClick(View v) {
        final CheckBox checkbox11 = (CheckBox) findViewById(R.id.checkBox11);
        final CheckBox checkbox12 = (CheckBox) findViewById(R.id.checkBox12);
        final CheckBox checkbox13 = (CheckBox) findViewById(R.id.checkBox13);
        final CheckBox checkbox14 = (CheckBox) findViewById(R.id.checkBox14);

        Intent intent = getIntent();
        String message = intent.getStringExtra("data");
        // String message1 = null;

        //TextView textView = findViewById(R.id.textView3);
        if(message.equals("Computer Science"))
        {
            checkbox11.setText("CSCI1100");
            checkbox12.setText("CSCI1101");
            checkbox13.setText("CSCI2200");
            checkbox14.setText("CSCI3300");
        }
        if(message.equals("Mathematics"))

        {
            checkbox11.setText("MATH1020");
            checkbox12.setText("MATH1030");
            checkbox13.setText("MATH2050");
            checkbox14.setText("MATH3070");
        }
        if(message.equals("Statistic"))

        {
            checkbox11.setText("STAT1330");
            checkbox12.setText("STAT1340");
            checkbox13.setText("STAT2330");
            checkbox14.setText("STAT3330");
        }
        if(message.equals("Economic"))

        {
            checkbox11.setText("ECON1015");
            checkbox12.setText("ECON1016");
            checkbox13.setText("ECON2015");
            checkbox14.setText("ECON3015");
        }
        if(message.equals("Commence"))

        {
            checkbox11.setText("COMM1231");
            checkbox12.setText("COMM1232");
            checkbox13.setText("COMM2231");
            checkbox14.setText("COMM3231");
        }

        //choose course
            /*if(checkbox11.isChecked())
            {
                message1 = checkbox11.getText().toString();
                checkbox12.setEnabled(false);
                checkbox13.setEnabled(false);
                checkbox14.setEnabled(false);
            }
            if(checkbox12.isChecked())
            {
                message1 = checkbox12.getText().toString();
                checkbox11.setEnabled(false);
                checkbox13.setEnabled(false);
                checkbox14.setEnabled(false);
            }
            if(checkbox13.isChecked())
            {
                message1 = checkbox13.getText().toString();
                checkbox11.setEnabled(false);
                checkbox12.setEnabled(false);
                checkbox14.setEnabled(false);
            }
            if(checkbox14.isChecked())
            {
                message1 = checkbox14.getText().toString();
                checkbox11.setEnabled(false);
                checkbox12.setEnabled(false);
                checkbox13.setEnabled(false);
            }*/
        //final String message2="";
        //message2.equals(message1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message1 = "";
                if(checkbox11.isChecked())

                {
                    message1 = checkbox11.getText().toString();
                    checkbox12.setEnabled(false);
                    checkbox13.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox12.isChecked())

                {
                    message1 = checkbox12.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox13.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox13.isChecked())

                {
                    message1 = checkbox13.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox12.setEnabled(false);
                    checkbox14.setEnabled(false);
                }
                if(checkbox14.isChecked())

                {
                    message1 = checkbox14.getText().toString();
                    checkbox11.setEnabled(false);
                    checkbox12.setEnabled(false);
                    checkbox13.setEnabled(false);
                }
                Intent intent = new Intent();
                intent.setClass(Coursechoose.this, Adddroptable.class);
                intent.putExtra("data1", message1);
                startActivity(intent);
            }
        });
    }
}
