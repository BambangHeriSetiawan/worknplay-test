package com.simx.worknplaytest.ui.splash;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.simx.worknplaytest.R;
import com.simx.worknplaytest.di.base.BaseActivity;
import com.simx.worknplaytest.helper.NetworkUtils;
import com.simx.worknplaytest.ui.main.MainActivity;
import com.simx.worknplaytest.ui.singin.SingInActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenterImpl presenter;
    @Inject
    NetworkUtils networkUtils;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        if (networkUtils.isNetworkConnected(this)) {
            new Handler().postDelayed(() -> {
                presenter.loadSplash();
            }, 2000);
        } else {
            Toast.makeText(this, "You are not conected to internet" +
                    "\nPlease connect internet first", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onSplashLoad() {
        Log.e("SplashActivity", "onSplashLoad: ");
    }

    @Override
    public void gotoLogin() {
        SingInActivity.start(this);
        this.finish();
    }

    @Override
    public void gotoMain(String uid) {
        MainActivity.start(this,uid);
        this.finish();
    }

    @Override
    public void showProgress(boolean isShow) {
        if (!isShow) {
            pbLoading.setVisibility(View.GONE);
        }else {
            pbLoading.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
