package com.example.ming.cookbook.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.example.ming.cookbook.common.DisPlayUtil;
import com.example.ming.cookbook.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 17111862 on 2018/2/6.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T mPresenter;
    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            DisPlayUtil.MIUISetStatusBarLightMode(this.getWindow(), true);
            DisPlayUtil.FlymeSetStatusBarLightMode(this.getWindow(), true);
        }
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mPresenter = newPresenter();
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }
    }

    /**
     * 初始化时间和数据,调用在onCreate方法中
     */
    protected abstract void initEventAndData();

    /**
     * 布局Id
     * R.layout.xx
     */
    public abstract int getLayoutId();

    public abstract T newPresenter();

}
