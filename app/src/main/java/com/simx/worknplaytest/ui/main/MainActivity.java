package com.simx.worknplaytest.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.simx.worknplaytest.R;
import com.simx.worknplaytest.di.base.BaseActivitySupportFragment;
import com.simx.worknplaytest.ui.main.list.FragmentPopularMovie;
import javax.inject.Inject;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivitySupportFragment implements MainView {

    @Inject
    MainPresenterImpl presenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment () {
        FragmentManager fm = getSupportFragmentManager ();
        FragmentTransaction ft = fm.beginTransaction ();
        ft.replace (R.id.frame,FragmentPopularMovie.newInstance ()).commit ();
    }

}
