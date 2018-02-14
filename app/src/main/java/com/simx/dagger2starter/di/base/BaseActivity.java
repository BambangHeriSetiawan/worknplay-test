package com.simx.dagger2starter.di.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjection;

/**
 * Created by simx on 14/02/18.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
