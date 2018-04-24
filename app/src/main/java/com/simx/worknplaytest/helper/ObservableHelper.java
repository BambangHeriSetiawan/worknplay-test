package com.simx.worknplaytest.helper;

import com.simx.worknplaytest.data.api.ApiService;
import com.simx.worknplaytest.data.model.ResponsePopular;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ObservableHelper {
  Retrofit retrofit;
  public ObservableHelper (Retrofit retrofit) {
    this.retrofit = retrofit;
  }
  public Observable<ResponsePopular> getPopularMovie(){
    return retrofit.create (ApiService.class).getPopularMovie (AppConst.API_KEY)
        .subscribeOn (Schedulers.newThread ())
        .observeOn (AndroidSchedulers.mainThread ());
  }

}
