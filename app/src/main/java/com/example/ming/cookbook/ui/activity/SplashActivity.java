package com.example.ming.cookbook.ui.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ming.cookbook.R;
import com.example.ming.cookbook.common.Constant;
import com.example.ming.cookbook.ui.BaseActivity;

public class SplashActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        decorView .setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE);

        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView(){
        tv_skip = findViewById(R.id.activity_splash_tv_skip);
        tv_skip.setOnClickListener(this);
        MyCountDownTimer myCountDownTimer
                = new MyCountDownTimer(Constant.TIME_VALUE_SECOND * 4, Constant.TIME_VALUE_SECOND);
        myCountDownTimer.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_splash_tv_skip:
                MainActivity.startActivity(SplashActivity.this);
                SplashActivity.this.overridePendingTransition(0,0);
                SplashActivity.this.finish();
                break;
            default:
                break;
        }
    }

    /**
     * 倒数计时器
     */
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            int secondRemain = (int)(l / Constant.TIME_VALUE_SECOND);
            tv_skip.setText(getString(R.string.activity_splash_skip, secondRemain));
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            tv_skip.setText(getString(R.string.activity_splash_skip, 0));
            MainActivity.startActivity(SplashActivity.this);
            SplashActivity.this.overridePendingTransition(0,0);
            SplashActivity.this.finish();
        }
    }
}
