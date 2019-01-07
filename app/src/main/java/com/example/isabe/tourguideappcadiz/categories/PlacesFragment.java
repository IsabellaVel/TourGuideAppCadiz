package com.example.isabe.tourguideappcadiz.categories;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.isabe.tourguideappcadiz.PlacesDetailActivity;
import com.example.isabe.tourguideappcadiz.R;
import com.example.isabe.tourguideappcadiz.TourSite;
import com.example.isabe.tourguideappcadiz.TourSitesAdapter;
import com.example.isabe.tourguideappcadiz.adapters.AdapterForDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    public static final String PLACE_SELECTION = "place";
    private AdapterForDetails mAdapter;

    public PlacesFragment() {
        // Required empty public constructor
    }
    final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

    ListView listView;
    TourSite placeItem;
    private List<TourSite> tourSiteList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sites_list, container, false);
        final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

        //Create an arrayList of English tourSites

        tourSites.add(new TourSite(getString(R.string.places1), getString(R.string.places1descr), R.drawable.places1_1, getString(R.string.torre_tavira_info)));
        tourSites.add(new TourSite(getString(R.string.places2), getString(R.string.places2descr), R.drawable.places2_1, getString(R.string.caleta_info)));
        tourSites.add(new TourSite(getString(R.string.places3), getString(R.string.places3descr), R.drawable.places3_1, getString(R.string.parque_info)));
        tourSites.add(new TourSite(getString(R.string.places4), getString(R.string.places4descr), R.drawable.places4_1, getString(R.string.mercado_info)));
        tourSites.add(new TourSite(getString(R.string.places5), getString(R.string.places5descr), R.drawable.places5_1, getString(R.string.catedral_info)));
        tourSites.add(new TourSite(getString(R.string.places6), getString(R.string.places6descr), R.drawable.places6_1, getString(R.string.plaza_info)));
        tourSites.add(new TourSite(getString(R.string.places7), getString(R.string.places7descr), R.drawable.places7_1, getString(R.string.alameda_info)));
        tourSites.add(new TourSite(getString(R.string.places8), getString(R.string.places8descr), R.drawable.places8_1, getString(R.string.paseo_info)));
        tourSites.add(new TourSite(getString(R.string.places9), getString(R.string.places9descr), R.drawable.places9_1, getString(R.string.espana_info)));

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
                    TourSite placeItem = (TourSite) listView.getItemAtPosition(position);

                    Intent detailsIntent = new Intent(getActivity(), PlacesDetailActivity.class);
                    detailsIntent.putExtra(PLACE_SELECTION, placeItem);
                    startActivity(detailsIntent);

            }
        });
    }

}