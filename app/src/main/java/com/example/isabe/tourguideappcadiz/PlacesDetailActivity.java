package com.example.isabe.tourguideappcadiz;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.example.isabe.tourguideappcadiz.categories.PlacesFragment;

/**
 * Created by isabe on 1/5/2019.
 */

public class PlacesDetailActivity extends AppCompatActivity {
    private TourSite mPlacePOJO;
    Context context;

    public void sendPlace(Context context, Parcelable placeObject){
      context = getBaseContext();
      Bundle bundle = new Bundle();
      bundle.putParcelable(PlacesFragment.PLACE_SELECTION, mPlacePOJO);
      PlaceDetailFragment placeInfoFragment = new PlaceDetailFragment();
      placeInfoFragment.setArguments(bundle);

      getSupportFragmentManager().beginTransaction()
              .add(R.id.frame_place_detail, placeInfoFragment)
              .commit();
  }

  @RequiresApi(api = Build.VERSION_CODES.M)
  @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        android.support.v7.widget.Toolbar mToolBar = findViewById(R.id.toolbar_details);
        setSupportActionBar(mToolBar);

      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null){
          actionBar.setDisplayHomeAsUpEnabled(true);
          mPlacePOJO = getIntent().getParcelableExtra(PlacesFragment.PLACE_SELECTION);
          actionBar.setTitle(mPlacePOJO.gettText());
          }

     /** FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_place_detail);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
              FrameLayout.LayoutParams.MATCH_PARENT,
              FrameLayout.LayoutParams.MATCH_PARENT);
      frameLayout.setBackgroundColor(getColor(R.color.detail_bckgr));
     **/
      if (savedInstanceState != null){
          mPlacePOJO = savedInstanceState.getParcelable(PlacesFragment.PLACE_SELECTION);
          }
          else {
          mPlacePOJO = getIntent().getParcelableExtra(PlacesFragment.PLACE_SELECTION);
          String placeDescription = mPlacePOJO.gettDescription();
          String placeText = mPlacePOJO.gettText();
          int placeImage = mPlacePOJO.getImageResourceID();

          sendPlace(getBaseContext(), mPlacePOJO);
      }
  }
}
