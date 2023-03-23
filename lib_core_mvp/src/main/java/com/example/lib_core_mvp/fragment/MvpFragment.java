package com.example.lib_core_mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lib_core_mvp.presenter.MvpPresenter;
import com.example.lib_core_mvp.view.MvpView;

public abstract class MvpFragment<P extends MvpPresenter> extends Fragment implements MvpView {
    protected View mRootView = null;
    private P mPresenter;
    private final String TAG = "MvpFragment";

    /**
     * 执行该方法时，Fragment与Activity已经完成绑定，该方法有一个Activity类型的参数，
     * 代表绑定的Activity，这时候你可以执行诸如mActivity = activity的操作
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "-----------onAttach---------");
    }

    /**
     * 初始化Fragment。可通过参数savedInstanceState获取之前保存的值。
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-----------onCreate---------");
    }

    /**
     * 初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成，
     * 但是不建议执行耗时的操作，比如读取数据库数据列表。
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "--------onCreateView----------");
        if (mRootView == null) {
            final int layoutId = getLayoutRes();
            if (layoutId > 0) {
                mRootView = inflater.inflate(layoutId, container, false);

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
        mPresenter = getPresenter();
        initialize();
    }


    /**
     * 执行该方法时，与Fragment绑定的Activity的onCreate方法已经执行完成并返回，
     * 在该方法内可以进行与Activity交互的UI操作，所以在该方法之前Activity的onCreate方法并未执行完成，
     * 如果提前进行交互操作，会引发空指针异常
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "--------onActivityCreated----------");
    }

    /**
     * 执行该方法时，Fragment由不可见变为可见状态
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "--------onStart----------");
    }

    /**
     * 执行该方法时，Fragment处于活动状态，用户可与之交互
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "--------onResume----------");
    }

    /**
     * 执行该方法时，Fragment处于暂停状态，但依然可见，用户不能与之交互
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "--------onPause----------");
    }

    /**
     * 保存当前Fragment的状态。该方法会自动保存Fragment的状态，
     * 比如EditText键入的文本，即使Fragment被回收又重新创建，一样能恢复EditText之前键入的文本
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "--------onSaveInstanceState----------");
    }

    /**
     * 执行该方法时，Fragment完全不可见。
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "--------onStop----------");
    }

    /**
     * 销毁与Fragment有关的视图，但未与Activity解除绑定，
     * 依然可以通过onCreateView方法重新创建视图。通常在ViewPager+Fragment的方式下会调用此方法
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "--------onDestroyView----------");
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
    }

    /**
     * 销毁Fragment。通常按Back键退出或者Fragment被回收时调用此方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--------onDestroy----------");
    }

    /**
     * 解除与Activity的绑定。在onDestroy方法之后调用。
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "--------onDetach----------");
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
        Log.d(TAG, "--------setUserVisibleHint----------");
    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }

    public void initialize() {
        initView();
        loadData();
    }


    /**
     * 子类通过调用该方法，获得绑定的presenter
     */
    protected P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();

        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        return mPresenter;
    }

    protected abstract P createPresenter();


    /**
     * 获取布局文件
     */
    protected abstract int getLayoutRes();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 绑定数据
     */
    protected abstract void loadData();

    public View getmRootView() {
        return mRootView;
    }
}
