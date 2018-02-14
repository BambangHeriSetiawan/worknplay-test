package com.simx.dagger2starter.di.module;


import com.simx.dagger2starter.data.remote.FirebaseAuthService;
import com.simx.dagger2starter.ui.splash.SplashActivity;
import com.simx.dagger2starter.ui.splash.SplashPresenterImpl;
import com.simx.dagger2starter.ui.splash.SplashView;

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
    SplashPresenterImpl provideSplahPresenter(SplashView splashView, FirebaseAuthService firebaseAuthService){
        return new SplashPresenterImpl(splashView,firebaseAuthService);
    }

}
