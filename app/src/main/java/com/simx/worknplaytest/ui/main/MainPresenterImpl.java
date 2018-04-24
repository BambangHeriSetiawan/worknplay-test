package com.simx.worknplaytest.ui.main;

import com.simx.worknplaytest.helper.ObservableHelper;
import javax.inject.Inject;

/**
 * Created by simx on 14/02/18.
 */

public class MainPresenterImpl {
    MainView mainView;
    ObservableHelper helper;
    @Inject
    public MainPresenterImpl(MainView mainView, ObservableHelper observableHelper) {
        this.mainView = mainView;
        this.helper = observableHelper;
    }


}
