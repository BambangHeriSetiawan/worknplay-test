package com.simx.dagger2starter.di.module;

import com.simx.dagger2starter.data.FirebaseService;
import com.simx.dagger2starter.ui.singin.SingInActivity;
import com.simx.dagger2starter.ui.singin.SingInPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class SingInModule {

    @Provides
    @Singleton
    SingInActivity provideSinginActivity(){
        return new SingInActivity();
    }

    @Provides
    @Singleton
    FirebaseService provideFirebaseService(){
        return new FirebaseService();
    }
    @Provides
    @Singleton
    SingInPresenter provideSinginPresenter(SingInActivity activity, FirebaseService firebaseService){
        return new SingInPresenter(activity,firebaseService);
    }
}
