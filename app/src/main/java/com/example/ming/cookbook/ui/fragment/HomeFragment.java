package com.example.ming.cookbook.ui.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.Constant;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseFragment;
import com.example.ming.cookbook.ui.adapter.BaseFragmentPagerAdapter;
import com.example.ming.cookbook.ui.widgets.EasyTabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ming on 2018/2/25.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.frg_home_new_cook)
    ImageView newCookButton;
    @BindView(R.id.frg_home_search)
    View searchView;
    @BindView(R.id.frg_home_speak_search)
    ImageView speakSearchView;
    @BindView(R.id.frg_home_msg)
    ImageView msgButton;

    /***********
     * 顶部导航栏
     **************/
    @BindView(R.id.frg_home_intelligent)
    View intelligentButton;
    @BindView(R.id.frg_home_season)
    View seasonButton;
    @BindView(R.id.frg_home_rank)
    View rankButton;
    @BindView(R.id.frg_home_register)
    View registerButton;

    /**************
     * 每日三餐推荐
     *****************/
    @BindView(R.id.daily_recommend_name)
    TextView dailyRecommendName;
    @BindView(R.id.daily_recommend_more)
    TextView recommendMoreButton;
    @BindView(R.id.daily_recommend_viewPager)
    ViewPager recommendViewPager;
    @BindView(R.id.daily_recommend_tabLayout)
    EasyTabLayout recommendTabLayout;

    private String mDailyRecommendType;

    private static final int[] RECOMMEND_TYPE_NAME = {
            R.string.text_breakfast,
            R.string.text_lunch,
            R.string.text_afternoon_tea,
            R.string.text_dinner,
            R.string.text_supper
    };
    private static final String [] RECOMMEND_TYPE_ID = {
            Constant.TYPE_BREAKFAST,
            Constant.TYPE_LUNCH,
            Constant.TYPE_AFTERNOON_TEA,
            Constant.TYPE_DINNER,
            Constant.TYPE_SUPPER
    };
    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEventAndData(View rootView) {
        newCookButton.setOnClickListener(this);
        searchView.setOnClickListener(this);
        speakSearchView.setOnClickListener(this);
        msgButton.setOnClickListener(this);

        intelligentButton.setOnClickListener(this);
        seasonButton.setOnClickListener(this);
        rankButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        initDailyRecommend();
    }

    /**
     * 每日三餐推荐
     */
    private void initDailyRecommend(){
        recommendMoreButton.setOnClickListener(this);
        List<BaseFragment> fragmentList = new ArrayList<>();
        DailyRecommendFragment breakFastFragment = DailyRecommendFragment.newInstance(Constant.TYPE_BREAKFAST);
        DailyRecommendFragment lunchFragment = DailyRecommendFragment.newInstance(Constant.TYPE_LUNCH);
        DailyRecommendFragment afternoonTeaFragment = DailyRecommendFragment.newInstance(Constant.TYPE_AFTERNOON_TEA);
        DailyRecommendFragment dinnerFragment = DailyRecommendFragment.newInstance(Constant.TYPE_DINNER);
        DailyRecommendFragment supperFragment = DailyRecommendFragment.newInstance(Constant.TYPE_SUPPER);
        fragmentList.add(breakFastFragment);
        fragmentList.add(lunchFragment);
        fragmentList.add(afternoonTeaFragment);
        fragmentList.add(dinnerFragment);
        fragmentList.add(supperFragment);
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getChildFragmentManager(), getActivity());
        pagerAdapter.setTabTitle(RECOMMEND_TYPE_NAME);
        pagerAdapter.setFragmentList(fragmentList);
        recommendViewPager.setAdapter(pagerAdapter);
        recommendViewPager.addOnPageChangeListener(this);
        recommendViewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        recommendTabLayout.setupWithViewPager(recommendViewPager);
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int position = 0;
        if(currentHour >= 4 && currentHour < 10){
            position = 0;
        } else if(currentHour >= 10 && currentHour < 14){
            position = 1;
        }else if(currentHour >= 14 && currentHour < 16){
            position = 2;
        }else if(currentHour >= 16 && currentHour < 20){
            position =3;
        }else{
            position = 4;
        }
        recommendViewPager.setCurrentItem(position);
        String type = getString(RECOMMEND_TYPE_NAME[position]);
        dailyRecommendName.setText(getString(R.string.text_home_daily_recommend, type));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frg_home_new_cook:
                break;
            case R.id.frg_home_search:
                break;
            case R.id.frg_home_speak_search:
                break;
            case R.id.frg_home_msg:
                break;
            case R.id.frg_home_intelligent:
                break;
            case R.id.frg_home_season:
                break;
            case R.id.frg_home_rank:
                break;
            case R.id.frg_home_register:
                break;
            case R.id.daily_recommend_more:
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        String type = getString(RECOMMEND_TYPE_NAME[position]);
        dailyRecommendName.setText(getString(R.string.text_home_daily_recommend, type));
        mDailyRecommendType = RECOMMEND_TYPE_ID[position];
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
