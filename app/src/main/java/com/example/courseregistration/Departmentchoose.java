package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Departmentchoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departmentchoose);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String userID = intent1.getStringExtra("userID");

                String message = "";
                final CheckBox checkbox6 = (CheckBox) findViewById(R.id.checkBox6);
                final CheckBox checkbox7 = (CheckBox) findViewById(R.id.checkBox7);
                final CheckBox checkbox8 = (CheckBox) findViewById(R.id.checkBox8);
                final CheckBox checkbox9 = (CheckBox) findViewById(R.id.checkBox9);
                final CheckBox checkbox10 = (CheckBox) findViewById(R.id.checkBox10);
                if (checkbox6.isChecked()) {
                    message = checkbox6.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                    checkbox6.setChecked(false);
                }
                //checkbox6.setChecked(false);
                if (checkbox7.isChecked()) {
                    message = checkbox7.getText().toString();
                    checkbox6.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                    checkbox7.setChecked(false);
                }
                //checkbox7.setChecked(false);
                if (checkbox8.isChecked()) {
                    message = checkbox8.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox6.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                    checkbox8.setChecked(false);

                }
                //checkbox8.setChecked(false);
                if (checkbox9.isChecked()) {
                    message = checkbox9.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox6.setEnabled(false);
                    checkbox10.setEnabled(false);
                    checkbox9.setChecked(false);
                }
                //checkbox9.setChecked(false);
                if (checkbox10.isChecked()) {
                    message = checkbox10.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                    checkbox10.setChecked(false);
                }
                Intent intent = new Intent();
                intent.setClass(Departmentchoose.this, Coursechoose.class);
                intent.putExtra("data", message);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }
}
