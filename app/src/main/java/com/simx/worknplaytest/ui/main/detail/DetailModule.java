package com.simx.worknplaytest.ui.main.detail;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
  @Provides
  DetailPresenter provideDetailPresenter(DetailActivity fragmentDetailMovie){
    return fragmentDetailMovie;
  }

  @Provides
  DetailPresenterImpl provideFragmentPopularPresenterImpl(DetailPresenter presenter){
    return new DetailPresenterImpl (presenter);
  }
}
