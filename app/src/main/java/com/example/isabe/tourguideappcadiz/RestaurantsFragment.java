package com.example.isabe.tourguideappcadiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sites_list, container, false);
        final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

        tourSites.add(new TourSite(getString(R.string.rest1), getString(R.string.rest1addr)));
        tourSites.add(new TourSite(getString(R.string.rest2), getString(R.string.rest2addr)));
        tourSites.add(new TourSite(getString(R.string.rest3), getString(R.string.rest3addr)));
        tourSites.add(new TourSite(getString(R.string.rest4), getString(R.string.rest4addr)));
        tourSites.add(new TourSite(getString(R.string.rest5), getString(R.string.rest5addr)));
        tourSites.add(new TourSite(getString(R.string.rest6), getString(R.string.rest6addr)));
        tourSites.add(new TourSite(getString(R.string.rest7), getString(R.string.rest7addr)));
        tourSites.add(new TourSite(getString(R.string.rest8), getString(R.string.rest9addr)));

        TourSitesAdapter2 adapter1 = new TourSitesAdapter2(getActivity(), tourSites, R.color.category_restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter1);

        return rootView;
    }

}




