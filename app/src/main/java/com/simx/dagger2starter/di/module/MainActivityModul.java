package com.simx.dagger2starter.di.module;

import com.simx.dagger2starter.data.remote.FirebaseAuthService;
import com.simx.dagger2starter.ui.main.MainActivity;
import com.simx.dagger2starter.ui.main.MainPresenterImpl;
import com.simx.dagger2starter.ui.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by simx on 14/02/18.
 */
@Module
public class MainActivityModul {
    @Provides
    MainView mainView(MainActivity mainActivity){
        return mainActivity;
    }
    @Provides
    MainPresenterImpl provideMainPresenterImp(MainView mainView, FirebaseAuthService firebaseAuthService){
        return new MainPresenterImpl(mainView,firebaseAuthService);
    }
}
