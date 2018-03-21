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

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText username;
    private EditText password;
    private Button registerButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.register);
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentToLogin);
            }
        });
        //after clicking the "Register"button, push user information into database if input username does not exist in database
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String iName = name.getText().toString();
                final String iUsername = username.getText().toString();
                final String iPassword = password.getText().toString();
                //check if the input username is already in database
                DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        boolean usernameNotFound = true;
                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                            String userKey = snapshot.getKey();
                            String user = snapshot.child("username").getValue(String.class);
                            if(user.equals(iUsername)){
                                usernameNotFound = false;
                            }


                        }
                        //if the input username is not in database, user information is pushed into database
                        if(!iPassword.equals("")&&!name.equals("")&&!iUsername.equals("")&&usernameNotFound){
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
                            User user = new User(iName,iUsername,iPassword);
                            Map<String,Object> users = user.toMap();
                            String key = ref.push().getKey();
                            ref.push().setValue(users);
                            Toast.makeText(RegisterActivity.this,"Congratulations! You successfully created a new account!",Toast.LENGTH_SHORT).show();
                            Intent intentLoginActivity = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intentLoginActivity);

                        }
                        //if the input username is already in database, pop out a message showing the username is taken.
                        else if(!iPassword.equals("")&&!name.equals("")&&!iUsername.equals("")&&!usernameNotFound)
                            Toast.makeText(RegisterActivity.this,"Username already exists!",Toast.LENGTH_SHORT).show();
                        //added conditions to avoid null input when creating account
                        else
                            Toast.makeText(RegisterActivity.this,"Missing input!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                /*Map<String,Object> users = user.toMap();
                String key = db.push().getKey();
                db.push().setValue(users);*/


            }
        });

    }
    class User{
        String name;
        String username;
        String password;
        public User(String n,String u,String p){
            name = n;
            username = u;
            password = p;
        }
        public String getName(){return name;}
        public String getUsername(){return username;}
        public String getPassword(){return password;}
        public Map<String, Object> toMap(){
            HashMap<String, Object> result = new HashMap<>();
            result.put("name",name);
            result.put("username",username);
            result.put("password",password);
            return result;
        }
    }

}
