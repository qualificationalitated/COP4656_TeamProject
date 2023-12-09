package com.cop4656.concerttickets.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Concert.class, parentColumns = "id",
        childColumns = "concert_id", onDelete = CASCADE))
public class Ticket {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @NonNull
    @ColumnInfo(name = "email")
    private String mEmail;

    @NonNull
    @ColumnInfo(name = "phoneNumber")
    private String mPhoneNumber;

    @NonNull
    @ColumnInfo(name = "tickets")
    private int mTickets;

    @NonNull
    @ColumnInfo(name = "disabled")
    private boolean mDisabled;

    @ColumnInfo(name = "concert_id")
    private long mConcertId;


    public Ticket(@NonNull String name, @NonNull String email, @NonNull String phoneNumber,
                  @NonNull int tickets, @NonNull boolean disabled) {
        mName = name;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mTickets = tickets;
        mDisabled = disabled;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }


    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getTickets() {
        return mTickets;
    }

    public void setTickets(int tickets) {
        mTickets = tickets;
    }

    public boolean getDisabled() {
        return mDisabled;
    }

    public void setDisabled(boolean disabled) {
        mDisabled = disabled;
    }

    public long getConcertId() {
        return mConcertId;
    }

    public void setConcertId(long concertId) {
        mConcertId = concertId;
    }

}