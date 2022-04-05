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


public class customAdapter extends ArrayAdapter<Course> {
    public Context mContext;
    public int mResource;
    public customAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Course> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

//    @Nullable
//    @Override
//    public Course getItem(int position) {
//        return super.getItem(position);
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.initial_page_list,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.image_name);
        TextView textView = convertView.findViewById(R.id.text_name);
        ImageView imgForward = convertView.findViewById(R.id.forward);
        imageView.setImageResource(getItem(position).getImage());
        textView.setText(getItem(position).getName());
        imgForward.setImageResource(getItem(position).getForwardImage());
        return convertView;
    }

}
