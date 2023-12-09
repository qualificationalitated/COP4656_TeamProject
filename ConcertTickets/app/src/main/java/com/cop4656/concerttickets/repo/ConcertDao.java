package com.cop4656.concerttickets.repo;

import androidx.room.*;

import com.cop4656.concerttickets.model.Concert;

import java.util.List;

@Dao
public interface ConcertDao {
    @Query("SELECT * FROM Concert WHERE id = :id")
    Concert getConcert(long id);


    @Query("SELECT * FROM Concert ORDER BY title COLLATE NOCASE")
    List<Concert> getConcerts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addConcert(Concert concert);
}
