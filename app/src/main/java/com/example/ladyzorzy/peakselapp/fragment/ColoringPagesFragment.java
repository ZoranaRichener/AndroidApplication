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
public class ColoringPagesFragment extends Fragment {

    public static ColoringPagesFragment coloringPagesFragmentInstance;
    ArrayList<GameItemSingle> coloring_pages_Items;
    SingleGamesAdapter mColoringPagesAdapter;
    RecyclerView mRecyclerView_ColoringPages;
    private RecyclerView.LayoutManager layoutManager_ColoringPages;
    private ShimmerFrameLayout mShimmerViewContainer;


    public ColoringPagesFragment() {
        // Required empty public constructor
    }

    public static ColoringPagesFragment newInstance() {
        ColoringPagesFragment fragment = new ColoringPagesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_coloring_pages,container, false);
        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        coloringPagesFragmentInstance = this;
//        RefreshFragmentData();

        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(3);


    }

    public void RefreshFragmentData() {

        mRecyclerView_ColoringPages= getActivity().findViewById(R.id.recycle_coloring_pages);
        DatabaseHelper database = new DatabaseHelper(getContext());
        coloring_pages_Items =  database.getColoringPagesData();
        mColoringPagesAdapter = new SingleGamesAdapter(getContext(),coloring_pages_Items);
        mRecyclerView_ColoringPages.setHasFixedSize(true);
        mRecyclerView_ColoringPages.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_ColoringPages = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView_ColoringPages.setLayoutManager(layoutManager_ColoringPages);
        mRecyclerView_ColoringPages.setAdapter(mColoringPagesAdapter);

        StopShimmer();

    }

    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }
}
