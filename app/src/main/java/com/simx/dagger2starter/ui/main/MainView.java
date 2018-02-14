package com.simx.dagger2starter.ui.main;

import com.simx.dagger2starter.data.model.UserModel;

/**
 * Created by simx on 14/02/18.
 */

public interface MainView {
    void initProfile(UserModel userModel);

    void gotoLogin();
}
