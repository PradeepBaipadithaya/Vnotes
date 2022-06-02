package com.example.vnotes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class fourth_page extends AppCompatActivity {
    ListView listView;
    String[] urls ={
            "https://www.youtube.com/watch?v=geWi5v7_Zsc",
            "https://internshipstudio.com/courses/machine-learning-internship/",
            "https://developer.android.com/studio?gclid=Cj0KCQjwmuiTBhDoARIsAPiv6L9WhEsJzTGuTseVZljUZVEUEjpj5JeOs0dws5pWFtxOxx74AJ5mRh0aAriLEALw_wcB&gclsrc=aw.ds"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_page);
        ArrayList<String> notes = new ArrayList<>();
        listView = findViewById(R.id.fourth_page_listview);
        notes.add("notes 3");
        notes.add("notes 1");
        notes.add("notes 3");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent url_link = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[i]));
                startActivity(url_link);
            }
        });
    }
}
