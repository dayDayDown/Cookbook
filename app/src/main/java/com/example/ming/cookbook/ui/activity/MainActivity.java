package com.example.ming.cookbook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseActivity;
import com.example.ming.cookbook.ui.widgets.TabDb;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    @BindView(android.R.id.tabhost)
    FragmentTabHost tabHost;

    public static void startActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initEventAndData() {
        tabHost.setup(this, super.getSupportFragmentManager()
                , R.id.aty_main_contentLayout);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);
        initTab();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter newPresenter() {
        return null;
    }

    private void initTab() {
        TabDb.initData(this);
        String[] tabs = TabDb.getTabsTxt();
        if (tabs == null) {
            return;
        }
        for (int i = 0; i < tabs.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec, TabDb.getFragments()[i], null);
            tabHost.setTag(i);
        }
    }

    private View getTabView(int idx) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_main_tabs, null);
        ((TextView) view.findViewById(R.id.tvTab)).setText(TabDb.getTabsTxt()[idx]);
        ImageView iv = (ImageView) view.findViewById(R.id.ivImg);
        iv.setImageResource(TabDb.getTabsImg()[idx]);
        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        TabWidget tabs = tabHost.getTabWidget();
        for (int i = 0; i < tabs.getChildCount(); i++) {
            View view = tabs.getChildAt(i);
            ImageView iv = view.findViewById(R.id.ivImg);
            if (i == tabHost.getCurrentTab()) {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.fontColorSelected));
                iv.setImageResource(TabDb.getTabsImgLight()[i]);
            } else {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.fontColorUnSelected));
                iv.setImageResource(TabDb.getTabsImg()[i]);
            }
        }
    }
}
