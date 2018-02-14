package com.simx.dagger2starter.ui.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simx.dagger2starter.R;
import com.simx.dagger2starter.di.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
