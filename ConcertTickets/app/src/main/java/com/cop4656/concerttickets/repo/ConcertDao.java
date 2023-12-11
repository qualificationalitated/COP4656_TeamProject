package com.cop4656.concerttickets.repo;

import androidx.room.*;

import com.cop4656.concerttickets.model.Concert;

import java.util.List;

// Declare the ConcertDao interface as a Data Access Object (DAO) for Room database
@Dao
public interface ConcertDao {

    // Query to retrieve a concert by its ID
    @Query("SELECT * FROM Concert WHERE id = :id")
    Concert getConcert(long id);

    // Query to retrieve a concert by its title
    @Query("SELECT * FROM Concert WHERE title = :title")
    Concert getFromTitle(String title);

    // Query to retrieve all concerts, ordered by title (case-insensitive)
    @Query("SELECT * FROM Concert ORDER BY title COLLATE NOCASE")
    List<Concert> getConcerts();

    // Insert or update a concert in the database, replacing it if it already exists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addConcert(Concert concert);
}