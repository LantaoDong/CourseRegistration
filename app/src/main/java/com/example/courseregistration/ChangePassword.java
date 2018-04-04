package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChangePassword extends AppCompatActivity {
    private EditText oldPassword, newPassword;
    private Button change, back;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        change = (Button) findViewById(R.id.change);
        back = (Button) findViewById(R.id.back);
        oldPassword = (EditText) findViewById(R.id.oldPassword);
        newPassword = (EditText) findViewById(R.id.newPassword);
        Intent getUserID = getIntent();
        Bundle userIDDetail = getUserID.getExtras();
        if(userIDDetail!=null){
            userID = (String) userIDDetail.get("userID");
        }
        String directory = "users/"+userID;
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference(directory);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String OldPassword = oldPassword.getText().toString();
                        String NewPassword = newPassword.getText().toString();
                        if(OldPassword.equals(NewPassword)){
                            Toast.makeText(ChangePassword.this, "same password!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (dataSnapshot.child("password").getValue().equals(OldPassword)) {
                                dataSnapshot.getRef().child("password").setValue(NewPassword);
                                Toast.makeText(ChangePassword.this, "Sucessfully changed password", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangePassword.this, "Incorrect old password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToUser = new Intent(ChangePassword.this, UserActivity.class);
                startActivity(backToUser);
            }
        });

    }
}
