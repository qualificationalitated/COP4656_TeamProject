package com.cop4656.concerttickets;

public class Concert {
    private int mId;
    private String mName;
    private String mDescription;
    private String mArtistList;
    private String mLocation;
    private double mCost;
    private int mMaxSeat;
    private int mAvailableSeat;

    public Concert() {}

    public Concert(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
    }
    public Concert(int id, String name, String description,
                   String artist, String Location, double cost,
                   int maxSeat, int availableSeat) {
        mId = id;
        mName = name;
        mDescription = description;
        mArtistList = artist;
        mLocation = Location;
        mCost = cost;
        int mMaxSeat = maxSeat;
        int mAvailableSeat = availableSeat;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}