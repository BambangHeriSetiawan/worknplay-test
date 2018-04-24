package com.simx.worknplaytest.ui.splash;

/**
 * Created by simx on 14/02/18.
 */

public interface SplashView {


    void showProgress(boolean isShow);

    void gotoMain();

    void showError(String message);
}
