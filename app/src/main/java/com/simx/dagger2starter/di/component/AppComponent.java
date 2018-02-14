package com.simx.dagger2starter.di.component;

import com.simx.dagger2starter.MyApplication;
import com.simx.dagger2starter.di.module.ActivityModule;
import com.simx.dagger2starter.di.module.SingInModule;
import com.simx.dagger2starter.di.module.SplashActivityModule;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;

/**
 * Created by simx on 14/02/18.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityModule.class,
        SplashActivityModule.class,
        SingInModule.class
})
public interface AppComponent   {
    void inject(MyApplication application);

}
