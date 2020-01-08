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
public class QuizGamesFragment extends Fragment {

    public static QuizGamesFragment quizGamesFragmentInstance;
    ArrayList<GameItemSingle> quiz_gameItems;
    SingleGamesAdapter mQuizGamesAdapter;
    RecyclerView mRecyclerView_QuizGames;
    private RecyclerView.LayoutManager layoutManager_QuizGames;
    private ShimmerFrameLayout mShimmerViewContainer;

    public QuizGamesFragment() {
        // Required empty public constructor
    }

    public static QuizGamesFragment newInstance() {
        QuizGamesFragment fragment = new QuizGamesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz_games,container, false);
        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        quizGamesFragmentInstance = this;

//        RefreshFragmentData();

        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(4);


    }

    public void RefreshFragmentData() {

        mRecyclerView_QuizGames = getActivity().findViewById(R.id.recycle_quiz_games);
        DatabaseHelper database = new DatabaseHelper(getContext());
        quiz_gameItems =  database.getQuizGameData();
        mQuizGamesAdapter = new SingleGamesAdapter(getContext(),quiz_gameItems);
        mRecyclerView_QuizGames.setHasFixedSize(true);
        mRecyclerView_QuizGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_QuizGames = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView_QuizGames.setLayoutManager(layoutManager_QuizGames);
        mRecyclerView_QuizGames.setAdapter(mQuizGamesAdapter);
        StopShimmer();

    }

    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

}
