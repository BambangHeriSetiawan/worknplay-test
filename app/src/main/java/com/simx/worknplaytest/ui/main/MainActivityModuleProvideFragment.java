package com.simx.worknplaytest.ui.main;

import com.simx.worknplaytest.ui.main.detail.DetailModule;
import com.simx.worknplaytest.ui.main.list.FragmentPopularModule;
import com.simx.worknplaytest.ui.main.list.FragmentPopularMovie;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModuleProvideFragment {
  @ContributesAndroidInjector(modules = FragmentPopularModule.class)
  abstract FragmentPopularMovie fragmentPopularMovie();
}
