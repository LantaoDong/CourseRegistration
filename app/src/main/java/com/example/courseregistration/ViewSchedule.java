package com.example.courseregistration;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.courseregistration.models.MyApplicationData;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ViewSchedule extends AppCompatActivity{


    private ListView daysListView;
    ArrayAdapter daysadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewschedule);

        daysListView = (ListView) findViewById(R.id.lstView);
        ArrayList<String> days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        daysadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, days);
        daysListView.setAdapter(daysadapter);

        daysListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Day that was clicked on by the user
                String selectedDay = (String) daysadapter.getItem(position);

                Intent intent = new Intent(ViewSchedule.this, activity_viewscheduleday.class);
                intent.putExtra("day", selectedDay);
                startActivity(intent);


            }
        });

    }
}
