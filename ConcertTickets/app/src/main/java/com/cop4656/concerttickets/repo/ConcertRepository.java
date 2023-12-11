package com.cop4656.concerttickets.repo;

import android.content.Context;

import androidx.room.Query;
import androidx.room.Room;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;

import java.util.ArrayList;
import java.util.List;

// Repository class for managing interactions with the Room database
public class ConcertRepository {

    // Singleton instance of ConcertRepository
    private static ConcertRepository mConcertRepo;

    // DAOs for interacting with the Room database
    private final ConcertDao mConcertDao;
    private final TicketDao mTicketDao;

    // Method to obtain the singleton instance of ConcertRepository
    public static ConcertRepository getInstance(Context context) {
        if (mConcertRepo == null) {
            mConcertRepo = new ConcertRepository(context);
        }
        return mConcertRepo;
    }

    // Private constructor to create the ConcertRepository instance
    private ConcertRepository(Context context) {

        // Build the Room database instance
        ConcertDatabase database = Room.databaseBuilder(context, ConcertDatabase.class, "concert.db")
                .allowMainThreadQueries() // Note: This should be avoided for production code
                .build();

        // Initialize the DAOs
        mConcertDao = database.concertDao();
        mTicketDao = database.ticketDao();

        // Add starter data if the concerts table is empty
        if(mConcertDao.getConcerts().isEmpty()){
            addStarterData();
        }
    }

    // Method to add starter data to the database
    private void addStarterData() {

        // Create a concert
        Concert concert = new Concert("COP4656FINALPRESENTATION", "Jake, Kyla, Houston", "Florida", 50, 20, 20 );

        // Add the concert to the database and obtain its ID
        long concertId  = mConcertDao.addConcert(concert);

        // Create tickets associated with the concert
        Ticket ticket1 = new Ticket("Jake", "Jake@gmail.com", "548202834", "5", false, "Mobile");
        Ticket ticket2 = new Ticket("kyla", "Kyla@gmail.com", "4280670293", "5", false, "Mobile");
        Ticket ticket3 = new Ticket("Houston", "Houston@gmail.com", "305867245", "5", false, "Mobile");

        // Set the concert ID for each ticket
        ticket1.setConcertId(concertId);
        ticket2.setConcertId(concertId);
        ticket3.setConcertId(concertId);

        // Add tickets to the database
        mTicketDao.addTicket(ticket1);
        mTicketDao.addTicket(ticket2);
        mTicketDao.addTicket(ticket3);
    }

    // Method to add a concert to the database
    public void addConcert(Concert concert) {
        long concertId = mConcertDao.addConcert(concert);
        concert.setId(concertId);
    }

    // Method to retrieve a concert by its ID
    public Concert getConcert(long concertId) {
        return mConcertDao.getConcert(concertId);
    }

    // Method to retrieve all concerts from the database
    public List<Concert> getConcerts() {
        return mConcertDao.getConcerts();
    }

    // Method to add a ticket to the database
    public void addTicket(Ticket ticket) {
        long ticketId = mTicketDao.addTicket(ticket);
        ticket.setId(ticketId);
    }

    // Method to retrieve a ticket by its ID
    public Ticket getTicket(long ticketId) {
        return mTicketDao.getTicket(ticketId);
    }

    // Method to retrieve all tickets from the database
    public List<Ticket> getTickets() {
        return mTicketDao.getTickets();
    }

    // Method to retrieve a concert by its title
    public Concert getFromTitle(String title) {
        return mConcertDao.getFromTitle(title);
    }
}