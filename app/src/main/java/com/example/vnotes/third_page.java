package com.example.vnotes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

        Database_creation subject_handler = new Database_creation(this,"Vnotes.db",null,1);
//        subject_handler.add_subject(sem_selected+"1", new subject("18ME81","Energy Engineering"));
//        subject_handler.add_subject(sem_selected+"2", new subject("18ME824","Automobile Engineering"));
//        subject_handler.add_subject(sem_selected+"3", new subject("18ME63","Heat Transfer"));
//        subject_handler.add_subject(sem_selected+"4", new subject("18ME641","Non-Traditional Machining"));
//        subject_handler.add_subject(sem_selected+"5", new subject("18CV651","Remote Sensing and GIS"));
//        subject_handler.add_subject(sem_selected+"6", new subject("18EC652","Sensors and Signal Conditioning"));
//        subject_handler.add_subject(sem_selected+"7", new subject("18CS653","Programming in JAVA"));
//        subject_handler.add_subject(sem_selected+"8", new subject("18MEL66","Computer Aided Modelling and Analysis Lab"));
//        subject_handler.add_subject(sem_selected+"9", new subject("18MEL67","Heat Transfer Lab"));
//        subject_handler.add_subject(sem_selected+"10", new subject("18MEL67","Heat Transfer Lab"));
//        subject_handler.add_subject(sem_selected+"11", new subject("18KVK49","Vyavaharika Kannada"));



//        subcode_selected = subject_handler.get_subject_code(sem_selected);
//        subcode_selected = subject_selected_cursor.getString(0);
//        subname_selected = subject_selected_cursor.getString(1);
//        subname_selected1 = subject_selected_cursor.getString(2);
//        subname_selected1 = subject_selected_cursor.getString(3);

          subject_handler.close();



//        System.out.println(course_selected);
        Toast.makeText(this, ""+sem_selected, Toast.LENGTH_LONG).show();

        listView = findViewById(R.id.third_page_listview);
        int j=0;
        if (sem_selected.equals("p") || sem_selected.equals("c") || sem_selected.equals("CS5") || sem_selected.equals("EC6") || sem_selected.equals("ME6")){
            j=10;
        }
        else if (sem_selected.equals("CS3")|| sem_selected.equals("CS4") || sem_selected.equals("EC3") || sem_selected.equals("EC4") || sem_selected.equals("CV3") || sem_selected.equals("CV4")){
            j=11;
        }
        else if (sem_selected.equals("CS6")){
            j=12;
        }
        else if (sem_selected.equals("EC5")){
            j=8;
        }
        else if (sem_selected.equals("CV5")){
            j=9;
        }
        else if (sem_selected.equals("CS8") || sem_selected.equals("CV8") || sem_selected.equals("EC8")){
            j=4;
        }
        else if (sem_selected.equals("CV6")){
            j=13;
        }
        else if (sem_selected.equals("ME4")){
            j=12;
        }
        else if (sem_selected.equals("ME8")){
            j=3;
        }
        ArrayList<subject> sub_arrayList = new ArrayList<>();
        for(int i=1; i<j;i++){
            subject_selected_cursor=subject_handler.get_subject_code(sem_selected+i);
            subcode_selected = subject_selected_cursor.getString(0);
            subname_selected = subject_selected_cursor.getString(1);
            sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));
//            Toast.makeText(this, ""+sem_selected+i, Toast.LENGTH_LONG).show();
        }
//        sub_arrayList.add(new subject(""+subject_selected_cursor,""+subname_selected));
//        sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));
//        sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));
//        sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));
//        sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));
//        sub_arrayList.add(new subject(""+subcode_selected,""+subname_selected));


        subject_custom_adapter custom_adapter = new subject_custom_adapter(this, R.layout.third_page,sub_arrayList);
        listView.setAdapter((custom_adapter));
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(third_page.this, fourth_page.class);
                sub=subject_handler.get_subject_code(sem_selected+(position+1));
                String sc = sub.getString(0);
                intent.putExtra("subcode",sc);
                startActivity(intent);
            }
        });
//        listView = findViewById(R.id.third_page_listview);
//        ArrayList<String> subject = new ArrayList<>();
//
//        subject.add("Subject 3");
//        subject.add("Subject 1");
//        subject.add("Subject 3");
//        subject.add("Subject 4");
//        subject.add("Subject 5");
//        subject.add("Subject 6");
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,subject);
//        listView.setAdapter(arrayAdapter);
    }
}
