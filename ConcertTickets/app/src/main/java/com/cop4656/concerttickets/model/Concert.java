package com.cop4656.concerttickets.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

// Declare the Concert class as an entity for Room database
@Entity
public class Concert {

    // Primary key for the Concert entity with auto-generation enabled
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    // Title of the concert
    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    // Artists performing at the concert
    @NonNull
    @ColumnInfo(name = "artists")
    private String mArtists;

    // Location of the concert
    @NonNull
    @ColumnInfo(name = "location")
    private String mLocation;

    // Cost of a concert ticket
    @NonNull
    @ColumnInfo(name = "ticketCost")
    private int mTicketCost;

    // Maximum number of seats available for the concert
    @NonNull
    @ColumnInfo(name = "maxSeats")
    private int mMaxSeats;

    // Number of currently available seats for the concert
    @NonNull
    @ColumnInfo(name = "availableSeats")
    private int mAvailableSeats;

    // Constructor to initialize the Concert object
    public Concert(@NonNull String title, @NonNull String artists, @NonNull String location,
                   @NonNull int ticketCost, @NonNull int maxSeats, @NonNull int availableSeats) {
        mTitle = title;
        mArtists = artists;
        mLocation = location;
        mTicketCost = ticketCost;
        mMaxSeats = maxSeats;
        mAvailableSeats = availableSeats;
    }

    // Getter method for retrieving the concert's ID
    public long getId() {
        return mId;
    }

    // Setter method for setting the concert's ID
    public void setId(long id) {
        mId = id;
    }

    // Getter method for retrieving the concert's title
    public String getTitle() {
        return mTitle;
    }

    // Setter method for setting the concert's title
    public void setTitle(String title) {
        mTitle = title;
    }

    // Getter method for retrieving the artists performing at the concert
    public String getArtists() {
        return mArtists;
    }

    // Setter method for setting the artists performing at the concert
    public void setArtists(String artists) {
        mArtists=artists;
    }

    // Getter method for retrieving the concert's location
    public String getLocation() {
        return mLocation;
    }

    // Setter method for setting the concert's location
    public void setLocation(String location) {
        mLocation = location;
    }

    // Getter method for retrieving the cost of a concert ticket
    public int getTicketCost() {
        return mTicketCost;
    }

    // Setter method for setting the cost of a concert ticket
    public void setTicketCost(int ticketCost) {
        mTicketCost = ticketCost;
    }

    // Getter method for retrieving the maximum number of seats available for the concert
    public int getMaxSeats() {
        return mMaxSeats;
    }

    // Setter method for setting the maximum number of seats available for the concert
    public void setMaxSeats(int maxSeats) {
        mMaxSeats = maxSeats;
    }

    // Getter method for retrieving the number of currently available seats for the concert
    public int getAvailableSeats() {
        return mAvailableSeats;
    }

    // Setter method for setting the number of currently available seats for the concert
    public void setAvailableSeats(int availableSeats) {
        mAvailableSeats = availableSeats;
    }
}
