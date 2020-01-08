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
public class MathGamesFragment extends Fragment {
    public static MathGamesFragment mathGamesFragmentInstance;
    ArrayList<GameItemSingle> math_gameItems;
    SingleGamesAdapter mMathGamesAdapter;
    RecyclerView mRecyclerView_MathGames;
    private RecyclerView.LayoutManager layoutManager_MathGames;
    private ShimmerFrameLayout mShimmerViewContainer;


    public MathGamesFragment() {
        // Required empty public constructor
    }

    public static  MathGamesFragment newInstance() {
        MathGamesFragment fragment = new  MathGamesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_math_games,container, false);
        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        mathGamesFragmentInstance = this;
//
//        RefreshFragmentData();

        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(5);


    }

    public void RefreshFragmentData() {


        mRecyclerView_MathGames = getActivity().findViewById(R.id.recycle_math_games);
        DatabaseHelper database = new DatabaseHelper(getContext());
        math_gameItems = database.getMathGameData();
        mMathGamesAdapter = new SingleGamesAdapter(getContext(), math_gameItems);
        mRecyclerView_MathGames.setHasFixedSize(true);
        mRecyclerView_MathGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_MathGames = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        mRecyclerView_MathGames.setLayoutManager(layoutManager_MathGames);
        mRecyclerView_MathGames.setAdapter(mMathGamesAdapter);

        StopShimmer();

    }

    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

}
