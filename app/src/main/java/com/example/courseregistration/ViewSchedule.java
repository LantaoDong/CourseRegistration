package com.example.courseregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewSchedule extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewschedule);

        String times[] = {  "8:00", "8:30", "9:00", "9:30",
                "10:00", "10:30", "11:00", "11:30",
                "12:00", "12:30", "1:00", "1:30",
                "2:00", "2:30", "3:00", "3:30",
                "4:00", "4:30", "5:00", "5:30",
                "6:00", "6:30", "7:00", "7:30",
                "8:00", "8:30", "9:00", "9:30"  };
        String toptext[] = { "TIME", "Mon", "Tues", "Wed", "Thurs", "Fri"};
        TableLayout t1 = findViewById(R.id.ScheduleTable);
        TableRow daterow = new TableRow(this);
        // Initializing the top row of the UI (Days/Dates)
        for (int i = 0; i < 6; i++) {
            TextView text = new TextView(this);
            text.setText(toptext[i]);
            daterow.addView(text);
        }
        t1.addView(daterow);

        // Here we loop through all the times, printing one row at a time
        for (int i = 0; i < 28; i++) {
            TableRow row = new TableRow(this);
            TextView timetext = new TextView(this);

            timetext.setText(times[i]);
            row.addView(timetext);
            // iterating through the collumns
            for (int j=0; j < 5; j++) {
                TextView text = new TextView(this);
                /*
                // Logic will go here to decide what cells to put classes in
                if ( there should be a class printed  here then) {
                    set text to the class number and colour the background
                }
                else {
                    set text to an empty space
                }
                */
                text.setText("");
                row.addView(text);
            }
            t1.addView(row);
        }

        // spacing row at bottom (scrollview cuts off bottom row without this)
        TableRow row = new TableRow(this);
        TextView text = new TextView(this);
        text.setText("");
        row.addView(text);
        t1.addView(row);
    }




}
