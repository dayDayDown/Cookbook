package com.example.ming.cookbook.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.DisPlayUtil;
import com.example.ming.cookbook.model.entity.CookDetailEntity;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseActivity;

import butterknife.BindView;

public class RecipeDetailActivity extends BaseActivity {
    @BindView(R.id.aty_detail_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.aty_detail_author_img)
    ImageView iv_author;
    @BindView(R.id.aty_detail_author_name)
    TextView tv_author;

    private static final String COOK_DETAIL = "cookDetailEntity";
    public static void startActivity(Activity activity, View transitionView, CookDetailEntity entity){
        Intent intent = new Intent(activity, RecipeDetailActivity.class);
        intent.putExtra(COOK_DETAIL, entity);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionView, activity.getString(R.string.text_detail_transition_name));
        activity.startActivity(intent, optionsCompat.toBundle());
    }

    @Override
    protected void initEventAndData() {
        DisPlayUtil.setImmersiveStatusBarToolbar(mToolbar, this);
        mToolbar.setTitle("详情");
        setSupportActionBar(mToolbar);
        showNavigationBack();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recipe_detail;
    }

    @Override
    public BasePresenter newPresenter() {
        return null;
    }

    /**
     * 显示标题栏左上角View
     */
    private void showNavigationBack() {
        ActionBar ab = getSupportActionBar();
        if (ab != null && mToolbar != null) {
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        RecipeDetailActivity.this.finishAfterTransition();
                    }else {
                        RecipeDetailActivity.this.finish();
                    }
                }
            });
        }
    }
}
