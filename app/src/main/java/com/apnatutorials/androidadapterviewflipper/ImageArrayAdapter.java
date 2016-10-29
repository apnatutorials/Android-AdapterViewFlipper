package com.apnatutorials.androidadapterviewflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageArrayAdapter extends ArrayAdapter<ImageDetail> {
    ArrayList<ImageDetail> imageList;
    public ImageArrayAdapter(Context context, ArrayList<ImageDetail> objects) {
        super(context, R.layout.image_row, R.id.tvMyTextView, objects);
        this.imageList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        ImageDetail imageDetail = getItem(position);
        if (convertView == null) {
            if (parent == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_row, null);
            else
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.image_row, parent, false);
        }
        TextView tvMyTextView = (TextView) convertView.findViewById(R.id.tvMyTextView);
        ImageView ivMyImageView = (ImageView) convertView.findViewById(R.id.ivMyImageView);
        if (tvMyTextView != null)
            tvMyTextView.setText(imageDetail.getName());


        if (ivMyImageView != null)
            ivMyImageView.setImageResource(imageDetail.getPic());

        return convertView;
    }
}
