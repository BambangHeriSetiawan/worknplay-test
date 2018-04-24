package com.simx.worknplaytest.di.module;

import com.simx.worknplaytest.ui.main.MainActivity;
import com.simx.worknplaytest.ui.main.MainActivityModul;
import com.simx.worknplaytest.ui.main.MainActivityModuleProvideFragment;
import com.simx.worknplaytest.ui.main.detail.DetailActivity;
import com.simx.worknplaytest.ui.main.detail.DetailModule;
import com.simx.worknplaytest.ui.singin.SingInActivity;
import com.simx.worknplaytest.ui.singin.SingInActivityModule;
import com.simx.worknplaytest.ui.splash.SplashActivity;

import com.simx.worknplaytest.ui.splash.SplashActivityModule;
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

    @ContributesAndroidInjector(modules = {MainActivityModul.class, MainActivityModuleProvideFragment.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = DetailModule.class)
    abstract DetailActivity detailActivity();

}
