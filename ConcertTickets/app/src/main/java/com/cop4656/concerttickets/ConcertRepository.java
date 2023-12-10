package com.cop4656.concerttickets;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
public class ConcertRepository {
    private static ConcertRepository instance;
    private List<Concert> mBands;

    public static ConcertRepository getInstance(Context context) {
        if (instance == null) {
            instance = new ConcertRepository(context);
        }
        return instance;
    }

    private ConcertRepository(Context context) {
        mBands = new ArrayList<>();
        Resources res = context.getResources();
        String[] bands = res.getStringArray(R.array.concerts);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        for (int i = 0; i < bands.length; i++) {
            mBands.add(new Concert(i + 1, bands[i], descriptions[i]));
        }
    }

    public List<Concert> getConcerts() {
        return mBands;
    }

    public Concert getConcert(int bandId) {
        for (Concert band : mBands) {
            if (band.getId() == bandId) {
                return band;
            }
        }
        return null;
    }
}
