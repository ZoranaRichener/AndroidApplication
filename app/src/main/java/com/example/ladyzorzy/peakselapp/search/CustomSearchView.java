package com.example.ladyzorzy.peakselapp.search;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

import com.example.ladyzorzy.peakselapp.MainActivity;
import com.example.ladyzorzy.peakselapp.MyApplication;
import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.ladyzorzy.peakselapp.search.CustomSearchView.SEARCH_MODE.NO_SEARCH_TERM_ENTERED;


public class CustomSearchView extends RelativeLayout implements SearchAdapter.GameAdapterListener {


    Context context;

    InputMethodManager imm;

    SearchHeaderView searchHeaderView;

    SearchAdapter searchAdapter;
    RecyclerView searchResultSRecycler;
    View no_entered_text_view;
    View no_results_view;

    List<GameItemSingle> foundItems = new ArrayList<>();

    @Override
    public void onGameSelected(GameItemSingle contact) {
        String id = contact.get_id();
        SinglePageFragment singlePageFragment = new SinglePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
       // Log.e("onClick",id );

        singlePageFragment.setArguments(bundle);
        FragmentManager fragmentManagerSearchSingle = MainActivity.mainActivityInstance.getSupportFragmentManager();

        ShowSearchView(false);

        fragmentManagerSearchSingle.beginTransaction().replace(R.id.content_frame1,singlePageFragment).addToBackStack(null).commit();
    }


    public enum SEARCH_MODE
    {
        NO_SEARCH_TERM_ENTERED(0),
        NO_RESULTS_FOUND(1),
        RESULTS_FOUND(2);

        private final int value;

        SEARCH_MODE(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }



    public CustomSearchView(Context context) {
        super(context);

        this.context = context;
        init();

    }

    public CustomSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        init();

    }

    public boolean onBackPressed()
    {

        if(this.getVisibility()== View.VISIBLE)
        {
            ShowSearchView(false);
            return true;
        }
        else
        {
            return false;
        }
    }

    private void ShowKeyboard(boolean show)
    {

        if(show)
        {
            imm = (InputMethodManager) MainActivity.mainActivityInstance.getSystemService(Context.INPUT_METHOD_SERVICE);

            searchHeaderView.getEditeText().post(new Runnable() {
                @Override
                public void run() {


                    imm.showSoftInput(searchHeaderView.getEditeText(), InputMethodManager.SHOW_IMPLICIT);

                }
            });

            searchHeaderView.getEditeText().requestFocus();
        }
        else
        {

                try
                {
                    imm.hideSoftInputFromWindow(searchHeaderView.getEditeText().getWindowToken(), 0);

                }
                catch(Exception e)
                {

                }

        }
    }


    public void ShowSearchView(boolean show)
    {

        if(show)
        {
            foundItems = new ArrayList<>();
            searchAdapter.RefreshAdapter(foundItems);
            searchHeaderView.ResetSearchText();
            this.setVisibility(View.VISIBLE);

            ShowKeyboard(true);


        }
        else
        {
            ShowKeyboard(false);
            this.setVisibility(View.INVISIBLE);

        }



    }

    public CustomSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        init();

    }



    private void init()
    {


        View root = View.inflate(context, R.layout.search_view, this);


        root.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        searchResultSRecycler =root.findViewById(R.id.searchResultSRecycler);
                searchAdapter = new SearchAdapter(MyApplication.mInstance, foundItems,  this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MyApplication.mInstance);
        searchResultSRecycler.setLayoutManager(mLayoutManager);
        searchResultSRecycler.setItemAnimator(new DefaultItemAnimator());
        searchResultSRecycler.addItemDecoration(new MyDividerItemDecoration(MyApplication.mInstance, DividerItemDecoration.VERTICAL, 36));
        searchResultSRecycler.setAdapter(searchAdapter);


        no_entered_text_view = root.findViewById(R.id.no_entered_text_view);
        no_results_view = root.findViewById(R.id.no_results_view);


        searchHeaderView = root.findViewById(R.id.search_header_view);

        searchHeaderView.setSearchHeaderViewInterafce(new SearchHeaderView.SearchHeaderViewInterafce() {
            @Override
            public void IconBackClicked() {
                ShowSearchView(false);
            }

            @Override
            public void EnteredTextChanged(String newText) {

                Log.i("test_search", "text chaged-->" + newText);

                currentSearchNode = NO_SEARCH_TERM_ENTERED;
                if(newText!=null)
                {

                    if(newText.length() > 0)
                    {
                        foundItems = MyApplication.databaseHelper.GetGamesBySearchTerm(newText);
                        if(foundItems!=null)
                        {
                            if(foundItems.size()>0)
                            {
                                currentSearchNode = SEARCH_MODE.RESULTS_FOUND;

                                searchAdapter.RefreshAdapter(foundItems);
                            }
                            else
                            {
                                currentSearchNode = SEARCH_MODE.NO_RESULTS_FOUND;
                            }
                        }

                    }

                }

                SetAppropriateModeForSearchViewState();
            }
        });

        ShowSearchView(false);


    }

    SEARCH_MODE currentSearchNode = NO_SEARCH_TERM_ENTERED;
    void SetAppropriateModeForSearchViewState()
    {

        searchResultSRecycler.setVisibility(View.INVISIBLE);
        no_entered_text_view.setVisibility(View.INVISIBLE);
        no_results_view.setVisibility(View.INVISIBLE);

        switch(currentSearchNode)
        {
            case NO_SEARCH_TERM_ENTERED:
                no_entered_text_view.setVisibility(View.VISIBLE);
                break;
            case NO_RESULTS_FOUND:
                no_results_view.setVisibility(View.VISIBLE);
                break;
            case RESULTS_FOUND:
                searchResultSRecycler.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }




}



