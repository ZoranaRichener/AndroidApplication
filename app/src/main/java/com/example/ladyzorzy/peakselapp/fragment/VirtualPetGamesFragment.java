package com.example.ladyzorzy.peakselapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ladyzorzy.peakselapp.MainActivity;
import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.adapter.SingleGamesAdapter;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.database.DatabaseHelper;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VirtualPetGamesFragment extends Fragment {

    public static VirtualPetGamesFragment virtualPetGamesFragmentInstance;

    ArrayList<GameItemSingle> virtual_gameItems;
    SingleGamesAdapter mVirtualGamesAdapter;
    RecyclerView mRecyclerView_VirtualGames;
    private RecyclerView.LayoutManager layoutManager_VirtualGames;

    private ShimmerFrameLayout mShimmerViewContainer;


    public VirtualPetGamesFragment() {
        // Required empty public constructor
    }

    public static VirtualPetGamesFragment newInstance() {
        VirtualPetGamesFragment fragment = new VirtualPetGamesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_virtual_pet_games,container, false);

        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);


        return rootView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        virtualPetGamesFragmentInstance = this;

//        RefreshFragmentData();

        mRecyclerView_VirtualGames = getActivity().findViewById(R.id.recycle_virtual_pet_games);

        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(1);


    }

    public void RefreshFragmentData() {



        DatabaseHelper database = new DatabaseHelper(getContext());
        virtual_gameItems =  database.getVirtualGameData();
        mVirtualGamesAdapter = new SingleGamesAdapter(getContext(),virtual_gameItems);
        mRecyclerView_VirtualGames.setHasFixedSize(true);
        mRecyclerView_VirtualGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_VirtualGames = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView_VirtualGames.setLayoutManager(layoutManager_VirtualGames);
        mRecyclerView_VirtualGames.setAdapter(mVirtualGamesAdapter);

        StopShimmer();

    }

    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }


}