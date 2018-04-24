package com.simx.worknplaytest.ui.splash;


import javax.inject.Inject;

/**
 * Created by simx on 14/02/18.
 */

public class SplashPresenterImpl implements SplashPresenter {
    SplashView splashView;

    @Inject
    public SplashPresenterImpl(SplashView splashView) {
        this.splashView = splashView;

    }

    @Override
    public void loadSplash() {
        splashView.showProgress(true);
        splashView.gotoMain ();
    }

}
