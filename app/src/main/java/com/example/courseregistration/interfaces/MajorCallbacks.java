package com.example.courseregistration.interfaces;

import com.example.courseregistration.models.Major;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-03-15.
 */

public interface MajorCallbacks {
    void onMajorCallback(ArrayList<Major> majors);
}