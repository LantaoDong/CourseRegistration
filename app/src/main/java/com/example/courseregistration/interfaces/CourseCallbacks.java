package com.example.courseregistration.interfaces;

import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;

import java.util.ArrayList;


/**
 * An interface callbacks the results returned by Firebase db
 *
 * @author Haofan & Qunzhi
 */
public interface CourseCallbacks {
    void onCourseCallback(ArrayList<CourseInfo> courseInfos);
}
