package com.example.courseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The Activity is to list terms.
 * Changes in Iteration 3: add this page to Time Table, letting users select terms before selecting majors.
 *
 * @author Haofan & Tianyi
 */
public class TermListActivity extends AppCompatActivity {

    TextView tv_fall, tv_summer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        tv_fall = (TextView)findViewById(R.id.tv_fall);
        tv_summer = (TextView) findViewById(R.id.tv_summer);

        tv_fall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermListActivity.this, MajorListActivity.class);
                intent.putExtra("term", 2);
                startActivity(intent);
            }
        });

        tv_summer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermListActivity.this, MajorListActivity.class);
                intent.putExtra("term", 1);
                startActivity(intent);
            }
        });

    }
}
