package com.simx.worknplaytest.data.api;

import com.simx.worknplaytest.data.model.ResponsePopular;
import com.simx.worknplaytest.helper.AppConst;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {
  @Headers({"Accept: application/json", "Content-type: application/json"})
  @GET(AppConst.POPULAR_URL)
  Observable<ResponsePopular> getPopularMovie(
      @Query(AppConst.API_KEY) String api_key,
      @Query("sort_by") String sort_by);

  @Headers({"Accept: application/json", "Content-type: application/json"})
  @Streaming
  @GET()
  Observable<ResponseBody> downloadImage(@Url String fileUrl);
}
