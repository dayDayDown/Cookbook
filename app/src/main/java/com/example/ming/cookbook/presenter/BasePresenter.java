package com.example.ming.cookbook.presenter;

import com.example.ming.cookbook.IView.IBaseView;

/**
 * Created by 17111862 on 2018/2/7.
 */

public class BasePresenter<T extends IBaseView> {
    protected String TAG;
    protected T viewCallback;

    protected BasePresenter(T iView) {
        this.viewCallback = iView;
        TAG = this.getClass().getSimpleName();
    }

    public void onDestroy() {
        viewCallback = null;
    }
}
