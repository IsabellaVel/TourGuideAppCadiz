package com.example.isabe.tourguideappcadiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WWW on 07/05/2017.
 */

public class TourSite implements Parcelable{
    private String tText;
    private String tDescription;
    private int mImageResourceID;

    public TourSite(String siteDescription, String backgroundDetails, int imageResourceID) {
        tText = siteDescription;
        tDescription = backgroundDetails;
        mImageResourceID = imageResourceID;
    }

    public TourSite(String siteDescription, String backgroundDetails) {
        tText = siteDescription;
        tDescription = backgroundDetails;
    }

    protected TourSite(Parcel in) {
        tText = in.readString();
        tDescription = in.readString();
        mImageResourceID = in.readInt();
    }

    public static final Creator<TourSite> CREATOR = new Creator<TourSite>() {
        @Override
        public TourSite createFromParcel(Parcel in) {
            return new TourSite(in);
        }

        @Override
        public TourSite[] newArray(int size) {
            return new TourSite[size];
        }
    };

    public String gettText() {
        return tText;
    }

    public String gettDescription() {
        return tDescription;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tText);
        dest.writeString(tDescription);
        dest.writeInt(mImageResourceID);
    }
}
