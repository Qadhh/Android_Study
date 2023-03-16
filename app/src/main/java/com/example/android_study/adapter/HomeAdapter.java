package com.example.android_study.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.android_study.R;
import com.example.android_study.bean.TabBean;

public class HomeAdapter implements MainFragmentPagerAdapter.Page.TabAdapter<com.example.android_study.bean.TabBean> {
    @Override
    public void onBindData(@NonNull View view, @NonNull TabBean data, boolean selected) {
        TextView itemMenuTvName = view.findViewById(R.id.item_menu_tv_name);
        ImageView itemMenuIcon = view.findViewById(R.id.item_menu_icon);
        itemMenuTvName.setText(data.getString());
        itemMenuIcon.setImageResource(data.getMenu_icon());
        if (selected) {
            itemMenuIcon.setColorFilter(view.getResources().getColor(R.color.light_blue_400));
            itemMenuTvName.setTextColor(view.getResources().getColor(R.color.light_blue_400));
        }else{
            itemMenuIcon.setColorFilter(R.color.black);
            itemMenuTvName.setTextColor(view.getResources().getColor(R.color.black));
        }
    }

    @Override
    public void onDoubleTap(Fragment fragment) {

    }
}
