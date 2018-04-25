package com.simx.worknplaytest.ui.main.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.simx.worknplaytest.R;
import com.simx.worknplaytest.data.model.ResultsItem;
import com.simx.worknplaytest.di.module.GlideApp;
import com.simx.worknplaytest.helper.AppConst;
import com.simx.worknplaytest.ui.main.list.AdapterMoviePopular.Holder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdapterMoviePopular extends Adapter<Holder> {

  List<ResultsItem> resultsItems;
  FragmentPopularPresenter presenter;
  Context mContext;


  public AdapterMoviePopular (Context context,
      FragmentPopularPresenter presenter) {
    this.mContext = context;
    this.resultsItems = new ArrayList<> ();
    this.presenter = presenter;
  }

  @Override
  public Holder onCreateViewHolder (ViewGroup parent, int viewType) {
    View view = LayoutInflater.from (mContext).inflate (R.layout.item_movie, null);
    return new Holder (view);
  }

  @Override
  public void onBindViewHolder (Holder holder, int position) {
    ResultsItem resultsItem = getResultItem (position);
    holder.tvTitle.setText (resultsItem.getTitle ());
    holder.tvRating.setText (""+resultsItem.getVoteAverage ());
    String posterPath = AppConst.PATH_IMAGE+ resultsItem.getPosterPath ();
    GlideApp.with (mContext).load (posterPath).placeholder (R.mipmap.ic_launcher).into (holder.img);
    holder.itemView.setOnClickListener (v -> presenter.showDetailMovie(posterPath));
  }

  @Override
  public int getItemCount () {
    return resultsItems.size ();
  }

  private ResultsItem getResultItem(int pos){
    return resultsItems.get (pos);
  }

  public void updateAdapter(List<ResultsItem> resultsItemList){
    resultsItems = resultsItemList;
    notifyDataSetChanged ();
  }
  public void sortAsc (boolean asc){
    if (asc){
    if (resultsItems!=null){
      Collections.sort (resultsItems,
          (o1, o2) -> Double.toString (o1.getVoteAverage ()).compareTo (Double.toString (o2.getVoteAverage ())));
    }
    }else {
      if (resultsItems!=null){
        Collections.sort (resultsItems,
            (o1, o2) -> Double.toString (o2.getVoteAverage ()).compareTo (Double.toString (o1.getVoteAverage ())));
      }
    }
    notifyDataSetChanged ();
  }


  public class Holder extends ViewHolder {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    public Holder (View itemView) {
      super (itemView);
      ButterKnife.bind (this, itemView);
    }
  }
}
