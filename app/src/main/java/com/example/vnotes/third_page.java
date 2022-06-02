package com.example.vnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class third_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        String sem_selected = getIntent().getStringExtra("course_sem");
//        System.out.println(course_selected);
        Toast.makeText(this, ""+sem_selected, Toast.LENGTH_LONG).show();

        listView = findViewById(R.id.third_page_listview);
        ArrayList<subject> sub_arrayList = new ArrayList<>();
        sub_arrayList.add(new subject("Subject 1","sub1"));
        sub_arrayList.add(new subject("Subject 2","sub2"));
        sub_arrayList.add(new subject("Subject 3","sub3"));
        sub_arrayList.add(new subject("Subject 4","sub4"));
        sub_arrayList.add(new subject("Subject 5","sub5"));
        sub_arrayList.add(new subject("Subject 6","sub6"));


        subject_custom_adapter custom_adapter = new subject_custom_adapter(this, R.layout.third_page,sub_arrayList);
        listView.setAdapter((custom_adapter));
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(third_page.this, fourth_page.class);
                String subject = listView.getItemAtPosition(position).toString();
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
