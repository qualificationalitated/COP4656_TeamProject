package com.cop4656.concerttickets.model;

import static androidx.room.ForeignKey.CASCADE;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

// Declare the Ticket class as an entity for Room database
@Entity(foreignKeys = @ForeignKey(entity = Concert.class, parentColumns = "id",
        childColumns = "concert_id", onDelete = CASCADE))
public class Ticket {

    // Primary key for the Ticket entity with auto-generation enabled
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    // Name of the ticket holder
    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    // Email of the ticket holder
    @NonNull
    @ColumnInfo(name = "email")
    private String mEmail;

    // Phone number of the ticket holder
    @NonNull
    @ColumnInfo(name = "phoneNumber")
    private String mPhoneNumber;

    // Type or details of the tickets
    @NonNull
    @ColumnInfo(name = "tickets")
    private String mTickets;

    // Flag indicating whether the ticket is disabled or not
    @NonNull
    @ColumnInfo(name = "disabled")
    private boolean mDisabled;

    // Payment type used for the ticket purchase
    @NonNull
    @ColumnInfo(name = "paymentType")
    private String mPaymentType;

    // Foreign key referencing the associated concert's ID
    @ColumnInfo(name = "concert_id")
    private long mConcertId;

    // Constructor to initialize the Ticket object
    public Ticket(@NonNull String name, @NonNull String email, @NonNull String phoneNumber,
                  @NonNull String tickets, @NonNull boolean disabled, @NonNull String paymentType) {
        mName = name;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mTickets = tickets;
        mDisabled = disabled;
        mPaymentType = paymentType;
    }

    // Getter method for retrieving the ticket's ID
    public long getId() {
        return mId;
    }

    // Setter method for setting the ticket's ID
    public void setId(long id) {
        mId = id;
    }

    // Getter method for retrieving the ticket holder's name
    public String getName() {
        return mName;
    }

    // Setter method for setting the ticket holder's name
    public void setName(String name) {
        mName = name;
    }

    // Getter method for retrieving the payment type used for the ticket purchase
    public String getPaymentType() {
        return mPaymentType;
    }

    // Setter method for setting the payment type used for the ticket purchase
    public void setPaymentType(String paymentType) {
        mPaymentType = paymentType;
    }

    // Getter method for retrieving the ticket holder's email
    public String getEmail() {
        return mEmail;
    }

    // Setter method for setting the ticket holder's email
    public void setEmail(String email) {
        mEmail = email;
    }

    // Getter method for retrieving the ticket holder's phone number
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    // Setter method for setting the ticket holder's phone number
    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    // Getter method for retrieving the type or details of the tickets
    public String getTickets() {
        return mTickets;
    }

    // Setter method for setting the type or details of the tickets
    public void setTickets(String tickets) {
        mTickets = tickets;
    }

    // Getter method for retrieving whether the ticket is disabled or not
    public boolean getDisabled() {
        return mDisabled;
    }

    // Setter method for setting whether the ticket is disabled or not
    public void setDisabled(boolean disabled) {
        mDisabled = disabled;
    }

    // Getter method for retrieving the associated concert's ID
    public long getConcertId() {
        return mConcertId;
    }

    // Setter method for setting the associated concert's ID
    public void setConcertId(long concertId) {
        mConcertId = concertId;
    }
}
