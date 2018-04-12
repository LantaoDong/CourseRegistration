package com.example.courseregistration.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;
/**
 * A model of major information
 * @author Haofan & Qunzhi
 */

@IgnoreExtraProperties
public class Major {
    CourseInfo ci = new CourseInfo();
    public String major_id;
    public String major_name;
    public String course=ci.getCourse_name();

    public Major() {
    }

    public Major(String major_id, String major_name,String course) {
        this.major_id = major_id;
        this.major_name = major_name;
        this.course=course;
    }

    public String getMajor_id() {
        return major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("major",major_id);
        result.put("major_name",major_name);
        result.put("course",ci.getCourse_name());
        return result;
    }
}