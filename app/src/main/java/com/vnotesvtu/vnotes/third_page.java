package com.vnotesvtu.vnotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

public class third_page extends AppCompatActivity {
    ListView listView;
    
    Cursor subject_selected_cursor,sub;
    String subcode_selected;
//    String subcode_selected1;
    String subname_selected;
//    String subname_selected1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        String sem_selected = getIntent().getStringExtra("course_sem");

//        Database_creation subject_handler = new Database_creation(this,"Vnotes",null,1);
//        subject_handler.close();
//        DataAdapter mDbHelper = new DataAdapter(this);
//        mDbHelper.createDatabase();




       // mDbHelper.close();

        listView = findViewById(R.id.third_page_listview);
        int j=0;
        if (sem_selected.equals("p") || sem_selected.equals("c") || sem_selected.equals("CS5") || sem_selected.equals("EC5") || sem_selected.equals("EC6") || sem_selected.equals("CS7") || sem_selected.equals("ME5") || sem_selected.equals("ME7")){
            j=10;
        }
        else if (sem_selected.equals("CS3") || sem_selected.equals("EC3") || sem_selected.equals("CV3")  || sem_selected.equals("EC7") ||sem_selected.equals("ME4")  || sem_selected.equals("ME6")){
            j=11;
        }
        else if (sem_selected.equals("CS6") || sem_selected.equals("ME3")){
            j=12;
        }
        else if (sem_selected.equals("CV7")){
            j=9;
        }
        else if (sem_selected.equals("CV5")){
            j=10;
        }

        else if (sem_selected.equals("CV6")){
            j=13;
        }
        else if (sem_selected.equals("CS4") || sem_selected.equals("EC4") || sem_selected.equals("CV4") ){
            j=12;
        }
        else if (sem_selected.equals("ME8")){
            j=6;
        }
        else if (sem_selected.equals("CS8")|| sem_selected.equals("EC8") || sem_selected.equals("CV8")){
            j=7;
        }

try {

    datahelper myDbHelper = new datahelper(this);
    try {
        myDbHelper.createDataBase();
    } catch (IOException ioe) {
        throw new Error("Unable to create database");
    }
    try {
        myDbHelper.openDataBase();
    } catch (SQLException sqle) {
        throw sqle;
    }
    ArrayList<subject> sub_arrayList = new ArrayList<>();
    for (int i = 1; i < j; i++) {
        Cursor subject_selected_cursor = myDbHelper.get_subject_code(sem_selected + i);
        // subject_selected_cursor=subject_handler.get_subject_code(sem_selected+i);
        subcode_selected = subject_selected_cursor.getString(0);
        subname_selected = subject_selected_cursor.getString(1);
        sub_arrayList.add(new subject("" + subcode_selected, "" + subname_selected));
//            Toast.makeText(this, ""+sem_selected+i, Toast.LENGTH_LONG).show();
    }

        subject_custom_adapter custom_adapter = new subject_custom_adapter(this, R.layout.third_page,sub_arrayList);
        listView.setAdapter((custom_adapter));
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(third_page.this, fourth_page.class);
                sub=myDbHelper.get_subject_code(sem_selected+(position+1));
                String sc = sub.getString(0);
                intent.putExtra("subcode",sc);
                startActivity(intent);
            }
        });
}catch (Exception e){
    Toast.makeText(this, ""+e, Toast.LENGTH_LONG).show();
}
    }
}
