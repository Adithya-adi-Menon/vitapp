package com.example.vitapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class intoslider extends AppCompatActivity {
    private ViewPageFragmentAdapter viewPageFragmentAdapter;
    List<sliderclass> list = new ArrayList<>();
   private ViewPager2 viewPager2;
    Button next;
    Button skip;
    Button start;
    int position=1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intoslider);
        setupOnbaoding();
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(viewPageFragmentAdapter);
        next = (Button) findViewById(R.id.next);
        start = (Button) findViewById(R.id.start);
        skip = (Button) findViewById(R.id.skip);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<list.size())
                     viewPager2.setCurrentItem(position,true);
                     position++;

                if(position==list.size()){
                    next.setVisibility(View.INVISIBLE);
                    start.setVisibility(View.VISIBLE);
                }

            }




        });

         skip.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         Intent intent=new Intent(getApplicationContext(),MainActivity.class);
         startActivity(intent);
         finish();
        }
            });


         start.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
                 finish();
             }
         });
         int butt=viewPager2.getCurrentItem();

        if(butt==list.size()){
            start.setVisibility(View.VISIBLE);
        }

       }

    private void setupOnbaoding() {

        sliderclass scan = new sliderclass("Scan the given unique QR code and get Inside the places inorder to maintain Social Distancing", "Scan-QR", R.drawable.scan);
        sliderclass wash = new sliderclass("Wash your hands before you enter into any place and make sure you wear a mask !!!..", "Covid-19", R.drawable.wash);
        sliderclass lunch = new sliderclass("Limited people are allowed to get inside.Have a nice food with your friends", "Hotels", R.drawable.lunch);
        list.add(scan);
        list.add(wash);
        list.add(lunch);
        viewPageFragmentAdapter = new ViewPageFragmentAdapter(list);

    }



}



