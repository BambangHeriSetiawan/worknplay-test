package com.simx.dagger2starter.di.module;

import com.simx.dagger2starter.ui.singin.SingInActivity;
import com.simx.dagger2starter.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by simx on 14/02/18.
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();

    @ContributesAndroidInjector
    abstract SingInActivity singInActivity();
}
