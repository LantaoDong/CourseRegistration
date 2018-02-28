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
 * Created by Haofan on 2018-02-24.
 */

public class MajorListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Major> majors;

    public MajorListAdapter(Context context, ArrayList<Major> majors) {
        this.context = context;
        this.majors = majors;
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
//        View view = inflater.inflate(R.layout.item_major_list,null);

//        if(convertView==null)
//        {
//            convertView= LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
//        }
        convertView = inflater.inflate(R.layout.item_major_list, null);

        TextView tv_majorid= (TextView) convertView.findViewById(R.id.tx_majorid);
        TextView tv_majorname= (TextView) convertView.findViewById(R.id.tx_majorname);

        final Major major= (Major) this.getItem(position);

        tv_majorid.setText(major.getMajor_id());
        tv_majorname.setText(major.getMajor_name());
//////////////////
        System.out.println("majot Id" + tv_majorid.getText().toString());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN TIMETABLE
//                openTimeTableActivity(major.getMajor_id(), major.getMajor_name());
            }
        });

        return convertView;
    }

//    //OPEN DETAIL ACTIVITY
//    private void openTimeTableActivity(String major_id)
//    {
//        ///c????
//        Intent intent=new Intent(context,TimeTableActivity.class);
//        intent.putExtra("MAJOR_ID",major_id);
//
//        context.startActivity(intent);
//    }
}
