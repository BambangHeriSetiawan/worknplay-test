package com.simx.worknplaytest.di.component;

import android.app.Application;

import com.simx.worknplaytest.MyApplication;
import com.simx.worknplaytest.di.module.ActivityBuilder;
import com.simx.worknplaytest.di.module.AppModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by simx on 14/02/18.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent  {

    @Component.Builder
    interface Builder {

        @BindsInstance Builder application(Application application);

        AppComponent build();


    }

    void inject(MyApplication application);

}
