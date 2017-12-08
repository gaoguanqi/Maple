package com.maple.smaple.maple.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maple.smaple.baselibrary.base.BaseActivity;
import com.maple.smaple.commonlibrary.MyCommonTest;
import com.maple.smaple.maple.R;
import com.maple.smaple.maple.test.TestActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivity(new Intent(this, TestActivity.class));

    }


    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();

    }
}
