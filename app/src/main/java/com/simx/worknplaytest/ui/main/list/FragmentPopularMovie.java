package com.simx.worknplaytest.ui.main.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simx.worknplaytest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPopularMovie extends Fragment {


  public FragmentPopularMovie () {
    // Required empty public constructor
  }


  @Override
  public View onCreateView (LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate (R.layout.fragment_fragment_popular_movie, container, false);
  }

}
