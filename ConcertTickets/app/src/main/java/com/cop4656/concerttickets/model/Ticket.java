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
    private String mTickets;

    @NonNull
    @ColumnInfo(name = "disabled")
    private boolean mDisabled;

    @NonNull
    @ColumnInfo(name = "paymentType")
    private String mPaymentType;

    @ColumnInfo(name = "concert_id")
    private long mConcertId;


    public Ticket(@NonNull String name, @NonNull String email, @NonNull String phoneNumber,
                  @NonNull String tickets, @NonNull boolean disabled, @NonNull String paymentType) {
        mName = name;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mTickets = tickets;
        mDisabled = disabled;
        mPaymentType = paymentType;
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

    public String getPaymentType() {
        return mPaymentType;
    }

    public void setPaymentType(String paymentType) {
        mPaymentType = paymentType;
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

    public String getTickets() {
        return mTickets;
    }

    public void setTickets(String tickets) {
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