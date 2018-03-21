package com.example.courseregistration.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Haofan on 2018-02-24.
 */

@IgnoreExtraProperties
public class Major {

    public String major_id;
    public String major_name;

    public Major() {
    }

    public Major(String major_id, String major_name) {
        this.major_id = major_id;
        this.major_name = major_name;
    }

    public String getMajor_id() {
        return major_id;
    }

    public String getMajor_name() {
        return major_name;
    }
}