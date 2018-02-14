package com.simx.dagger2starter.ui.main;

import android.content.Context;

import com.google.firebase.firestore.DocumentSnapshot;
import com.simx.dagger2starter.data.model.UserModel;
import com.simx.dagger2starter.data.remote.FirebaseAuthService;

/**
 * Created by simx on 14/02/18.
 */

public class MainPresenterImpl {
    MainView mainView;
    FirebaseAuthService firebaseAuthService;


    public MainPresenterImpl(MainView mainView, FirebaseAuthService firebaseAuthService) {
        this.mainView = mainView;
        this.firebaseAuthService = firebaseAuthService;
    }

    public void geDataUser(String uid) {
        firebaseAuthService
                .getDocumentUser(uid)
                .get()
                .addOnCompleteListener(task -> {
                    DocumentSnapshot snapshot = task.getResult();
                    if (snapshot.exists()){
                        UserModel userModel = snapshot.toObject(UserModel.class);
                        mainView.initProfile(userModel);
                    }
                });
    }
    public void logout(Context context){
        firebaseAuthService.logout(context).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                mainView.gotoLogin();
            }
        });
    }
}
