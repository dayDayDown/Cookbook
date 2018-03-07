package com.example.ming.cookbook.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.example.ming.cookbook.ui.BaseFragment;

import java.util.List;

/**
 * Created by ming on 2018/3/1.
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    //View page title
    private int[] mTabTitle;

    FragmentManager mFm;

    //View page content
    List<BaseFragment> mFragmentList;

    public void setTabTitle(int[] tabTitle) {
        this.mTabTitle = tabTitle;
    }

    public void setFragmentList(List<BaseFragment> fragmentList) {
        this.mFragmentList = fragmentList;
    }

    public BaseFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        mFm = fm;
    }

    @Override
    public int getCount() {
        if (mFragmentList == null)
            return 0;
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragmentList == null)
            return null;
        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTabTitle == null) {
            return super.getPageTitle(position);
        }
        return mContext.getString(mTabTitle[position]);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //拿到缓存的fragment，如果没有缓存的，就新建一个，新建发生在fragment的第一次初始化时
        Fragment f = (Fragment) super.instantiateItem(container, position);
        String fragmentTag = f.getTag();
        if (f != getItem(position)) {
            //如果是新建的fragment，f 就和getItem(position)是同一个fragment，否则进入下面
            FragmentTransaction ft = mFm.beginTransaction();
            //移除旧的fragment
            ft.remove(f);
            //换成新的fragment
            f = getItem(position);
            //添加新fragment时必须用前面获得的tag
            ft.add(container.getId(), f, fragmentTag);
            ft.attach(f);
            ft.commitAllowingStateLoss();
        }
        return f;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
