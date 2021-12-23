package com.example.imageviewpager;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ImageSlideAdapter extends PagerAdapter {

    private ArrayList<Integer> imageList;
    private LayoutInflater  inflater;
    private Context         context;

    public ImageSlideAdapter(Context context) {
        this.context = context;
        imageList = new ArrayList<>();
    }

    public ArrayList<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Integer> imageList) {
        this.imageList = imageList;
    }

    public void setImage(int image) {
        imageList.add(image);
    }

    @Override
    public int getCount() {
        Log.d("어댑터", "어댑터 사이즈 : " + imageList.size());
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("어댑터", "instantiateItem : " + position);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_image_slide, container, false);

        ImageView imageView = v.findViewById(R.id.image);
        TextView textView = v.findViewById(R.id.txtTitle);
        TextView count = v.findViewById(R.id.txtImageCount);

        imageView.setImageResource(imageList.get(position));
        String text = (position + 1) + " 번째 이미지";
        textView.setText(text);

        count.setText(imageList.size() + " 장");

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }
}
