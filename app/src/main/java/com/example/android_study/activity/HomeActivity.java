package com.example.android_study.activity;

import android.content.Context;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.android_study.R;
import com.example.android_study.adapter.FixedFragmentPagerAdapter;
import com.example.android_study.fragment.MainFragment;
import com.example.android_study.fragment.UserArticleFragment;
import com.example.android_study.presenter.MainPresenter;
import com.example.lib_core_mvp.util.LogUtil;
import com.example.lib_core_mvp.presenter.MvpPresenter;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

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
                LogUtil.d("zx0313", "onPageScrolled"
                        + ", position = " + position
                        + ", positionOffset = " + positionOffset
                        + ", positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtil.d("zx0313", "onPageSelected" + ", position = " + position);
                //new CloseSecondFloorEvent().post();
            }

            /**
             * 滑动停止时执行
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                LogUtil.d("zx0313", "onPageScrollStateChanged" + ", state = " + state);
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {

        return new MainPresenter();
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void succeed() {

    }

    @Override
    public void error() {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
