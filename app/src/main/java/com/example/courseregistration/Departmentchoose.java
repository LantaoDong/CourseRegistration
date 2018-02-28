package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;

public class Departmentchoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departmentchoose);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button button = (Button) findViewById(R.id.button);
                String message = "";
                //final Intent intent = new Intent(this, Main3Activity.class);
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
                }
                if (checkbox7.isChecked()) {
                    message = checkbox7.getText().toString();
                    checkbox6.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                }
                if (checkbox8.isChecked()) {
                    message = checkbox8.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox6.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox10.setEnabled(false);
                }
                if (checkbox9.isChecked()) {
                    message = checkbox9.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox6.setEnabled(false);
                    checkbox10.setEnabled(false);
                }
                if (checkbox10.isChecked()) {
                    message = checkbox10.getText().toString();
                    checkbox7.setEnabled(false);
                    checkbox8.setEnabled(false);
                    checkbox9.setEnabled(false);
                    checkbox6.setEnabled(false);
                }

                Intent intent = new Intent();
                intent.setClass(Departmentchoose.this, Coursechoose.class);
                intent.putExtra("data", message);
                startActivity(intent);
            }
        });
    }
}
