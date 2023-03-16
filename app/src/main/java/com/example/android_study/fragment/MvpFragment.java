package com.example.android_study.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_study.mvp.MvpPresenter;
import com.example.android_study.util.LogUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class MvpFragment<P extends MvpPresenter> extends Fragment {
    protected View mRootView = null;
    private Unbinder mUnbinder = null;

    /**
     * 执行该方法时，Fragment与Activity已经完成绑定，该方法有一个Activity类型的参数，
     * 代表绑定的Activity，这时候你可以执行诸如mActivity = activity的操作
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        LogUtil.d("zx0315", "-----------onAttach---------");
    }

    /**
     * 初始化Fragment。可通过参数savedInstanceState获取之前保存的值。
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("zx0315", "-----------onCreate---------");
    }

    /**
     * 初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成，
     * 但是不建议执行耗时的操作，比如读取数据库数据列表。
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogUtil.d("zx0315", "--------onCreateView----------");
        if (mRootView == null) {
            final int layoutId = getLayoutRes();
            if (layoutId > 0) {
                mRootView = inflater.inflate(getLayoutRes(), container, false);
                mUnbinder = ButterKnife.bind(this, /*getRootView()*/mRootView);
            }
        }
        return mRootView;
    }

    /**
     * onCreateView 返回后，但在任何已保存状态恢复到视图之前立即调用。
     * 这让子类有机会在知道自己的视图层次结构已完全创建后进行自我初始化。
     * 然而，此时片段的视图层次结构并未附加到其父级。
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }


    /**
     * 执行该方法时，与Fragment绑定的Activity的onCreate方法已经执行完成并返回，
     * 在该方法内可以进行与Activity交互的UI操作，所以在该方法之前Activity的onCreate方法并未执行完成，
     * 如果提前进行交互操作，会引发空指针异常
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("zx0315", "--------onActivityCreated----------");
    }

    /**
     * 执行该方法时，Fragment由不可见变为可见状态
     */
    @Override
    public void onStart() {
        super.onStart();
        LogUtil.d("zx0315", "--------onStart----------");
    }

    /**
     * 执行该方法时，Fragment处于活动状态，用户可与之交互
     */
    @Override
    public void onResume() {
        super.onResume();
        LogUtil.d("zx0315", "--------onResume----------");
    }

    /**
     * 执行该方法时，Fragment处于暂停状态，但依然可见，用户不能与之交互
     */
    @Override
    public void onPause() {
        super.onPause();
        LogUtil.d("zx0315", "--------onPause----------");
    }

    /**
     * 保存当前Fragment的状态。该方法会自动保存Fragment的状态，
     * 比如EditText键入的文本，即使Fragment被回收又重新创建，一样能恢复EditText之前键入的文本
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.d("zx0315", "--------onSaveInstanceState----------");
    }

    /**
     * 执行该方法时，Fragment完全不可见。
     */
    @Override
    public void onStop() {
        super.onStop();
        LogUtil.d("zx0315", "--------onStop----------");
    }

    /**
     * 销毁与Fragment有关的视图，但未与Activity解除绑定，
     * 依然可以通过onCreateView方法重新创建视图。通常在ViewPager+Fragment的方式下会调用此方法
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d("zx0315", "--------onDestroyView----------");
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    /**
     * 销毁Fragment。通常按Back键退出或者Fragment被回收时调用此方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("zx0315", "--------onDestroy----------");
    }

    /**
     * 解除与Activity的绑定。在onDestroy方法之后调用。
     */
    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.d("zx0315", "--------onDetach----------");
    }

    /**
     * 设置Fragment可见或者不可见时会调用此方法。
     * 在该方法里面可以通过调用getUserVisibleHint()
     * 获得Fragment的状态是可见还是不可见的，如果可见则进行懒加载操作
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.d("zx0315", "--------setUserVisibleHint----------");
    }


    /**
     * 获取布局文件
     */
    protected abstract int getLayoutRes();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化presenter
     */
    protected abstract P initPresenter();

    /**
     * 绑定数据
     */
    protected abstract void loadData();
}
