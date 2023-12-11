package com.cop4656.concerttickets.repo;

import androidx.room.*;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;
import java.util.List;
import androidx.lifecycle.LiveData;

// Declare the TicketDao interface as a Data Access Object (DAO) for Room database
@Dao
public interface TicketDao {

    // Query to retrieve a ticket by its ID
    @Query("SELECT * FROM Ticket WHERE id = :id")
    Ticket getTicket(long id);

    // Query to retrieve all tickets, ordered by name (case-insensitive)
    @Query("SELECT * FROM Ticket ORDER BY name COLLATE NOCASE")
    List<Ticket> getTickets();

    // Insert or update a ticket in the database, replacing it if it already exists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addTicket(Ticket ticket);
}