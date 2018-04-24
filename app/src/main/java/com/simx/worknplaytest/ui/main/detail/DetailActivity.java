package com.simx.worknplaytest.ui.main.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.simx.worknplaytest.R;
import com.simx.worknplaytest.di.base.BaseActivity;
import com.simx.worknplaytest.di.module.GlideApp;

public class DetailActivity extends BaseActivity implements DetailPresenter {

  @BindView(R.id.my_toolbar)
  Toolbar myToolbar;
  @BindView(R.id.img_full)
  ImageView imgFull;
  public static void start(Context context, String path) {
      Intent starter = new Intent(context, DetailActivity.class);
      starter.putExtra("path",path);
      context.startActivity(starter);
  }
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_detail);
    ButterKnife.bind (this);
    Bundle bundle = getIntent ().getExtras ();
    setSupportActionBar (myToolbar);
    getSupportActionBar ().setTitle ("Detail");
    getSupportActionBar ().setHomeButtonEnabled (true);
    getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
    if (bundle!=null){
      String pathImage = bundle.getString ("path");
      GlideApp.with (getApplicationContext ()).load (pathImage).placeholder (R.mipmap.ic_launcher).into (imgFull);
    }

  }

  @Override
  public boolean onCreateOptionsMenu (Menu menu) {
    getMenuInflater ().inflate (R.menu.detail,menu);
    return super.onCreateOptionsMenu (menu);
  }

  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    switch (item.getItemId ()) {
      case android.R.id.home:
        onBackPressed ();
        break;
      case R.id.nav_download:
        break;
    }
    return super.onOptionsItemSelected (item);
  }
}
