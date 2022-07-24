package com.vnotesvtu.vnotes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class fourth_page extends AppCompatActivity {
    ListView listView;
    FirebaseListAdapter adapter;
    TextView notes, question_paper;
//    SlidrInterface slidrInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_page);
        notes = findViewById(R.id.notes);
        question_paper = findViewById(R.id.question_paper);
        listView = findViewById(R.id.fourth_page_listview);
        call_notes();
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call_notes();
            }

        });

        question_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<module_content> qp_arraylist = new ArrayList<>();
                String subcode = getIntent().getStringExtra("subcode");
                ArrayList<String> urls = new ArrayList<String>();
                module_custom_adapter custom_adapter = new module_custom_adapter(fourth_page.this, R.layout.module_page_pattern, qp_arraylist);
                listView.setAdapter((custom_adapter));
                question_paper.setBackgroundColor(Color.parseColor("#444648"));
                question_paper.setTextColor(Color.parseColor("#FFFFFF"));
                notes.setBackgroundColor(Color.parseColor("#2E3133"));
                notes.setTextColor(Color.parseColor("#A1FFFFFF"));

//        To check internet connection
                boolean connected = false;
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                } else
                    connected = false;

                if (connected) {
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("question_paper").child("" + subcode);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ;
                            for (DataSnapshot s : snapshot.getChildren()) {
                                String str = s.getKey().toString();
                                String value = s.getValue().toString();
                                urls.add(value);
                                qp_arraylist.add(new module_content("" + str));
                            }
                            custom_adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            try {
                                Uri uri = Uri.parse("" + urls.get(position)); // missing 'http://' will cause crashed
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            } catch (Exception e) {
                                Intent intent = new Intent(fourth_page.this, no_notes.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    Intent intent = new Intent(fourth_page.this, no_internet.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    public void call_notes(){
        ArrayList<module_content> module_arraylist = new ArrayList<>();
        String subcode = getIntent().getStringExtra("subcode");
        ArrayList<String> urls = new ArrayList<String>();
        module_custom_adapter custom_adapter = new module_custom_adapter(fourth_page.this, R.layout.module_page_pattern, module_arraylist);
        listView.setAdapter((custom_adapter));
        notes.setBackgroundColor(Color.parseColor("#444648"));
        notes.setTextColor(Color.parseColor("#FFFFFF"));
        question_paper.setBackgroundColor(Color.parseColor("#2E3133"));
        question_paper.setTextColor(Color.parseColor("#A1FFFFFF"));
        //        To check internet connection
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        if (connected) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("notes").child("" + subcode);
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ;
                    for (DataSnapshot s : snapshot.getChildren()) {
                        String str = s.getKey().toString();
                        String value = s.getValue().toString();
                        urls.add(value);
                        module_arraylist.add(new module_content("" + str));
                    }
                    custom_adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    try {
                        Uri uri = Uri.parse("" + urls.get(position)); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    } catch (Exception e) {
                        Intent intent = new Intent(fourth_page.this, no_notes.class);
                        startActivity(intent);
                    }
                }
            });
        } else {
            Intent intent = new Intent(fourth_page.this, no_internet.class);
            startActivity(intent);
            finish();
        }
    }
}