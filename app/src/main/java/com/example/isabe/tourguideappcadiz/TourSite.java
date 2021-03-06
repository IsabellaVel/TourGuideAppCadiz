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
    private String mDetailedInfo;

    public TourSite(String siteDescription, String backgroundDetails, int imageResourceID, String detailedInfo) {
        tText = siteDescription;
        tDescription = backgroundDetails;
        mImageResourceID = imageResourceID;
        mDetailedInfo = detailedInfo;
    }

    public TourSite(String siteDescription, String backgroundDetails) {
        tText = siteDescription;
        tDescription = backgroundDetails;
    }

    protected TourSite(Parcel in) {
        tText = in.readString();
        tDescription = in.readString();
        mImageResourceID = in.readInt();
        mDetailedInfo = in.readString();
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
    public String getmDetailedInfo(){ return mDetailedInfo;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tText);
        dest.writeString(tDescription);
        dest.writeInt(mImageResourceID);
        dest.writeString(mDetailedInfo);
    }
}
