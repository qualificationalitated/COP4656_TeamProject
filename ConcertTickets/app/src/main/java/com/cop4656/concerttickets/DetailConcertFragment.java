package com.cop4656.concerttickets;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.repo.ConcertRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailConcertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailConcertFragment extends Fragment {

    public static final String ARG_CONCERT_ID = "concert_id";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Concert mConcert;

    public DetailConcertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailConcertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailConcertFragment newInstance(String param1, String param2) {
        DetailConcertFragment fragment = new DetailConcertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int concertID = 1;
        // Get the band ID from the fragment arguments
        Bundle args = getArguments();
        if (args != null) {
            concertID = args.getInt(ARG_CONCERT_ID);
        }

        mConcert = ConcertRepository.getInstance(requireContext()).getConcert(concertID);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail_concert, container, false);
        if (mConcert != null) {
            // name
            TextView nameTextView = rootView.findViewById(R.id.concert_name);
            nameTextView.setText(mConcert.getTitle());

            // artist
            TextView artistTextView = rootView.findViewById(R.id.concert_artist);
            artistTextView.setText(mConcert.getArtists());

            // location
            TextView locationTextView = rootView.findViewById(R.id.concert_location);
            locationTextView.setText(mConcert.getLocation());

            // cost
            TextView costTextView = rootView.findViewById(R.id.concert_cost);
            costTextView.setText((int) mConcert.getTicketCost());

            Button registerButton = rootView.findViewById(R.id.button_register);
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(requireContext(), TicketRegister.class);
                    startActivity(intent);
                }
            });
        }
        return rootView;
    }
}