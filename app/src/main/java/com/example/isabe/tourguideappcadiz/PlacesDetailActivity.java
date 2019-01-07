package com.example.isabe.tourguideappcadiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

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

  @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        android.support.v7.widget.Toolbar mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null){
          actionBar.setDisplayHomeAsUpEnabled(true);
      }

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
