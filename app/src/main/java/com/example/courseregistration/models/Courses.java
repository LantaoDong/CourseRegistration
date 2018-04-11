package com.example.courseregistration.models;

/**
 * Created by Jiabin Liu && Yiran Deng on 2018/3/21.
 */

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//courses object
public class Courses implements Serializable {
    public String courseID;
    public String subject;
    public String starttime;
    public String endtime;
    public String days;
    public String term;
    public Courses(){}

    public Courses(String cid, String sj, String st, String et, String d,String term){
        courseID=cid;
        subject=sj;
        starttime=st;
        endtime=et;
        days=d;
        this.term = term;

    }
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("courseID", courseID);
        result.put("subject", subject);
        result.put("starttime", starttime);
        result.put("endtime", endtime);
        result.put("days", days);
        result.put("term", term);

        return result;
    }
}

