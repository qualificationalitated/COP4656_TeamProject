package com.cop4656.concerttickets.repo;

import android.content.Context;

import androidx.room.Query;
import androidx.room.Room;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ConcertRepository {
    private static ConcertRepository mConcertRepo;
    private final ConcertDao mConcertDao;

    private final TicketDao mTicketDao;

    public static ConcertRepository getInstance(Context context) {
        if (mConcertRepo == null) {
            mConcertRepo = new ConcertRepository(context);
        }
        return mConcertRepo;
    }

    private ConcertRepository(Context context) {
        ConcertDatabase database = Room.databaseBuilder(context, ConcertDatabase.class, "concert.db")
                .allowMainThreadQueries()
                .build();

        mConcertDao = database.concertDao();
        mTicketDao = database.ticketDao();


        addStarterData();
    }
    private void addStarterData() {

        Concert concert = new Concert("COP4656FINALPRESENTATION", "Jake, Kyla, Houston", "Florida", 50, 20, 20 );
        long concertId  = mConcertDao.addConcert(concert);


        Ticket ticket1 = new Ticket("Jake", "Jake@gmail.com", "548202834", 5, false);
        Ticket ticket2 = new Ticket("kyla", "Kyla@gmail.com", "4280670293", 5, false);
        Ticket ticket3 = new Ticket("Houston", "Houston@gmail.com", "305867245", 5, false);
        ticket1.setConcertId(concertId);
        ticket2.setConcertId(concertId);
        ticket3.setConcertId(concertId);
        mTicketDao.addTicket(ticket1);
        mTicketDao.addTicket(ticket2);
        mTicketDao.addTicket(ticket3);

    }

    public void addConcert(Concert concert) {
        long concertId = mConcertDao.addConcert(concert);
        concert.setId(concertId);
    }

    public Concert getConcert(long concertId) {
        return mConcertDao.getConcert(concertId);
    }


    public List<Concert> getConcerts() {
        return mConcertDao.getConcerts();
    }


    public void addTicket(Ticket ticket) {
        long ticketId = mTicketDao.addTicket(ticket);
        ticket.setId(ticketId);
    }

    public Ticket getTicket(long ticketId) {
        return mTicketDao.getTicket(ticketId);
    }

    public List<Ticket> getTickets() {
        return mTicketDao.getTickets();
    }
}
