package com.simx.worknplaytest.ui.main.detail;

import com.simx.worknplaytest.helper.ObservableHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
  @Provides
  DetailPresenter provideDetailPresenter(DetailActivity fragmentDetailMovie){
    return fragmentDetailMovie;
  }

  @Provides
  DetailPresenterImpl provideFragmentPopularPresenterImpl(DetailPresenter presenter, ObservableHelper helper){
    return new DetailPresenterImpl (presenter,helper);
  }
}
