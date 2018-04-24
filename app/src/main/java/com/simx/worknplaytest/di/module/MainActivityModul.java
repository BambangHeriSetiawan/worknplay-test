package com.simx.worknplaytest.di.module;

import com.simx.worknplaytest.helper.ObservableHelper;
import com.simx.worknplaytest.ui.main.MainActivity;
import com.simx.worknplaytest.ui.main.MainPresenterImpl;
import com.simx.worknplaytest.ui.main.MainView;

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
    MainPresenterImpl provideMainPresenterImp(MainView mainView, ObservableHelper observableHelper){
        return new MainPresenterImpl(mainView, observableHelper);
    }
}
