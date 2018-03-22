package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;



public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.create);
        //take the user to registration page if the button "Create Account" is clicked
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });

        //take the user to "user activity" page if the button "Login" is clicked and username and password are valid.
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String iUsername = username.getText().toString();
                final String iPassword = password.getText().toString();
                //pop out a message if the username field is empty
                if (TextUtils.isEmpty(iUsername)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                //pop out a message if the password field is empty
                if (TextUtils.isEmpty(iPassword)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    performLogin(iUsername, iPassword);
                }
            }



        });

    }
    //check if the input username and password are valid
    public void performLogin(final String userName, final String password){
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");

        //check if the input username is in database
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean usernameFound = false;
                String userID = "";
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String userKey = snapshot.getKey();
                    String user = snapshot.child("username").getValue(String.class);
                    if(user.equals(userName)){
                        usernameFound = true;
                        userID = userKey;

                    }
                }
                //if the input username is in database, check if password is correct
                if(usernameFound){
                    String passWord = dataSnapshot.child(userID).child("password").getValue(String.class);
                    if (passWord.equals(password)) {
                        Intent intentUserActivity = new Intent(LoginActivity.this, UserActivity.class);

                        intentUserActivity.putExtra("userID",userID);

                        startActivity(intentUserActivity);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid password!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(LoginActivity.this, "Invalid username!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
