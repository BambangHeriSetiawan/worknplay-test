package com.simx.dagger2starter.ui.singin;

import com.simx.dagger2starter.data.FirebaseService;

/**
 * Created by simx on 14/02/18.
 */

public class SingInPresenter {
    SingInActivity activity;
    FirebaseService service;

    public SingInPresenter(SingInActivity activity, FirebaseService service) {
        this.activity = activity;
        this.service = service;
    }
}
