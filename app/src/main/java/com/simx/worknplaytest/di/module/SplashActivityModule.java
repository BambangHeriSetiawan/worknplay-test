package com.simx.worknplaytest.di.module;


import com.simx.worknplaytest.ui.splash.SplashActivity;
import com.simx.worknplaytest.ui.splash.SplashPresenterImpl;
import com.simx.worknplaytest.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class SplashActivityModule {

    @Provides
    SplashView splashView(SplashActivity splashActivity){
        return splashActivity;
    }


    @Provides
    SplashPresenterImpl provideSplahPresenter(SplashView splashView ){
        return new SplashPresenterImpl(splashView);
    }

}
