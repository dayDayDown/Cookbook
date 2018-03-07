package com.example.ming.cookbook.ui.fragment;

import android.view.View;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseFragment;

/**
 * Created by 17111862 on 2018/2/25.
 */

public class DiscoveryFragment extends BaseFragment {

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initEventAndData(View rootView) {

    }
}
