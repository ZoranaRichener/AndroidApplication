package com.example.ladyzorzy.peakselapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class CasualGamesFragment extends Fragment {

    public static CasualGamesFragment casualGamesFragmentInstance;
    ArrayList<GameItemSingle> casual_gameItems;
    SingleGamesAdapter mCasualGamesAdapter;
    RecyclerView mRecyclerView_CasualGames;
    private RecyclerView.LayoutManager layoutManager_CasualGames;
    private ShimmerFrameLayout mShimmerViewContainer;

    public CasualGamesFragment() {
        // Required empty public constructor
    }

    public static CasualGamesFragment newInstance() {
        CasualGamesFragment fragment = new CasualGamesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_casual_games,container, false);

        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);


        return rootView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        casualGamesFragmentInstance = this;
//        RefreshFragmentData();

//        mShimmerViewContainer.startShimmerAnimation();

        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(2);

    }

    public void RefreshFragmentData() {

        mRecyclerView_CasualGames = getActivity().findViewById(R.id.recycle_casual_games_fragment);
        DatabaseHelper database = new DatabaseHelper(getContext());

        casual_gameItems =  database.getCasualGameWhitPackageID();
//
//        for (GameItemSingle games : database.getCasualGameData()){
//
//            games.getAcf_android_app_url();
//            if (games.getAcf_android_app_url()!=null){
//                casual_gameItems =  database.getCasualGameData();
//            }
//        }
//
//        for(String name : namesList)
//        {
//            System.out.println(name);
//        }
//
//        Log.i("gamse",database.getCasualData().toString());

        mCasualGamesAdapter = new SingleGamesAdapter(getContext(),casual_gameItems);
        mRecyclerView_CasualGames.setHasFixedSize(true);
        mRecyclerView_CasualGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_CasualGames = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView_CasualGames.setLayoutManager(layoutManager_CasualGames);
        mRecyclerView_CasualGames.setAdapter(mCasualGamesAdapter);


        StopShimmer();

    }

    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

}


