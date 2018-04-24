package com.simx.worknplaytest.ui.main.list;

import android.content.Context;
import com.simx.worknplaytest.helper.ObservableHelper;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentPopularModule {
  @Provides
  FragmentPopularPresenter provideFragmentPopularPresenter(FragmentPopularMovie fragmentPopularMovie){
    return fragmentPopularMovie;
  }
  @Provides
  AdapterMoviePopular provideAdapterMoviePopular(FragmentPopularPresenter presenter, Context context){
    return new AdapterMoviePopular (context,presenter);
  }
  @Provides
  FragmentPopularPresenterImpl provideFragmentPopularPresenterImpl(FragmentPopularPresenter presenter, ObservableHelper helper){
    return new FragmentPopularPresenterImpl (presenter,helper);
  }
}
