package com.example.courseregistration.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 71578 on 2018/3/18.
 */

public class user {

    CourseInfo ci = new CourseInfo();
    public String user_name;
    public String user_password;
    public String course=ci.getCourse_name();

    public user(String user_name, String user_passwrod, String course) {
        this.user_name=user_name;
        this.user_password=user_password;
        this.course=course;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("user name",user_name);
        result.put("user password",user_password);
        result.put("course",ci.getCourse_name());
        return result;
    }
}
