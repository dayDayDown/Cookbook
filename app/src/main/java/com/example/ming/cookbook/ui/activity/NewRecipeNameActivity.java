package com.example.ming.cookbook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.DisPlayUtil;
import com.example.ming.cookbook.presenter.BasePresenter;
import com.example.ming.cookbook.ui.BaseActivity;

import butterknife.BindView;

public class NewRecipeNameActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    @BindView(R.id.aty_new_recipe_name_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.aty_new_recipe_name_title)
    TextView tv_title;
    @BindView(R.id.aty_new_recipe_name_cancel)
    TextView tv_cancel;
    @BindView(R.id.aty_new_recipe_name_next)
    TextView tv_next;
    @BindView(R.id.aty_new_recipe_name_et)
    EditText et_recipe_name;

    public static void startActivity(Context context){
        Intent intent = new Intent(context, NewRecipeNameActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initEventAndData() {
        DisPlayUtil.setImmersiveStatusBarToolbar(mToolbar, this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        tv_cancel.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        et_recipe_name.addTextChangedListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_recipe_name;
    }

    @Override
    public BasePresenter newPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aty_new_recipe_name_cancel:
                NewRecipeNameActivity.this.finish();
                break;
            case R.id.aty_new_recipe_name_next:
                String name = et_recipe_name.getText().toString();
                NewRecipeActivity.startActivity(NewRecipeNameActivity.this, name);
                NewRecipeNameActivity.this.finish();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(TextUtils.isEmpty(s)){
            tv_next.setEnabled(false);
        }else {
            tv_next.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
