package com.simx.worknplaytest.ui.singin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.simx.worknplaytest.data.model.UserModel;
import com.simx.worknplaytest.di.base.BaseActivity;
import com.simx.worknplaytest.helper.AppConst;

import java.util.Map;

import javax.inject.Inject;

public class SingInActivity extends BaseActivity implements SinginView {

    @Inject SingInPresenterImp presenterImp;
    @Inject UserModel userModel;

    public static void start(Context context) {
        Intent starter = new Intent(context, SingInActivity.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onLoadSingin(Intent intent) {
        startActivityForResult(intent, AppConst.RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
