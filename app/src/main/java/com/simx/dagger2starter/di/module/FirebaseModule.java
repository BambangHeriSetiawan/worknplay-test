package com.simx.dagger2starter.di.module;

import android.app.Application;

import com.simx.dagger2starter.data.remote.FirebaseAuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class FirebaseModule {


    @Provides
    @Singleton
    FirebaseAuthService provideFirebaseAuthService(Application application){
        return new FirebaseAuthService(application);
    }
}
