package com.example.imageviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager           viewPager;
    private ImageSlideAdapter   adapter;

    private Button  upload1, upload2, upload3, btnSave;
    private ArrayList<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvents();
        viewPager.setAdapter(adapter);
    }

    private void init() {
        upload1 = findViewById(R.id.btnImageUpload1);
        upload2 = findViewById(R.id.btnImageUpload2);
        upload3 = findViewById(R.id.btnImageUpload3);
        btnSave = findViewById(R.id.btnSave);

        viewPager = findViewById(R.id.viewPager);

        adapter = new ImageSlideAdapter(this);
    }

    private void setEvents() {
        btnSave.setOnClickListener(view -> {
            // imageList = new ArrayList<>();
            imageList = adapter.getImageList();
            for (int i = 0; i<imageList.size(); i++) {
                Log.d("메인", "이미지 -> " + imageList.get(i));
            }
        });

        upload1.setOnClickListener(view -> {
            adapter.setImage(R.drawable.image1);
            viewPager.setAdapter(adapter);
        });

        upload2.setOnClickListener(view -> {
            adapter.setImage(R.drawable.image2);
            viewPager.setAdapter(adapter);
        });

        upload3.setOnClickListener(view -> {
            adapter.setImage(R.drawable.image3);
            viewPager.setAdapter(adapter);
        });
    }
}