package com.simx.dagger2starter.di.module;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class SplashActivityModule {
    @Provides
    @Singleton
    static RequestManager provideGlideRequestManager(Application application){
        return Glide.with(application);
    }

}
