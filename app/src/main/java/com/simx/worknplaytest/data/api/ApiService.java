package com.simx.worknplaytest.data.api;

import com.simx.worknplaytest.data.model.ResponsePopular;
import com.simx.worknplaytest.helper.AppConst;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
  @Headers({"Accept: application/json", "Content-type: application/json"})
  @GET(AppConst.POPULAR_URL)
  Observable<ResponsePopular> getPopularMovie(
      @Query(AppConst.API_KEY) String api_key);
}