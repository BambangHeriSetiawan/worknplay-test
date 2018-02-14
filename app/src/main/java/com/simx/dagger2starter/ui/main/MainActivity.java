package com.simx.dagger2starter.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simx.dagger2starter.R;
import com.simx.dagger2starter.di.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
