package com.example.android.quakereport;

public class Quake {


    private String  mMagnitude,mLocation;
    private Long mTimeInMilliseconds;



    public Quake(String mMagnitude, String mLocation, Long mTimeInMilliseconds) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds=mTimeInMilliseconds;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

}
