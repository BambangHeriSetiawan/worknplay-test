package com.simx.worknplaytest.helper;

import com.simx.worknplaytest.data.api.ApiService;
import com.simx.worknplaytest.data.model.ResponsePopular;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ObservableHelper {
  Retrofit retrofit;
  public ObservableHelper (Retrofit retrofit) {
    this.retrofit = retrofit;
  }
  public Observable<ResponsePopular> getPopularMovie(String sortBy){
    return retrofit.create (ApiService.class).getPopularMovie (AppConst.MOVIE_DB_KEY,sortBy)
        .subscribeOn (Schedulers.newThread ())
        .observeOn (AndroidSchedulers.mainThread ());
  }
  public Observable<ResponseBody> donloadImage(String url){
    return retrofit.create (ApiService.class).downloadImage (url)
        .subscribeOn (Schedulers.newThread ())
        .observeOn (AndroidSchedulers.mainThread ());
  }

}
