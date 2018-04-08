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
    public String course_description;
    public String course_prerequire;
    public int course_major;
    public String major_id;

    public CourseInfo() {
    }


    public CourseInfo(String course_id, String course_name, int course_section, String course_type,
                      double course_crdhrs, String course_days, String course_times,
                      String course_location, int course_max, int course_cur, int course_available,
                      int course_wl, double course_per, String course_instructor,
                      String course_description, String course_prerequire, String major_id) {

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
        this.course_description = course_description;
        this.course_prerequire = course_prerequire;
        this.major_id = major_id;
    }


    public CourseInfo(String course_id, String course_name, int course_section, String course_type,
                      double course_crdhrs, String course_days, String course_times, String course_location,
                      int course_max, int course_cur, int course_available, int course_wl, double course_per,
                      String course_instructor, String course_description, String course_prerequire,
                      int course_major, String major_id) {
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
        this.course_description = course_description;
        this.course_prerequire = course_prerequire;
        this.course_major = course_major;
        this.major_id = major_id;
    }


    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getCourse_section() {
        return course_section;
    }

    public String getCourse_type() {
        return course_type;
    }

    public double getCourse_crdhrs() {
        return course_crdhrs;
    }

    public String getCourse_days() {
        return course_days;
    }

    public String getCourse_times() {
        return course_times;
    }

    public String getCourse_location() {
        return course_location;
    }

    public int getCourse_max() {
        return course_max;
    }

    public int getCourse_cur() {
        return course_cur;
    }

    public int getCourse_available() {
        return course_available;
    }

    public int getCourse_wl() {
        return course_wl;
    }

    public double getCourse_per() {
        return course_per;
    }

    public String getCourse_instructor() {
        return course_instructor;
    }

    public String getCourse_description() {
        return course_description;
    }

    public String getCourse_prerequire() {
        return course_prerequire;
    }

    public String getMajor_id() {
        return major_id;
    }



    //setters

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_section(int course_section) {
        this.course_section = course_section;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public void setCourse_crdhrs(double course_crdhrs) {
        this.course_crdhrs = course_crdhrs;
    }

    public void setCourse_days(String course_days) {
        this.course_days = course_days;
    }

    public void setCourse_times(String course_times) {
        this.course_times = course_times;
    }

    public void setCourse_location(String course_location) {
        this.course_location = course_location;
    }

    public void setCourse_max(int course_max) {
        this.course_max = course_max;
    }

    public void setCourse_cur(int course_cur) {
        this.course_cur = course_cur;
    }

    public void setCourse_available(int course_available) {
        this.course_available = course_available;
    }

    public void setCourse_wl(int course_wl) {
        this.course_wl = course_wl;
    }

    public void setCourse_per(double course_per) {
        this.course_per = course_per;
    }

    public void setCourse_instructor(String course_instructor) {
        this.course_instructor = course_instructor;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public void setCourse_prerequire(String course_prerequire) {
        this.course_prerequire = course_prerequire;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public int getCourse_major() {
        return course_major;
    }

    public void setCourse_major(int course_major) {
        this.course_major = course_major;
    }
}