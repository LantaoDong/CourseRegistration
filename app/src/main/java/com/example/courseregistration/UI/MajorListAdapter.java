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
import com.example.courseregistration.models.Major;

import java.util.ArrayList;

/**
 * An adapter of the listview showing the majors
 */
public class MajorListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Major> majors;
    int courseterm;

    public MajorListAdapter(Context context, ArrayList<Major> majors, int courseterm) {
        this.context = context;
        this.majors = majors;
        this.courseterm = courseterm;
    }

    @Override
    public int getCount() {
        return majors.size();
    }

    @Override
    public Object getItem(int pos) {
        return majors.get(pos);
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
            convertView= LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
        }

        TextView tv_majorname= (TextView) convertView.findViewById(R.id.tx_majorname);

        final Major major= (Major) this.getItem(position);

        tv_majorname.setText(major.getMajor_name());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN TIMETABLE
                openTimeTableActivity(major.getMajor_id());
            }
        });

        return convertView;
    }

    /**
     * A direct to TimeTableActivity
     * @param major_id
     */
    private void openTimeTableActivity(String major_id)
    {
        Intent intent=new Intent(context,TimeTableActivity.class);
        intent.putExtra("MAJOR_ID",major_id);
        intent.putExtra("courseterm", courseterm);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
}