package com.simx.worknplaytest.ui.singin;

import com.simx.worknplaytest.data.model.UserModel;
import com.simx.worknplaytest.ui.singin.SingInActivity;
import com.simx.worknplaytest.ui.singin.SingInPresenterImp;
import com.simx.worknplaytest.ui.singin.SinginView;

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

    SingInPresenterImp provideSinginPresenter(SinginView singinView,  UserModel userModel){
        return new SingInPresenterImp(singinView, userModel);
    }
}
