package com.example.courseregistration.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.courseregistration.R;
import com.example.courseregistration.TimeTableActivity;
import com.example.courseregistration.models.CourseInfo;
import com.example.courseregistration.models.Major;

import java.util.ArrayList;

/**
 * Created by Haofan on 2018-03-15.
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


        if(convertView==null)
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
        tv_courseavailable.setText(courseInfo.getCourse_available());

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //OPEN TIMETABLE
//                openTimeTableActivity(major.getMajor_id());
//            }
//        });

        return convertView;
    }

//    //OPEN DETAIL ACTIVITY
//    private void openTimeTableActivity(String major_id)
//    {
//        Intent intent=new Intent(context,TimeTableActivity.class);
//        intent.putExtra("MAJOR_ID",major_id);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        context.startActivity(intent);
//    }
}
