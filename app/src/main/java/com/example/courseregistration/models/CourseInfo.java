package com.example.courseregistration.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Haofan on 2018-02-24.
 */

@IgnoreExtraProperties
public class CourseInfo {

    public String course_id;
    public String course_name;
    public int course_section;
    public String course_type;
    public double course_crdhrs;
    public String course_days;
    public String course_times;
    public String course_location;
    public int course_max;
    public int course_cur;
    public int course_available;
    public int course_wl;
    public double course_per;
    public String course_instructor;
    public String major_id;

    public CourseInfo() {

    }

    public CourseInfo(String course_id, String course_name, int course_section, String course_type,
                      double course_crdhrs, String course_days, String course_times,
                      String course_location, int course_max, int course_cur, int course_available,
                      int course_wl, double course_per, String course_instructor, String major_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_section = course_section;
        this.course_type = course_type;
        this.course_crdhrs = course_crdhrs;
        this.course_days = course_days;
        this.course_times = course_times;
        this.course_location = course_location;
        this.course_max = course_max;
        this.course_cur = course_cur;
        this.course_available = course_available;
        this.course_wl = course_wl;
        this.course_per = course_per;
        this.course_instructor = course_instructor;
        this.major_id = major_id;
    }

}
