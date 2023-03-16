package com.example.android_study.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainFragmentPagerAdapter<T> extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    ViewPager mViewPager;
    LinearLayout navigation_menu;
    int menu;
    private Page<T>[] mPages = null;

    public MainFragmentPagerAdapter(@NonNull FragmentManager fm, ViewPager viewPager,
                                    LinearLayout navigation_menu, int menu) {
        super(fm);
        this.mViewPager = viewPager;
        this.navigation_menu = navigation_menu;
        this.menu = menu;
        mViewPager.setAdapter(this);
        mViewPager.addOnPageChangeListener(this);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mPages[position].fragment;
    }

    @Override
    public int getCount() {
        return mPages == null ? 0 : mPages.length;
    }

    /**
     * 设置每个页面
     */
    @SafeVarargs
    public final void setPages(Page<T>... pages) {
        mViewPager.setOffscreenPageLimit(pages.length);
        navigation_menu.removeAllViews();
        mPages = pages;
        for (Page<T> page : mPages) {
            initPageTab(page);
        }
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        notifyPageDataChanged();
    }


    private void initPageTab(Page<T> page) {
        //将底部导航栏以和导航栏item设置给每个页面的底部view
        page.view = LayoutInflater.from(navigation_menu.getContext()).inflate(menu, navigation_menu, false);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) page.view.getLayoutParams();
        params.height = LinearLayout.LayoutParams.MATCH_PARENT;
        params.width = 0;
        params.weight = 1;
        navigation_menu.addView(page.view, params);
        //设置底部导航栏菜单按钮的点击监听
        page.view.setOnClickListener(view -> {
            setCurrentPage(page);
        });
    }


    private void setCurrentPage(Page<T> page) {
        for (int i = 0; i < mPages.length; i++) {
            if (mPages[i] == page) {
                mViewPager.setCurrentItem(i);
            }
        }
    }

    private void notifyPageDataChanged() {
        int currPos = mViewPager.getCurrentItem();
        for (int i = 0; i < mPages.length; i++) {
            mPages[i].notifyAdapterBindData(currPos == i);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mPages.length; i++) {
            Page<T> page = mPages[i];
            //滑动viewPage 更新底部导航栏数据
            page.notifyAdapterBindData(position == i);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 每个页面模型
     * @param <T>
     */
    public static class Page<T> {
        private Fragment fragment;
        private T data;
        private View view;
        private TabAdapter<T> adapter;

        public Page(Fragment fragment, T data, TabAdapter<T> adapter) {
            this.fragment = fragment;
            this.data = data;
            this.adapter = adapter;
        }

        public T getData() {
            return data;
        }

        public void notifyAdapterBindData(boolean selected) {
            adapter.onBindData(view, data, selected);
        }


        public interface TabAdapter<T> {
            void onBindData(@NonNull View view, @NonNull T data, boolean selected);

            void onDoubleTap(Fragment fragment);
        }
    }


}
