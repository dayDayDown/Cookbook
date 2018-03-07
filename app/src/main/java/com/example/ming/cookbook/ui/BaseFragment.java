package com.example.ming.cookbook.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ming.cookbook.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 17111862 on 2018/2/25.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        getPresenter();
        initEventAndData(rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }
    }

    protected abstract T getPresenter();

    protected abstract int getLayoutId();

    protected abstract void initEventAndData(View rootView);
}
