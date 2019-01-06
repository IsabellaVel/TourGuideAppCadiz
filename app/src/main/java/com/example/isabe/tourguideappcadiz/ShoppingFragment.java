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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sites_list, container, false);

        //Create an arrayList of English tourSites
        final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

        tourSites.add(new TourSite(getString(R.string.shopping1), getString(R.string.shopping1addr)));
        tourSites.add(new TourSite(getString(R.string.shopping2), getString(R.string.shoppin1_1addr) +
                getString(R.string.shopping1_2addr)));
        tourSites.add(new TourSite(getString(R.string.shopping3), getString(R.string.shopping3addr)));
        tourSites.add(new TourSite(getString(R.string.shopping4), getString(R.string.shopping4addr)));
        tourSites.add(new TourSite(getString(R.string.shopping5), getString(R.string.shopping5addr)));
        tourSites.add(new TourSite(getString(R.string.shopping6), getString(R.string.shopping6addr)));
        tourSites.add(new TourSite(getString(R.string.shopping7), getString(R.string.shopping7addr)));
        tourSites.add(new TourSite(getString(R.string.shopping8), getString(R.string.shopping8addr)));
        tourSites.add(new TourSite(getString(R.string.shopping9), getString(R.string.shopping9addr)));
        tourSites.add(new TourSite(getString(R.string.shopping10), getString(R.string.shopping10addr)));

        TourSitesAdapter2 adapter1 = new TourSitesAdapter2(getActivity(), tourSites, R.color.category_shopping);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter1);

        return rootView;
    }
}