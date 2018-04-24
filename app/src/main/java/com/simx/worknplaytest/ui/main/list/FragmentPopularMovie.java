package com.simx.worknplaytest.ui.main.list;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.simx.worknplaytest.R;
import com.simx.worknplaytest.data.model.ResultsItem;
import com.simx.worknplaytest.di.base.BaseFragment;
import com.simx.worknplaytest.helper.AppConst;
import com.simx.worknplaytest.ui.main.MainPresenter;
import com.simx.worknplaytest.ui.main.detail.DetailActivity;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPopularMovie extends BaseFragment implements FragmentPopularPresenter,MainPresenter {


  @BindView(R.id.rcv_movie)
  RecyclerView rcvMovie;
  Unbinder unbinder;
  @BindView(R.id.my_toolbar)
  Toolbar myToolbar;


  public FragmentPopularMovie () {
  }

  @Inject
  FragmentPopularPresenterImpl popularPresenter;
  @Inject
  AdapterMoviePopular adapterMoviePopular;

  public static FragmentPopularMovie newInstance () {
    Bundle args = new Bundle ();
    FragmentPopularMovie fragment = new FragmentPopularMovie ();
    fragment.setArguments (args);
    return fragment;
  }

  @Override
  public void onCreate (@Nullable Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setRetainInstance (true);
  }

  @Override
  public View onCreateView (LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate (R.layout.fragment_fragment_popular_movie, container, false);
    unbinder = ButterKnife.bind (this, view);
    AppCompatActivity activity = (AppCompatActivity) getActivity ();
    activity.setSupportActionBar (myToolbar);
    activity.getSupportActionBar ().setTitle ("WorknPlay Test");
    myToolbar.inflateMenu (R.menu.main);
    popularPresenter.getMovieList (AppConst.SORT_DESC);
    return view;
  }


  @Override
  public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated (view, savedInstanceState);
    initRcv ();
    setHasOptionsMenu (true);
  }

  private void initRcv () {
    rcvMovie.setHasFixedSize (true);
    rcvMovie.setLayoutManager (new GridLayoutManager (getActivity (), 2,GridLayoutManager.VERTICAL,false));
    rcvMovie.setItemAnimator (new DefaultItemAnimator ());
    rcvMovie.setAdapter (adapterMoviePopular);
  }

  @Override
  public void showDetailMovie (String posterPath) {
    DetailActivity.start (getContext (),posterPath);
  }

  @Override
  public void initDataMovie (List<ResultsItem> results) {
    results.stream ().min (Comparator.comparing (ResultsItem::getVoteAverage));
    adapterMoviePopular.updateAdapter (results);
  }

  @Override
  public void showError (String message) {
    Toast.makeText (getContext (), message, Toast.LENGTH_SHORT).show ();
  }

  @Override
  public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu (menu, inflater);
    menu.clear ();
    inflater.inflate (R.menu.main, menu);
  }

  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    switch (item.getItemId ()) {
      case R.id.nav_sort:
        adapterMoviePopular.sortAsc (true);
        break;
      case R.id.nav_sort1:
        adapterMoviePopular.sortAsc (false);
        break;
    }
    return super.onOptionsItemSelected (item);
  }

  @Override
  public void onDestroyView () {
    super.onDestroyView ();
    unbinder.unbind ();
  }
}
