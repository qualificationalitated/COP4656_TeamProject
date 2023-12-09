package com.cop4656.concerttickets.repo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;

@Database(entities = {Ticket.class, Concert.class}, version = 1)
public abstract class ConcertDatabase extends RoomDatabase {
    public abstract ConcertDao concertDao();
    public abstract TicketDao ticketDao();
}
