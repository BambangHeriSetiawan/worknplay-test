package com.simx.dagger2starter.di.module;

import com.simx.dagger2starter.ui.main.MainActivity;
import com.simx.dagger2starter.ui.singin.SingInActivity;
import com.simx.dagger2starter.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by simx on 14/02/18.
 */
@Module
public abstract class ActivityBuilder {



    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity splashActivity();

    @ContributesAndroidInjector (modules = SingInActivityModule.class)
    abstract SingInActivity singInActivity();

    @ContributesAndroidInjector(modules = MainActivityModul.class)
    abstract MainActivity mainActivity();

}
