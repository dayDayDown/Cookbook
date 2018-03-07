package com.example.ming.cookbook.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.Constant;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseFragment;
import com.example.ming.cookbook.ui.activity.CookDetailActivity;

import butterknife.BindView;

/**
 * Created by 17111862 on 2018/3/1.
 */

public class DailyRecommendFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.frg_daily_first_cook)
    View firstLayout;
    @BindView(R.id.frg_iv_daily_first)
    ImageView ivFirstImage;
    @BindView(R.id.frg_tv_daily_first)
    TextView tvFirstName;
    @BindView(R.id.frg_daily_second_cook)
    View secondLayout;
    @BindView(R.id.frg_iv_daily_second)
    ImageView ivSecondImage;
    @BindView(R.id.frg_tv_daily_second)
    TextView tvSecondName;

    private String mRecommendType;

    public static DailyRecommendFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString(Constant.DAILY_RECOMMEND_TYPE, type);
        DailyRecommendFragment fragment = new DailyRecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_recommend;
    }

    @Override
    protected void initEventAndData(View rootView) {
        Bundle bundle = getArguments();
        if(bundle != null){
            mRecommendType = bundle.getString(Constant.DAILY_RECOMMEND_TYPE);
        }
        firstLayout.setOnClickListener(this);
        secondLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frg_daily_first_cook:
                CookDetailActivity.startActivity(getActivity(), ivFirstImage);
                break;
            case R.id.frg_daily_second_cook:
                CookDetailActivity.startActivity(getActivity(), ivSecondImage);
                break;
            default:
                break;
        }
    }
}
