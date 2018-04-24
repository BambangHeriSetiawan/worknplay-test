package com.simx.worknplaytest;

import android.app.Activity;
import android.app.Application;


import com.simx.worknplaytest.di.component.DaggerAppComponent;

import com.simx.worknplaytest.di.module.AppModule;
import com.simx.worknplaytest.di.module.GlideAppModule;
import com.simx.worknplaytest.di.module.NetModule;
import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by simx on 14/02/18.
 */

public class MyApplication extends Application implements HasActivityInjector{
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .application(this)
                .appModule (new AppModule ())
                .glideModule (new GlideAppModule ())
                .netModule (new NetModule ())
                .build()
                .inject(this);
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
