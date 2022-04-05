package com.example.vnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class second_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        listView = findViewById(R.id.second_page_listview);
        ArrayList<sem> sem_arrayList = new ArrayList<>();
        sem_arrayList.add(new sem(R.drawable.sem_1,"1 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_2,"2 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_3,"3 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_4,"4 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_5,"5 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_6,"6 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_7,"7 sem"));
        sem_arrayList.add(new sem(R.drawable.sem_8,"8 sem"));

        sem_custom_adapter custom_adapter = new sem_custom_adapter(this, R.layout.second_page,sem_arrayList);
        listView.setAdapter((custom_adapter));
    }
}