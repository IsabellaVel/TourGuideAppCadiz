package com.example.isabe.tourguideappcadiz;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WWW on 07/05/2017.
 */

public class TourSitesAdapter extends ArrayAdapter<TourSite> {

    private static final String SITE = TourSitesAdapter.class.getSimpleName();
    private int mColorResourceId;

    public TourSitesAdapter(Activity context, ArrayList<TourSite> tourSites, int colorResourceId) {
        super(context, 0, tourSites);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TourSite currentTourSite = getItem(position);
        TextView tvText = (TextView) listItemView.findViewById(R.id.tv_text);
        tvText.setText(currentTourSite.gettText());

        TextView tvDescr = (TextView) listItemView.findViewById(R.id.tv_description);
        tvDescr.setText(currentTourSite.gettDescription());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        iconView.setImageResource(currentTourSite.getImageResourceID());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

