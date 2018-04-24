package com.simx.worknplaytest.ui.main.list;

import com.simx.worknplaytest.data.model.ResultsItem;
import java.util.List;

public interface FragmentPopularPresenter {

  void showDetailMovie (String posterPath);

  void initDataMovie (List<ResultsItem> results);

  void showError (String message);
}
