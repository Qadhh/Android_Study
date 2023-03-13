package com.example.android_study.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.viewpager.widget.ViewPager;

import com.example.android_study.R;
import com.example.android_study.adapter.FixedFragmentPagerAdapter;
import com.example.android_study.fragment.MainFragment;
import com.example.android_study.fragment.UserArticleFragment;
import com.example.android_study.mvp.MvpActivity;
import com.example.android_study.presenter.MainPresenter;

import butterknife.BindView;


public class MainActivity extends MvpActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    private FixedFragmentPagerAdapter mFixedFragmentPagerAdapter;

    @Override
    protected void initWindow() {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //getWindow().setBackgroundDrawableResource(R.color.black);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        //在空闲状态下应保留在当前页面任一侧的页面数
        vp.setOffscreenPageLimit(1);
        mFixedFragmentPagerAdapter = new FixedFragmentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mFixedFragmentPagerAdapter);
        //将多个Fragment添加到ViewPager
        mFixedFragmentPagerAdapter.setFragmentList(UserArticleFragment.create(), MainFragment.create());
        //显示第一个条目
        vp.setCurrentItem(1);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 滑动时执行
             * @param position 当前条目
             * @param positionOffset 页面位置的偏移量
             * @param positionOffsetPixels 指示与位置的偏移量
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("zx0313", "onPageScrolled"
                        + ", position = " + position
                        + ", positionOffset = " + positionOffset
                        + ", positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("zx0313", "onPageSelected" + ", position = " + position);
                //new CloseSecondFloorEvent().post();
            }

            /**
             * 滑动停止时执行
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("zx0313", "onPageScrollStateChanged" + ", state = " + state);
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showArticleSuccess() {

    }

    @Override
    public void showArticleFail() {

    }
}