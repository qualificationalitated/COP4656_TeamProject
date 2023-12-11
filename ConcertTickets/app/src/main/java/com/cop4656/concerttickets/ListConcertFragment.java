package com.cop4656.concerttickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.cop4656.concerttickets.model.Concert;
import com.cop4656.concerttickets.repo.ConcertRepository;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListConcertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListConcertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListConcertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListConcertFragment newInstance(String param1, String param2) {
        ListConcertFragment fragment = new ListConcertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // Method called when the fragment view is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        // OnClickListener to handle item clicks in the RecyclerView
        View.OnClickListener onClickListener = itemView -> {
            // Create fragment arguments containing the selected concert ID
            int selectedConcertId = (int) itemView.getTag();
            Bundle args = new Bundle();
            args.putInt(DetailConcertFragment.ARG_CONCERT_ID, selectedConcertId);

            // Replace list with details using NavController
            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        // Get the RecyclerView from the layout
        RecyclerView recyclerView = rootView.findViewById(R.id.concert_list);

        // Get the list of concerts from the repository
        List<Concert> concerts = ConcertRepository.getInstance(requireContext()).getConcerts();

        // Set up the RecyclerView with the ConcertAdapter
        recyclerView.setAdapter(new ConcertAdapter(concerts, onClickListener));

        // Return the fragment's view
        return rootView;
    }
    // ConcertAdapter class for populating RecyclerView with concert data
    private class ConcertAdapter extends RecyclerView.Adapter<ConcertHolder> {

        private final List<Concert> mConcerts;
        private final View.OnClickListener mOnClickListener;

        // Constructor to initialize the adapter with concerts and click listener
        public ConcertAdapter(List<Concert> concerts, View.OnClickListener onClickListener) {
            mConcerts = concerts;
            mOnClickListener = onClickListener;
        }
        // Create new ConcertHolder instances when needed
        @NonNull
        @Override
        public ConcertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ConcertHolder(layoutInflater, parent);
        }
        // Bind concert data to the ViewHolder
        public void onBindViewHolder(ConcertHolder holder, int position) {
            Concert concert = mConcerts.get(position);
            holder.bind(concert);
            holder.itemView.setTag(concert.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        // Return the total number of concerts in the adapter
        @Override
        public int getItemCount() {
            return mConcerts.size();
        }
    }

    // ConcertHolder class for holding View elements of a concert item
    private static class ConcertHolder extends RecyclerView.ViewHolder {

        private final TextView mNameTextView;

        // Constructor to initialize the ViewHolder with the item layout
        public ConcertHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_concert, parent, false));
            mNameTextView = itemView.findViewById(R.id.concert_name);
        }

        // Bind concert data to the TextView
        public void bind(Concert concert) {
            mNameTextView.setText(concert.getTitle());
        }
    }
}