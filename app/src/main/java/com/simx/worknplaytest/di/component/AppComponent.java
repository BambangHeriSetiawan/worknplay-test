package com.simx.worknplaytest.di.component;

import android.app.Application;

import com.bumptech.glide.annotation.GlideModule;
import com.simx.worknplaytest.MyApplication;
import com.simx.worknplaytest.di.module.ActivityBuilder;
import com.simx.worknplaytest.di.module.AppModule;


import com.simx.worknplaytest.di.module.GlideAppModule;
import com.simx.worknplaytest.di.module.NetModule;
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
        ActivityBuilder.class,
        NetModule.class,
        GlideAppModule.class
})
public interface AppComponent  {

    @Component.Builder
    interface Builder {

        @BindsInstance Builder application(Application application);

        AppComponent build();
        Builder appModule(AppModule appModule);
        Builder glideModule(GlideAppModule glideAppModule);
        Builder netModule(NetModule netModule);

    }

    void inject(MyApplication application);

}
