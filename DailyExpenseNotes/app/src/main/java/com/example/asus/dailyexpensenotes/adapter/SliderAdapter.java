package com.example.asus.dailyexpensenotes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.asus.dailyexpensenotes.R;


public class SliderAdapter extends PagerAdapter {
    private Context context;
    private int mark;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;

    }

    public int[] slide_images = {
            R.drawable.group_10,
            R.drawable.group_11,
            R.drawable.group_12
    };

    public String[] slide_headings = {
            "Add your Expense",
            "Show your Dash Board",
            "Show your Expense List"
    };

    public String[] slide_description = {
            "In this section you can add your daily expense here. More over you can add the document if any",
            "In this section you can see your total expense and you can filter those expense by date range and expense type",
            "In this section you can see your total expense list and you can filter those list by date and type"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView=(ImageView) view.findViewById(R.id.centerIV);
        TextView heading=(TextView) view.findViewById(R.id.addExpenseTV);
        TextView description=(TextView) view.findViewById(R.id.descriptionTV);

        imageView.setImageResource(slide_images[position]);
        heading.setText(slide_headings[position]);
        description.setText(slide_description[position]);







        container.addView(view);



        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
