package com.example.isabe.tourguideappcadiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabe.tourguideappcadiz.adapters.AdapterForDetails;
import com.example.isabe.tourguideappcadiz.categories.PlacesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by isabe on 1/5/2019.
 */

public class PlaceDetailFragment extends Fragment {
    private static final String LOG_TAG = PlaceDetailFragment.class.getSimpleName();
    private AdapterForDetails mAdapterForPlaceInfo;
    public TourSite mTourSite;

    @BindView(R.id.place_image)
    ImageView mPlaceImage;
    @BindView(R.id.place_title)
    TextView mPlaceName;
    @BindView(R.id.tv_detailed_info)
    TextView mPlaceInfo;

    private String mTitle;
    private String mInfo;
    private int mImage;
    private Unbinder unbinder;
    private Context context = null;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mTourSite = args.getParcelable(PlacesFragment.PLACE_SELECTION);
            assert mTourSite != null;
            mTitle = mTourSite.gettText();
            mInfo = mTourSite.getmDetailedInfo();
            mImage = mTourSite.getImageResourceID();
        }

        Activity activity = this.getActivity();

        CollapsingToolbarLayout collapsingToolbarLayout = activity.findViewById(R.id.collapsing_toolbar_layout);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitleEnabled(false);
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_places_detail, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        setUpDetailsForPlace();

        if (savedInstanceState != null){
            final CollapsingToolbarLayout collapsingToolbarLayout = getActivity().findViewById(R.id.collapsing_toolbar_layout);

            collapsingToolbarLayout.post(new Runnable() {
                @Override
                public void run() {
                    collapsingToolbarLayout.setTitleEnabled(false);
                    Log.i(LOG_TAG, "Restored title is " + savedInstanceState.getString("title"));
                }
            });

        }
        return rootView;
    }

    public void setUpDetailsForPlace() {
        mPlaceName.setText(mTitle);
        mPlaceImage.setImageResource(mImage);
        mPlaceInfo.setText(mInfo);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        mTitle = mTourSite.gettText();
        savedInstanceState.putString("title", mTitle);
        Log.i(LOG_TAG, "Saves title is " + mTitle);
        }


}




