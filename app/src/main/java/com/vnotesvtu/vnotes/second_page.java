package com.vnotesvtu.vnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class second_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sem_available[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String first_year_subject[] ={"p","c"};

//        To get intent value
        String course_selected = getIntent().getStringExtra("course_available");
//        System.out.println(course_selected);
//        Toast.makeText(this, ""+course_selected, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_second_page);
        listView = findViewById(R.id.second_page_listview);
        ArrayList<sem> sem_arrayList = new ArrayList<>();
        sem_arrayList.add(new sem(R.drawable.sem_1,"Physics Cycle"));
        sem_arrayList.add(new sem(R.drawable.sem_2,"Chemistry Cycle"));
        sem_arrayList.add(new sem(R.drawable.sem_3,"3 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_4,"4 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_5,"5 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_6,"6 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_7,"7 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_8,"8 sem"));

        sem_custom_adapter custom_adapter = new sem_custom_adapter(this, R.layout.second_page,sem_arrayList);
        listView.setAdapter((custom_adapter));

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(second_page.this, third_page.class);
                if(position==0 || position==1)
                    intent.putExtra("course_sem",first_year_subject[position]);
                else
                    intent.putExtra("course_sem",course_selected+sem_available[position]);
                startActivity(intent);
            }
        });


    }
}