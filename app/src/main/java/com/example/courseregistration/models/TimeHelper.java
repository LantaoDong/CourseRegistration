package com.example.courseregistration.models;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by Jaspering21 on 2018-03-19.
 */

public class TimeHelper {
    public String days;
    public String start;
    public String end;
    DatabaseReference db;

    public TimeHelper(String days,String start,String end){
        this.days=days;
        this.start=start;
        this.end=end;
    }
    public String getDays(){
        return days;
    }
    public String getStart(){
        return start;
    }
    public String getEnd(){
        return end;
    }
}
