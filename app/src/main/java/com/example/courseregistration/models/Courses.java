package com.example.courseregistration.models;

/**
 * Created by 71578 on 2018/3/21.
 */

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Courses implements Serializable {
    public String id;
    public String courseID;
    public String subject;
    public String starttime;
    public String endtime;
    public String days;
    public Courses(){}

    public Courses(String uid, String cid, String sj, String st, String et, String d){
        id=uid;
        courseID=cid;
        subject=sj;
        starttime=st;
        endtime=et;
        days=d;

    }
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", id);
        result.put("courseID", courseID);
        result.put("subject", subject);
        result.put("starttime", starttime);
        result.put("endtime", endtime);
        result.put("days", days);

        return result;
    }
}

