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



public class sem_custom_adapter extends ArrayAdapter<sem> {
    public Context mContext;
    public int mResource;
    public sem_custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<sem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.second_page,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.sem);
        TextView textView = convertView.findViewById(R.id.sem_name);
        imageView.setImageResource(getItem(position).getSem());
        textView.setText(getItem(position).getSem_name());

        return convertView;
    }

}

