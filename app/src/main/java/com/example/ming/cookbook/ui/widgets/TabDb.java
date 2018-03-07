package com.example.ming.cookbook.ui.widgets;

import android.content.Context;
import android.content.res.Resources;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.ui.fragment.DiscoveryFragment;
import com.example.ming.cookbook.ui.fragment.HomeFragment;
import com.example.ming.cookbook.ui.fragment.MemberFragment;
import com.example.ming.cookbook.ui.fragment.SortFragment;

/**
 * Created by 17111862 on 2018/2/25.
 */

public class TabDb {
    private static String[] tabsTxt;
    private static int[] tabsImg;
    private static int[] tabsImgLight;
    private static Class[] tabsFragments;

    public static void initData(Context context) {
        if (context == null) {
            return;
        }
        Resources resources = context.getResources();
            tabsTxt = new String[]{
                    resources.getString(R.string.activity_main_home),
                    resources.getString(R.string.activity_main_sort),
                    resources.getString(R.string.activity_main_find),
                    resources.getString(R.string.activity_main_member)};
            tabsImg = new int[]{R.drawable.ic_home, R.drawable.ic_sort,
                    R.drawable.ic_find, R.drawable.ic_member};
            tabsImgLight = new int[]{R.drawable.ic_home_light, R.drawable.ic_sort_light,
                    R.drawable.ic_find_light, R.drawable.ic_member_light};
            tabsFragments = new Class[]{HomeFragment.class, SortFragment.class,
                    DiscoveryFragment.class, MemberFragment.class};
    }

    public static String[] getTabsTxt() {
        return tabsTxt;
    }

    public static int[] getTabsImg() {
        return tabsImg;
    }

    public static int[] getTabsImgLight() {
        return tabsImgLight;
    }

    public static Class[] getFragments() {
        return tabsFragments;
    }
}
