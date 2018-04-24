package com.simx.worknplaytest.di.component;

import android.app.Application;

import com.simx.worknplaytest.MyApplication;
import com.simx.worknplaytest.di.module.ActivityBuilder;
import com.simx.worknplaytest.di.module.AppModule;
import com.simx.worknplaytest.di.module.FirebaseModule;
import com.simx.worknplaytest.di.module.SingInActivityModule;
import com.simx.worknplaytest.di.module.SplashActivityModule;
import com.simx.worknplaytest.ui.splash.SplashActivity;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by simx on 14/02/18.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        FirebaseModule.class
})
public interface AppComponent  {

    @Component.Builder
    interface Builder {

        @BindsInstance Builder application(Application application);

        AppComponent build();

        Builder firebase(FirebaseModule firebaseModule);
    }

    void inject(MyApplication application);

}
