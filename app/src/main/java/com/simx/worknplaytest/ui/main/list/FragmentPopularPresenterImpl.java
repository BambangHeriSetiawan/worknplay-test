package com.simx.worknplaytest.ui.main.list;

import android.util.Log;
import com.simx.worknplaytest.helper.ObservableHelper;

public class FragmentPopularPresenterImpl {
  FragmentPopularPresenter presenter;
  ObservableHelper helper;

  public FragmentPopularPresenterImpl (
      FragmentPopularPresenter presenter, ObservableHelper helper) {
    this.presenter = presenter;
    this.helper = helper;
  }

  public void getMovieList (String sortBy) {
    presenter.showProgress(true);
    helper.getPopularMovie (sortBy).subscribe (responsePopular -> {
      if (responsePopular.getResults ()!=null)presenter.initDataMovie(responsePopular.getResults ());
    },throwable -> {
      presenter.showProgress (false);
      presenter.showError(throwable.getMessage ());
    },() -> {
      presenter.showProgress (false);
    });
  }
}
