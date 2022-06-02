package com.example.vnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class subject_custom_adapter extends ArrayAdapter<subject> {
    public Context mContext;
    public int mResource;
    public subject_custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<subject> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.third_page,parent,false);
        }

        TextView sub_name = convertView.findViewById(R.id.sub_name);
        TextView sub_code= convertView.findViewById(R.id.sub_code);
        sub_name.setText(getItem(position).getSub_name());
        sub_code.setText(getItem(position).getSub_code());

        return convertView;
    }

}
