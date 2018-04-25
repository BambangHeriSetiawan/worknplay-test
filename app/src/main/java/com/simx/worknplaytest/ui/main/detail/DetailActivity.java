package com.simx.worknplaytest.ui.main.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.simx.worknplaytest.R;
import com.simx.worknplaytest.di.base.BaseActivity;
import com.simx.worknplaytest.di.module.GlideApp;
import com.simx.worknplaytest.helper.AppConst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class DetailActivity extends BaseActivity implements DetailPresenter, EasyPermissions.PermissionCallbacks {

  @BindView(R.id.my_toolbar)
  Toolbar myToolbar;
  @BindView(R.id.img_full)
  ImageView imgFull;
  String pathImage;
  @Inject
  DetailPresenterImpl presenter;
  File mediaFile;
  File root;
  @BindView(R.id.container)
  CoordinatorLayout container;
  @BindView(R.id.progres_view)
  ProgressBar progresView;

  public static void start (Context context, String path) {
    Intent starter = new Intent (context, DetailActivity.class);
    starter.putExtra ("path", path);
    context.startActivity (starter);
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
    if (bundle != null) {
      pathImage = bundle.getString ("path");
      GlideApp.with (getApplicationContext ()).load (pathImage).placeholder (R.mipmap.ic_launcher)
          .into (imgFull);
    }

  }

  @Override
  public boolean onCreateOptionsMenu (Menu menu) {
    getMenuInflater ().inflate (R.menu.detail, menu);
    return super.onCreateOptionsMenu (menu);
  }

  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    switch (item.getItemId ()) {
      case android.R.id.home:
        onBackPressed ();
        break;
      case R.id.nav_download:
        downloadTask ();
        break;
    }
    return super.onOptionsItemSelected (item);
  }

  private void downloadTask () {
    if (hasStoreagePermmission ()) {
      presenter.downloadImage (pathImage);
    } else {
      EasyPermissions
          .requestPermissions (this, "Permisson Storage", AppConst.STOREAGE_PERMISSION_CODE,
              AppConst.STORAGE_PERMISSION);
    }
  }

  @AfterPermissionGranted(AppConst.STOREAGE_PERMISSION_CODE)
  @Override
  public void saveToDisk (ResponseBody response) {
    if (isExternalStorageWritable ()) {
      root = new File (Environment.getExternalStoragePublicDirectory (
          Environment.DIRECTORY_PICTURES), "worknPlay");
      if (!root.exists ()) {
        mediaFile.mkdir ();
      }
      mediaFile = new File (root + File.separator, System.currentTimeMillis () + ".png");
    }
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
      byte[] fileReader = new byte[4096];
      long fileSize = response.contentLength ();
      long fileSizeDownloaded = 0;
      inputStream = response.byteStream ();
      outputStream = new FileOutputStream (mediaFile);
      while (true) {
        int read = inputStream.read (fileReader);
        if (read == -1) {
          break;
        }
        outputStream.write (fileReader, 0, read);
        fileSizeDownloaded += read;
        showProgresDownload (fileSizeDownloaded, fileSize);
      }
      outputStream.flush ();

    } catch (FileNotFoundException e) {
      e.printStackTrace ();
    } catch (IOException e) {
      e.printStackTrace ();
    }

  }

  @Override
  public void showSnackBar () {
    Snackbar snackbar = Snackbar.make (container, "Download successfull at "+root.getAbsolutePath (), Snackbar.LENGTH_INDEFINITE);
    snackbar.setAction ("SHOW", v -> {
      if (snackbar.isShown ()){
        snackbar.dismiss ();
        showImage ();
      }

    });
    // get snackbar view
    View snackbarView = snackbar.getView();
    // change snackbar text color
    int snackbarTextId = android.support.design.R.id.snackbar_text;
    TextView textView = (TextView)snackbarView.findViewById(snackbarTextId);
    textView.setTextColor(getResources().getColor(R.color.white));
    snackbar.setActionTextColor (getResources ().getColor (R.color.white));
    snackbar.show ();
  }

  private void showImage () {
    Log.e ("DetailActivity", "showImage: " + mediaFile.getAbsoluteFile ());
    Log.e ("DetailActivity", "showImage: " + mediaFile.getAbsolutePath ());
    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
    StrictMode.setVmPolicy(builder.build());
    /*Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
    galleryIntent.setType ("image/*");
    startActivity(galleryIntent);*/
    /*startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content:/"+mediaFile.getAbsolutePath ())));*/
    Uri uri =  Uri.fromFile(mediaFile);
    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
    String mime = "*/*";
    MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
    if (mimeTypeMap.hasExtension(
        mimeTypeMap.getFileExtensionFromUrl(uri.toString())))
      mime = mimeTypeMap.getMimeTypeFromExtension(
          mimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    intent.setDataAndType(uri,mime);
    startActivity(intent);
  }

  private void showProgresDownload (long l, long target) {
    Log.e ("DetailActivity", "showProgresDownload: " + target);
    Log.e ("DetailActivity", "showProgresDownload: " + l);

  }

  /* Checks if external storage is available for read and write */
  public boolean isExternalStorageWritable () {
    String state = Environment.getExternalStorageState ();
    if (Environment.MEDIA_MOUNTED.equals (state)) {
      return true;
    }
    return false;
  }

  /* Checks if external storage is available to at least read */
  public boolean isExternalStorageReadable () {
    String state = Environment.getExternalStorageState ();
    if (Environment.MEDIA_MOUNTED.equals (state) ||
        Environment.MEDIA_MOUNTED_READ_ONLY.equals (state)) {
      return true;
    }
    return false;
  }

  @Override
  public void showError (String message) {
    Toast.makeText (this, message, Toast.LENGTH_SHORT).show ();
  }

  private boolean hasStoreagePermmission () {
    return EasyPermissions.hasPermissions (this, AppConst.STORAGE_PERMISSION);
  }

  @Override
  public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    EasyPermissions.onRequestPermissionsResult (requestCode, permissions, grantResults);
  }

  @Override
  protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    Log.e ("DetailActivity", "onActivityResult: " + requestCode);
    if (requestCode == AppConst.STOREAGE_PERMISSION_CODE)downloadTask ();
  }

  @Override
  public void showProggress (boolean isShow) {
    if (isShow){
      progresView.setVisibility (View.VISIBLE);
    }else {
      progresView.setVisibility (View.GONE);
    }
  }

  @Override
  public void onPermissionsGranted (int requestCode, @NonNull List<String> perms) {
    Log.e ("DetailActivity", "onPermissionsGranted: " + requestCode);
    if (requestCode == AppConst.STOREAGE_PERMISSION_CODE)downloadTask ();
  }

  @Override
  public void onPermissionsDenied (int requestCode, @NonNull List<String> perms) {

  }
}
