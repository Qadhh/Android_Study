package com.example.android_study.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.android_study.R;
import com.example.android_study.adapter.HomeAdapter;
import com.example.android_study.adapter.KnowledgeNavigationAdapter;
import com.example.android_study.adapter.MainFragmentPagerAdapter;
import com.example.android_study.adapter.MineAdapter;
import com.example.android_study.adapter.QuestionAdapter;
import com.example.android_study.bean.TabBean;
import com.example.android_study.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.Unbinder;

public class MainFragment extends MvpFragment {

    protected View mRootView = null;
    @BindView(R.id.vp_tab)
    ViewPager vpTab;
    @BindView(R.id.ll_bottom_bar)
    LinearLayout llBottomBar;
    @BindView(R.id.fl_bottom_bar)
    FrameLayout flBottomBar;
    private Unbinder mUnbinder = null;
    private MainFragmentPagerAdapter<TabBean> mTabFragmentPagerAdapter;

    public static MainFragment create() {
        return new MainFragment();
    }


    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

        //将viewPage 底部导航栏，都交给TabFragmentPagerAdapter去实现
        mTabFragmentPagerAdapter = new MainFragmentPagerAdapter<>(getChildFragmentManager(),
                vpTab, llBottomBar, R.layout.item_menu);
        mTabFragmentPagerAdapter.setPages(new MainFragmentPagerAdapter.Page<TabBean>(HomeFragment.create(), new TabBean("首页", R.drawable.ic_bottom_bar_home, -1), new HomeAdapter()),
                new MainFragmentPagerAdapter.Page<TabBean>(QuestionFragment.create(), new TabBean("问答", R.drawable.ic_bottom_bar_ques, -1), new QuestionAdapter()),
                new MainFragmentPagerAdapter.Page<TabBean>(KnowledgeNavigationFragment.create(), new TabBean("体系", R.drawable.ic_bottom_bar_navi, -1), new KnowledgeNavigationAdapter()),
                new MainFragmentPagerAdapter.Page<TabBean>(MineFragment.create(), new TabBean("我的", R.drawable.ic_bottom_bar_mine, -1), new MineAdapter()));

        vpTab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //new CloseSecondFloorEvent().post();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void loadData() {

    }
}
