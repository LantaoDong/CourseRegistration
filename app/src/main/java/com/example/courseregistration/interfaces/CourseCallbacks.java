package com.example.courseregistration.interfaces;

import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-03-15.
 */

public interface CourseCallbacks {
    void onCourseCallback(ArrayList<CourseInfo> courseInfos);
}
