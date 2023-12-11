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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        View.OnClickListener onClickListener = itemView -> {

            // Create fragment arguments containing the selected band ID
            int selectedBandId = (int) itemView.getTag();
            Bundle args = new Bundle();
            args.putInt(DetailConcertFragment.ARG_CONCERT_ID, selectedBandId);

            // Replace list with details
            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        // Send bands to RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.band_list);
        List<Concert> concerts = ConcertRepository.getInstance(requireContext()).getConcerts();
        recyclerView.setAdapter(new ConcertAdapter(concerts, onClickListener));

        return rootView;
    }
    private class ConcertAdapter extends RecyclerView.Adapter<ConcertHolder> {

        private final List<Concert> mConcerts;
        private final View.OnClickListener mOnClickListener;

        public ConcertAdapter(List<Concert> concerts, View.OnClickListener onClickListener) {
            mConcerts = concerts;
            mOnClickListener = onClickListener;
        }
        @NonNull
        @Override
        public ConcertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ConcertHolder(layoutInflater, parent);
        }
        public void onBindViewHolder(ConcertHolder holder, int position) {
            Concert concert = mConcerts.get(position);
            holder.bind(concert);
            holder.itemView.setTag(concert.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }
        @Override
        public int getItemCount() {
            return mConcerts.size();
        }
    }

    private static class ConcertHolder extends RecyclerView.ViewHolder {

        private final TextView mNameTextView;

        public ConcertHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_concert, parent, false));
            mNameTextView = itemView.findViewById(R.id.concert_name);
        }

        public void bind(Concert band) {
            mNameTextView.setText(band.getTitle());
        }
    }
}