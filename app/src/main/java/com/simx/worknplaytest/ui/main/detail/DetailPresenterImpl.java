package com.simx.worknplaytest.ui.main.detail;

import android.util.Log;
import com.simx.worknplaytest.helper.ObservableHelper;
import io.reactivex.Observable;
import io.reactivex.Observer;
import java.io.File;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import org.reactivestreams.Subscriber;
import retrofit2.Response;

public class DetailPresenterImpl {
  DetailPresenter presenter;
  ObservableHelper helper;

  public DetailPresenterImpl (DetailPresenter presenter,
      ObservableHelper helper) {
    this.presenter = presenter;
    this.helper = helper;
  }

  public void downloadImage (String pathImage) {
    helper.donloadImage (pathImage).subscribe (responseBody -> {
      presenter.saveToDisk(responseBody);
      Log.e ("DetailPresenterImpl", "downloadImage: " + responseBody.string ());
    },throwable -> {
      Log.e ("DetailPresenterImpl", "downloadImage: " + throwable.getMessage ());
    });
  }




}
