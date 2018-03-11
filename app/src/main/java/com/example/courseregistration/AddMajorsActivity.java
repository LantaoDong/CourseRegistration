package com.example.courseregistration;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.courseregistration.DBHelper.FirebaseHelper;
import com.example.courseregistration.UI.MajorListAdapter;
import com.example.courseregistration.models.Major;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMajorsActivity extends AppCompatActivity {
    //..

    /*DatabaseReference db;
    FirebaseHelper firebasehelper;
    //MajorListAdapter adapter;
    ListView lv_addMajors;
    EditText et_majorid, et_majorname;
    Button btn_addMajor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_majors);
        //INITIALIZE FIREBASE DB
       // db= FirebaseDatabase.getInstance().getReference();
       // firebasehelper = new FirebaseHelper(db);
        lv_addMajors = (ListView) findViewById(R.id.lv_MajorList);
        //ADAPTER
        //adapter=new MajorListAdapter(this, firebasehelper.retrieveMajor());
        //lv_addMajors.setAdapter(adapter);
//        displayInputDialog();
        et_majorid= (EditText) findViewById(R.id.et_majorid);
        et_majorname= (EditText) findViewById(R.id.et_majorname);
        btn_addMajor= (Button) findViewById(R.id.btn_addMajor);
        //SAVE
        btn_addMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String majorid=et_majorid.getText().toString();
                String majorname=et_majorname.getText().toString();
                //////////
                System.out.println("majorID:" + majorid);
                System.out.println("majorName:" + majorname);
                //SET DATA
                Major major=new Major(majorid, majorname);
                //SIMPLE VALIDATION
                if(majorid != null && majorid.length()>0)
                {
                    //THEN SAVE
                    if(firebasehelper.saveMajor(major))
                    {
                        //IF SAVED CLEAR EDITXT
                        et_majorid.setText("");
                        et_majorname.setText("");
//                        adapter=new MajorListAdapter(AddMajorsActivity.this, firebasehelper.retrieveMajor());
//                        lv_addMajors.setAdapter(adapter);
                    }
                }else
                {
                    Toast.makeText(AddMajorsActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //DISPLAY INPUT DIALOG
//    private void displayInputDialog()
//    {
//        Dialog d=new Dialog(this);
//        d.setTitle("Save To Firebase");
//        d.setContentView(R.layout.activity_add_majors);
//
//        et_majorid= (EditText) findViewById(R.id.et_majorid);
//        et_majorname= (EditText) findViewById(R.id.et_majorname);
//        Button btn_addMajor= (Button) findViewById(R.id.btn_addMajor);
//
//        //SAVE
//        btn_addMajor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //GET DATA
//                String majorid=et_majorid.getText().toString();
//                String majorname=et_majorname.getText().toString();
//
//                //SET DATA
//                Major major=new Major(majorid, majorname);
//
//
//                //SIMPLE VALIDATION
//                if(majorid != null && majorid.length()>0)
//                {
//                    //THEN SAVE
//                    if(firebasehelper.saveMajor(major))
//                    {
//                        //IF SAVED CLEAR EDITXT
//                        et_majorid.setText("");
//                        et_majorname.setText("");
//
//                        adapter=new MajorListAdapter(AddMajorsActivity.this, firebasehelper.retrieveMajor());
//                        lv_addMajors.setAdapter(adapter);
//
//
//                    }
//                }else
//                {
//                    Toast.makeText(AddMajorsActivity.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//        d.show();
//    }
*/
}