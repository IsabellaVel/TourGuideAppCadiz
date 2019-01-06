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
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sites_list, container, false);

        //Create an arrayList of English tourSites
        final ArrayList<TourSite> tourSites = new ArrayList<TourSite>();

        tourSites.add(new TourSite(getString(R.string.event1), getString(R.string.evennt1date)));
        tourSites.add(new TourSite(getString(R.string.event2), getString(R.string.event2date)));
        tourSites.add(new TourSite(getString(R.string.event3), getString(R.string.event3date)));
        tourSites.add(new TourSite(getString(R.string.event4), getString(R.string.event4date)));
        tourSites.add(new TourSite(getString(R.string.event5), getString(R.string.event5date)));
        tourSites.add(new TourSite(getString(R.string.event6), getString(R.string.event6date)));
        tourSites.add(new TourSite(getString(R.string.event7), getString(R.string.event7date)));
        tourSites.add(new TourSite(getString(R.string.event8_1), getString(R.string.event8date)));
        tourSites.add(new TourSite(getString(R.string.event9), getString(R.string.event9date)));

        TourSitesAdapter2 adapter1 = new TourSitesAdapter2(getActivity(), tourSites, R.color.category_events);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter1);

        return rootView;
    }
}


