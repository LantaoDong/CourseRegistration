package com.example.courseregistration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LantaoDong on 2018-03-18.
 */

public class Course {
    public String courseID;
    public String courseName;
    public Course(){

    }
    public Course(String courseID, String courseName){
        this.courseID = courseID;
        this.courseName = courseName;
    }
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("course id",courseID);
        result.put("course name", courseName);
        return  result;
    }

}
