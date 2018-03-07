package com.example.ming.cookbook.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.presenter.BasePresenter;

/**
 * Created by 17111862 on 2018/2/6.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private boolean allowResetContentView = true;
    private ViewGroup mContentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if(!allowResetContentView){
            super.setContentView(layoutResID);
        }else {
            super.setContentView(R.layout.activity_base);

        }
    }

}
