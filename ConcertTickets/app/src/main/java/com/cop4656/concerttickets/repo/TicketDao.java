package com.cop4656.concerttickets.repo;

import androidx.room.*;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.model.Ticket;
import java.util.List;
import androidx.lifecycle.LiveData;

@Dao
public interface TicketDao {

    @Query("SELECT * FROM Ticket WHERE id = :id")
    Ticket getTicket(long id);


    @Query("SELECT * FROM Ticket ORDER BY name COLLATE NOCASE")
    List<Ticket> getTickets();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addTicket(Ticket ticket);
}
