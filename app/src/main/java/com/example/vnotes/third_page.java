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
    
    Cursor subject_selected_cursor;
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
//        subject_handler.add_subject(sem_selected+"1", new subject("18CV51","Construction Management & Entrepreneurship"));
//        subject_handler.add_subject(sem_selected+"2", new subject("18CV52","Analysis of Indeterminate Structures"));
//        subject_handler.add_subject(sem_selected+"3", new subject("18CV53","Design of RC Structural Elements"));
//        subject_handler.add_subject(sem_selected+"4", new subject("18CV54","Basic Geotechnical Engineering"));
//        subject_handler.add_subject(sem_selected+"5", new subject("18CV55","Municipal Wastewater Engineering"));
//        subject_handler.add_subject(sem_selected+"6", new subject("18CV56","Highway Engineering"));
//        subject_handler.add_subject(sem_selected+"7", new subject("18CVL57","Surveying Practice"));
//        subject_handler.add_subject(sem_selected+"8", new subject("18CVL58","Concrete and Highway Materials Laboratory"));
//        subject_handler.add_subject(sem_selected+"9", new subject("18CPC49","Constitution of India, Professional Ethics and Cyber Law"));
//        subject_handler.add_subject(sem_selected+"10", new subject("18MATDIP41","ADDITIONAL MATHEMATICS – I"));



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
        if (sem_selected.equals("p") || sem_selected.equals("c") || sem_selected.equals("CS5")) {
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
