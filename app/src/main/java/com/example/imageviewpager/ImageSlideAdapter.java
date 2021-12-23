package com.example.imageviewpager;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageSlideAdapter extends PagerAdapter {

    private int[] images = {R.drawable.image1,R.drawable.image2,R.drawable.image3};
    private LayoutInflater  inflater;
    private Context         context;

    public ImageSlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_image_slide, container, false);
        ImageView imageView = v.findViewById(R.id.image);
        TextView textView = v.findViewById(R.id.txtTitle);

        imageView.setImageResource(images[position]);
        String text = (position + 1) + " 번째 이미지";
        textView.setText(text);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }
}
