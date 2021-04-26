package com.example.android.quakereport;

import androidx.core.content.ContextCompat;

public class Quake {


    private String mLocation,mURL;
    private Long mTimeInMilliseconds;
    private Double mMagnitude;


    public Quake(Double mMagnitude, String mLocation, Long mTimeInMilliseconds,String mURL) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds=mTimeInMilliseconds;
        this.mURL=mURL;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }


    public String getmURL() {
        return mURL;
    }
}
