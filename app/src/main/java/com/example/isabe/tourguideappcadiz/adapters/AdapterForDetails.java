package com.example.isabe.tourguideappcadiz.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isabe.tourguideappcadiz.R;
import com.example.isabe.tourguideappcadiz.TourSite;
import com.example.isabe.tourguideappcadiz.TourSitesAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class AdapterForDetails extends ArrayAdapter<TourSite> {

    private static final String SITE = TourSitesAdapter.class.getSimpleName();
    private int mColorResourceId;
    private String mDetailedInfo;

    @BindView(R.id.tv_detailed_info)
    TextView mInfoTextView;

    public AdapterForDetails(Activity context, ArrayList<TourSite> tourSites, String detailedInfo) {
        super(context, 0, tourSites);
        mDetailedInfo = detailedInfo;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_places_detail, parent, false);
        }

        TourSite currentTourSite = getItem(position);
        TextView tvText = (TextView) listItemView.findViewById(R.id.tv_text);
        tvText.setText(currentTourSite.gettText());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        iconView.setImageResource(currentTourSite.getImageResourceID());

        mInfoTextView.setText(currentTourSite.getmDetailedInfo());

        return listItemView;
    }
}
