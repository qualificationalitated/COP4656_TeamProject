package com.cop4656.concerttickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cop4656.concerttickets.repo.ConcertRepository;

public class MainActivity extends AppCompatActivity {

    private ConcertRepository concertRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        concertRepo = ConcertRepository.getInstance(getApplicationContext());
    }
}