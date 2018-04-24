package com.simx.worknplaytest.ui.singin;

import com.simx.worknplaytest.data.model.UserModel;

/**
 * Created by simx on 14/02/18.
 */

public class SingInPresenterImp {
    SinginView singinView;

    UserModel userModel;
    public SingInPresenterImp(SinginView singinView, UserModel userModel) {
        this.singinView = singinView;
        this.userModel = userModel;
    }


}
