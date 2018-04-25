package com.simx.worknplaytest.ui.main.detail;

import okhttp3.ResponseBody;

public interface DetailPresenter {

  void saveToDisk (ResponseBody responseBody);

  void showError (String message);

  void showProggress (boolean isShow);

  void showSnackBar ();

}
