package com.example.courseregistration.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.courseregistration.CourseDetailActivity;
import com.example.courseregistration.R;
import com.example.courseregistration.TimeTableActivity;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;

import java.util.ArrayList;


/**
 * An adapter of the listview showing the courses
 */
public class TimeTableAdapter extends BaseAdapter {

    Context context;
    ArrayList<CourseInfo> courseInfos;

    public TimeTableAdapter(Context context, ArrayList<CourseInfo> courseInfos) {
        this.context = context;
        this.courseInfos = courseInfos;
    }

    @Override
    public int getCount() {
        return courseInfos.size();
    }

    @Override
    public Object getItem(int pos) {
        return courseInfos.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);


        if(convertView == null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.model_timetable,viewGroup,false);
        }

        TextView tv_courseid= (TextView) convertView.findViewById(R.id.tv_courseid);
        TextView tv_coursename= (TextView) convertView.findViewById(R.id.tv_coursename);
        TextView tv_courseinstructor= (TextView) convertView.findViewById(R.id.tv_courseinstructor);
        TextView tv_courseavailable= (TextView) convertView.findViewById(R.id.tv_courseavailable);

        final CourseInfo courseInfo= (CourseInfo) this.getItem(position);

        tv_courseid.setText(courseInfo.getCourse_id());
        tv_coursename.setText(courseInfo.getCourse_name());
        tv_courseinstructor.setText(courseInfo.getCourse_instructor());
        tv_courseavailable.setText(String.valueOf(courseInfo.getCourse_available()));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN Coursedetail
                openCourseDetailActivity(courseInfo);
            }
        });

        return convertView;
    }


    /**
     * A direct to CourseDetailActivity
     * @param courseInfo
     */
    private void openCourseDetailActivity(CourseInfo courseInfo)
    {
        Intent intent=new Intent(context,CourseDetailActivity.class);

        intent.putExtra("course_id",courseInfo.getCourse_id());
        intent.putExtra("course_name",courseInfo.getCourse_name());
        intent.putExtra("course_section",courseInfo.getCourse_section());
        intent.putExtra("course_type",courseInfo.getCourse_type());
        intent.putExtra("course_crdhrs",courseInfo.getCourse_crdhrs());
        intent.putExtra("course_days",courseInfo.getCourse_days());
        intent.putExtra("course_times",courseInfo.getCourse_times());
        intent.putExtra("course_location",courseInfo.getCourse_location());
        intent.putExtra("course_max",courseInfo.getCourse_max());
        intent.putExtra("course_cur",courseInfo.getCourse_cur());
        intent.putExtra("course_available",courseInfo.getCourse_available());
        intent.putExtra("course_wl",courseInfo.getCourse_wl());
        intent.putExtra("course_per",courseInfo.getCourse_per());
        intent.putExtra("course_instructor",courseInfo.getCourse_instructor());
        intent.putExtra("course_description",courseInfo.getCourse_description());
        intent.putExtra("course_prerequire",courseInfo.getCourse_prerequire());

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
}