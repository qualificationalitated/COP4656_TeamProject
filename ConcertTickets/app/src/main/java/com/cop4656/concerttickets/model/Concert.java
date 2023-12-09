package com.cop4656.concerttickets.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Concert {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name = "artists")
    private String mArtists;

    @NonNull
    @ColumnInfo(name = "location")
    private String mLocation;

    @NonNull
    @ColumnInfo(name = "ticketCost")
    private int mTicketCost;

    @NonNull
    @ColumnInfo(name = "maxSeats")
    private int mMaxSeats;

    @NonNull
    @ColumnInfo(name = "availableSeats")
    private int mAvailableSeats;

    public Concert(@NonNull String title, @NonNull String artists, @NonNull String location,
                   @NonNull int ticketCost, @NonNull int maxSeats, @NonNull int availableSeats) {
        mTitle = title;
        mArtists = artists;
        mLocation = location;
        mTicketCost = ticketCost;
        mMaxSeats = maxSeats;
        mAvailableSeats = availableSeats;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getArtists() {
        return mArtists;
    }

    public void setArtists(String artists) {
        mArtists=artists;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public int getTicketCost() {
        return mTicketCost;
    }

    public void setTicketCost(int ticketCost) {
        mTicketCost = ticketCost;
    }

    public int getMaxSeats() {
        return mMaxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        mMaxSeats = maxSeats;
    }

    public int getAvailableSeats() {
        return mAvailableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        mAvailableSeats = availableSeats;
    }
}
