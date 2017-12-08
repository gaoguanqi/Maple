package com.maple.smaple.maple.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.maple.smaple.maple.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaogu on 2017/12/8.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.button)
    public void onClick() {
        action();
    }

    private void action() {

    }
}
