package com.example.codewithsafy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

class Myadapter  extends PagerAdapter{
    private Context context;
    private ArrayList<Mymodel> mymodelArrayList;

    public Myadapter(Context context, ArrayList<Mymodel> mymodelArrayList) {
        this.context = context;
        this.mymodelArrayList = mymodelArrayList;
    }

    @Override
    public int getCount() {
        return mymodelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_viewpager, container,false);
        TextView tiiptv= view.findViewById(R.id.tips);
        Mymodel model = mymodelArrayList.get(position);
        String tiip= model.getTip();
        tiiptv.setText(tiip);

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
