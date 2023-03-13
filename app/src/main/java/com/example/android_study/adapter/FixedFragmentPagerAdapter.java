package com.example.android_study.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FixedFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments = null;
    private String[] mTitles = null;

    public FixedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 返回每一页指定位置的Fragment对象
     *
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    /**
     * 返回有多少个Fragment
     *
     * @return
     */
    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.length;
    }

    public void setFragmentList(Fragment... fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
    }
}
