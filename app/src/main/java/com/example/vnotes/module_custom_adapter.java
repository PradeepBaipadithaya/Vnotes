package com.example.vnotes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class module_custom_adapter extends ArrayAdapter<module_content> {

    public Context mContext;
    public int mResource;
    public module_custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<module_content> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_page_pattern,parent,false);
        }
        TextView textView = convertView.findViewById(R.id.module_no);
        textView.setText(getItem(position).getModule_no());
        return convertView;
    }
}
