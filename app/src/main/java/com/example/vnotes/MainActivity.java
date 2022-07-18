package com.example.vnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database_creation handler = new Database_creation(this, "Vnotes",null,1);
//        Database_creation subject_handler = new Database_creation(this,"Vnotes.db",null,1);
//        handler.add_subject("1", new subject("18CS62","CGV"));
        //handler.get_subject("1");
       // handler.close();
        listView = findViewById(R.id.listview);
        String course_available[] = {"CS","EC","CV","ME"};
        //Create initial page data by arraylist
        ArrayList<Course> arrayList = new ArrayList<>();
        arrayList.add(new Course(R.drawable.computer_science_engineering,"Computer Science Engineering"));
//        arrayList.add(new Course(R.drawable.ai_and_ml_engineering,"AI and ML Engineering",R.drawable.forward));
//        arrayList.add(new Course(R.drawable.data_science_engineering,"Data Science Engineering",R.drawable.forward));

        arrayList.add(new Course(R.drawable.electronic_and_communication_engineering,"Electronics and Communication Engineering"));
        arrayList.add(new Course(R.drawable.civil_engineering,"Civil Engineering"));
        arrayList.add(new Course(R.drawable.mechanical_engineering,"Mechanical Engineering"));


//        //Custom adapter and this is a listview adapter
        customAdapter custom_adapter = new customAdapter(this, R.layout.initial_page_list,arrayList);
        listView.setAdapter((custom_adapter));
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, second_page.class);
//                String course_selected = listView.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                intent.putExtra("course_available",course_available[position]);
                startActivity(intent);
            }
        });
    }
}