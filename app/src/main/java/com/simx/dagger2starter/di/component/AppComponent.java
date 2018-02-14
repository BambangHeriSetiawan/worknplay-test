package com.simx.dagger2starter.di.component;

import com.simx.dagger2starter.MyApplication;
import com.simx.dagger2starter.di.module.ActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by simx on 14/02/18.
 */
@Component(modules = {AndroidInjectionModule.class, ActivityModule.class})
public interface AppComponent {
    void inject(MyApplication application);
}
