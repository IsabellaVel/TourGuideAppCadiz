package com.example.isabe.tourguideappcadiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    public static final String PLACE_SELECTION = "place";

    public PlacesFragment() {
        // Required empty public constructor
    }
    final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

    ListView listView;
    TourSite placeItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sites_list, container, false);
        final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

        //Create an arrayList of English tourSites

        tourSites.add(new TourSite(getString(R.string.places1), getString(R.string.places1descr), R.drawable.places1_1));
        tourSites.add(new TourSite(getString(R.string.places2), getString(R.string.places2descr), R.drawable.places2_1));
        tourSites.add(new TourSite(getString(R.string.places3), getString(R.string.places3descr), R.drawable.places3_1));
        tourSites.add(new TourSite(getString(R.string.places4), getString(R.string.places4descr), R.drawable.places4_1));
        tourSites.add(new TourSite(getString(R.string.places5), getString(R.string.places5descr), R.drawable.places5_1));
        tourSites.add(new TourSite(getString(R.string.places6), getString(R.string.places6descr), R.drawable.places6_1));
        tourSites.add(new TourSite(getString(R.string.places7), getString(R.string.places7descr), R.drawable.places7_1));
        tourSites.add(new TourSite(getString(R.string.places8), getString(R.string.places8descr), R.drawable.places8_1));
        tourSites.add(new TourSite(getString(R.string.places9), getString(R.string.places9descr), R.drawable.places9_1));

        TourSitesAdapter adapter = new TourSitesAdapter(getActivity(), tourSites, R.color.category_places);

        listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        setOnArrayListClickListener();

        return rootView;
    }

        public  void setOnArrayListClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < tourSites.size(); i++) {
                    TourSite placeItem = (TourSite) listView.getItemAtPosition(position);

                    Intent detailsIntent = new Intent(getActivity(), PlacesDetailActivity.class);
                    detailsIntent.putExtra(PLACE_SELECTION, placeItem);
                    startActivity(detailsIntent);
                }
            }
        });
    }

}