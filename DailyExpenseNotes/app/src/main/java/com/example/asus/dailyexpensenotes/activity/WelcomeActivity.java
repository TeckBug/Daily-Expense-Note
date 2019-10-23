package com.example.asus.dailyexpensenotes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.dailyexpensenotes.R;
import com.example.asus.dailyexpensenotes.adapter.SliderAdapter;

public class WelcomeActivity extends AppCompatActivity {

    private LinearLayout mDotsLayout;
    private ViewPager mSlideViewPager;
    private ImageView imageIV;
    private TextView addExpenseTV,descriptionTV;
    private SliderAdapter sliderAdapter;
    private Context context;
    private TextView mDots[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        mSlideViewPager.setAdapter(sliderAdapter);



        mSlideViewPager.addOnPageChangeListener(mListener);






    }

    private void addDotsIndicatior(int position) {
        mDots=new TextView[3];
        mDotsLayout.removeAllViews();

        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentwhite));

            mDotsLayout.addView(mDots[i]);
        }


        mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));




    }

    private void init() {
        mSlideViewPager=findViewById(R.id.mslideViewPager);
        mDotsLayout=findViewById(R.id.mDotsLayout);
        imageIV=findViewById(R.id.centerIV);
        sliderAdapter=new SliderAdapter(this);
    }
    ViewPager.OnPageChangeListener mListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicatior(position);

            if(position==2){
                Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addClickonImage(int position) {

    }
}
