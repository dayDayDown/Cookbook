package com.example.ming.cookbook.ui.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.DisPlayUtil;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseActivity;

import butterknife.BindView;

public class NewRecipeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.aty_new_recipe_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.aty_new_recipe_title)
    TextView tv_title;
    @BindView(R.id.aty_new_recipe_cancel)
    TextView tv_cancel;
    @BindView(R.id.aty_new_recipe_save)
    TextView tv_save;
    @BindView(R.id.aty_new_recipe_cover_button)
    View coverButton;
    @BindView(R.id.aty_new_recipe_cover)
    ImageView iv_cover;
    @BindView(R.id.aty_new_recipe_cover_hint)
    TextView tv_coverHint;
    @BindView(R.id.aty_new_recipe_name)
    EditText tv_recipeName;

    public static final String EXTRA_RECIPE_NAME = "recipeName";
    private String recipeName;
    public static void startActivity(Activity activity, String name){
        Intent intent = new Intent(activity, NewRecipeActivity.class);
        intent.putExtra(EXTRA_RECIPE_NAME, name);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
        }
    }
    @Override
    protected void initEventAndData() {
        recipeName = getIntent().getStringExtra(EXTRA_RECIPE_NAME);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Explode().setDuration(500));
            getWindow().setExitTransition(new Explode().setDuration(500));
        }
        DisPlayUtil.setImmersiveStatusBarToolbar(mToolbar, this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        tv_cancel.setOnClickListener(this);
        tv_save.setOnClickListener(this);
        tv_recipeName.setText(recipeName);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_recipe;
    }

    @Override
    public BasePresenter newPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aty_new_recipe_cancel:
                NewRecipeActivity.this.finish();
                break;
            case R.id.aty_new_recipe_save:
                break;
            default:
                break;
        }
    }
}
