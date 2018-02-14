package com.simx.dagger2starter.di.module;

import com.simx.dagger2starter.data.model.UserModel;
import com.simx.dagger2starter.data.remote.FirebaseAuthService;
import com.simx.dagger2starter.ui.singin.SingInActivity;
import com.simx.dagger2starter.ui.singin.SingInPresenterImp;
import com.simx.dagger2starter.ui.singin.SinginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class SingInActivityModule {

    @Provides

    SinginView provideSinginActivity(SingInActivity activity){
        return activity;
    }

    @Provides

    SingInPresenterImp provideSinginPresenter(SinginView singinView, FirebaseAuthService firebaseAuthService, UserModel userModel){
        return new SingInPresenterImp(singinView, firebaseAuthService,userModel);
    }
}
