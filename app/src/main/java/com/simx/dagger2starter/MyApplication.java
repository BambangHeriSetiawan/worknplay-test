package com.simx.dagger2starter;

import android.app.Activity;
import android.app.Application;

import com.simx.dagger2starter.di.component.AppComponent;
import com.simx.dagger2starter.di.component.DaggerAppComponent;



import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by simx on 14/02/18.
 */

public class MyApplication extends Application implements HasActivityInjector{
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        return appComponent;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent  = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
