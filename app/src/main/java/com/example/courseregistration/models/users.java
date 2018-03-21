package com.example.courseregistration.models;

/**
 * Created by 71578 on 2018/3/21.
 */

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;


import java.util.HashMap;
import java.util.Map;


public class users {
    public CourseInfo ci = new CourseInfo();
    public String user_id;
    public String user_name;
    public String user_password;
    public String course=ci.getCourse_name();
    public users() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public users(String uid, String name, String password){
        this.user_id=uid;
        this.user_name = name;
        this.user_password = password;
    }
    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", user_id);
        result.put("name", user_name);
        result.put("password", user_password);

        return result;
    }
}
