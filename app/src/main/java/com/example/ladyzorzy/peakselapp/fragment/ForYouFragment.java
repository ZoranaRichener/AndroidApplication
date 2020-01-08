package com.example.ladyzorzy.peakselapp.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ladyzorzy.peakselapp.MainActivity;
import com.example.ladyzorzy.peakselapp.MyApplication;
import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.adapter.DoNotMissAdapter;
import com.example.ladyzorzy.peakselapp.adapter.HomePageAdapter;
import com.example.ladyzorzy.peakselapp.adapter.SlideShowAdapter;
import com.example.ladyzorzy.peakselapp.adapter.NewAppsAdapter;
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;

import com.facebook.shimmer.ShimmerFrameLayout;



import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ForYouFragment extends Fragment  implements View.OnClickListener  {

    public static final String FLURRY_NUM_OF_USERS_KEY = "FLURRY_NUM_OF_USERS_KEY";
    public static final String FLURRY_NUM_OF_SESSIONS_KEY = "FLURRY_NUM_OF_SESSIONS_KEY";

    private TabLayout tab_layout;

    private ImageView imageViewFacebook;
    private ImageView imageViewInstagram;
    private ImageView imageViewTwitter;
    private ImageView imageViewLinkedin;
    private ImageView imageViewBehance;
    private ImageView imageViewViber;
    private ImageView imageViewTelegram;
    private ImageView imageViewMEDIUM;
    private ImageView ImageViewRedHerring;
    private ImageView imageViewPeaksel;

   TextView text_view_flurry_newDevices;
   TextView textViewFlurrySessions;


    TextView btnGetAllVirtualPetGames;
    TextView btnGetAllCasualGames;
    TextView btnGetAllMathGames;
    TextView btnGetAllQuizGames;
    TextView btnColoringPagesGames;


    ArrayList<GamesItemHome> slide_showItems;
    SlideShowAdapter mSlideShowAdapter;
    RecyclerView mRecyclerView_SlideShow;
    private RecyclerView.LayoutManager layoutManager_SlideShow;


    ArrayList<GamesItemHome> virtual_gameItems;
    HomePageAdapter mVirtualGamesAdapter;
    RecyclerView mRecyclerView_VirtualGames;
    private RecyclerView.LayoutManager layoutManager_VirtualGames;

    ArrayList<GamesItemHome> new_apps_gameItems;
    NewAppsAdapter mNewAppsAdapter;
    RecyclerView mRecyclerView_NewApps;
    private RecyclerView.LayoutManager layoutManager_NewApps;


    ArrayList<GamesItemHome> doNotMiss_gameItems;
    DoNotMissAdapter mDoNotMissAdapter;
    RecyclerView mRecyclerView_DoNotMiss;
    private RecyclerView.LayoutManager layoutManager_DoNotMiss;

    ArrayList<GamesItemHome> casual_games_Items;
    HomePageAdapter mCasualGamesAdapter;
    RecyclerView mRecyclerView_CasualGames;
    private RecyclerView.LayoutManager layoutManager_CasualGames;


    ArrayList<GamesItemHome> math_gameItems;
    HomePageAdapter mMathGamesAdapter;
    RecyclerView mRecyclerView_MathGames;
    private RecyclerView.LayoutManager layoutManager_MathGames;

    ArrayList<GamesItemHome> quiz_gameItems;
    HomePageAdapter mQuizGamesAdapter;
    RecyclerView   mRecyclerView_QuizGames;
    private RecyclerView.LayoutManager layoutManager_QuizGames;

    ArrayList<GamesItemHome> coloring_pages_Items;
    HomePageAdapter mColoringPagesAdapter;
    RecyclerView mRecyclerView_ColoringPages;
    private RecyclerView.LayoutManager layoutManager_ColoringPages;

//    ShimmerFrameLayout view;

    private ShimmerFrameLayout mShimmerViewContainer;

    public ForYouFragment() {
        // Required empty public constructor
    }

    public static ForYouFragment newInstance() {
        ForYouFragment fragment = new ForYouFragment();
        return fragment;
    }



    public static ForYouFragment forYouFragmentInstance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_for_you,container, false);

        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


        tab_layout = (TabLayout) getActivity().findViewById(R.id.tab_layout);


        imageViewFacebook = rootView.findViewById(R.id.imageViewFacebook);
        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Peaksel")));
            }
        });

        imageViewInstagram = rootView.findViewById(R.id.imageViewInstagram);
        imageViewInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/lifeatpeaksel/")));
            }
        });

        imageViewTwitter = rootView.findViewById(R.id.imageViewTwitter);
        imageViewTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/peaksel")));
            }
        });

        imageViewLinkedin = rootView.findViewById(R.id.imageViewLinkedin);
        imageViewLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/peaksel-doo/")));
            }
        });
        imageViewBehance = rootView.findViewById(R.id.imageViewBehance);
        imageViewBehance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.behance.net/peaksel")));
            }
        });

        imageViewViber = rootView.findViewById(R.id.imageViewViber);
        imageViewViber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://chats.viber.com/peaksel/en")));
            }
        });

        imageViewTelegram = rootView.findViewById(R.id.imageViewTelegram);
        imageViewTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/peaksel")));
            }
        });

        imageViewMEDIUM= rootView.findViewById(R.id.imageViewMedium);
        imageViewMEDIUM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/@PeakselDev")));
            }
        });

        ImageViewRedHerring = rootView.findViewById(R.id.imageViewRedHerring);
        ImageViewRedHerring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.redherring.com")));
            }
        });

        imageViewPeaksel = rootView.findViewById(R.id.imageViewPeaksel);
        imageViewPeaksel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://peaksel.com/")));
            }
        });


        btnGetAllVirtualPetGames = (TextView) rootView.findViewById(R.id.btn_virtual_pets_viewAll);
        btnGetAllCasualGames = (TextView) rootView.findViewById(R.id.btn_casual_games_viewAll);
        btnGetAllMathGames =(TextView) rootView.findViewById(R.id.btn_math_games_viewAll);
        btnGetAllQuizGames = (TextView) rootView.findViewById(R.id.btn_quiz_games_viewAll);
        btnColoringPagesGames = (TextView)  rootView.findViewById(R.id.btn_coloring_pages_viewAll);

        text_view_flurry_newDevices = rootView.findViewById(R.id.text_view_flurry_newDevices);
        textViewFlurrySessions = rootView.findViewById(R.id.textViewFlurrySessions);

        btnGetAllVirtualPetGames.setOnClickListener(this);
        btnGetAllCasualGames.setOnClickListener(this);
        btnGetAllQuizGames.setOnClickListener(this);
        btnGetAllMathGames.setOnClickListener(this);
        btnColoringPagesGames.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        forYouFragmentInstance = this;
        mShimmerViewContainer.startShimmerAnimation();
        MainActivity.mainActivityInstance.GetDataForFragmentWithIndex(0);

        RefreshFlurryData();

    }


    public void RefreshFragmentData()
    {

        mRecyclerView_SlideShow = getActivity().findViewById(R.id.recycle_view_slide_show);
        mRecyclerView_VirtualGames = getActivity().findViewById(R.id.recycle_virtual_games_home);
        mRecyclerView_NewApps = getActivity().findViewById(R.id.recycle_new_apps);
        mRecyclerView_DoNotMiss = getActivity().findViewById(R.id.recycle_do_not_miss);
        mRecyclerView_ColoringPages= getActivity().findViewById(R.id.recycle_coloring_pages_home);
        mRecyclerView_QuizGames = getActivity().findViewById(R.id.recycle_quiz_games_home);
        mRecyclerView_MathGames = getActivity().findViewById(R.id.recycle_math_games_home);
        mRecyclerView_CasualGames= getActivity().findViewById(R.id.recycle_casual_games);

        slide_showItems =   MyApplication.databaseHelper.getSliderData();
        mSlideShowAdapter = new SlideShowAdapter(getContext(),slide_showItems);
        mRecyclerView_SlideShow.setHasFixedSize(true);
        mRecyclerView_SlideShow.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_SlideShow = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_SlideShow.setLayoutManager(layoutManager_SlideShow);
        mRecyclerView_SlideShow.setAdapter(mSlideShowAdapter);


        virtual_gameItems =  MyApplication.databaseHelper.getVirtualGamesData();
        mVirtualGamesAdapter = new HomePageAdapter(getContext(),virtual_gameItems);
        mRecyclerView_VirtualGames.setHasFixedSize(true);
        mRecyclerView_VirtualGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_VirtualGames = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_VirtualGames.setLayoutManager(layoutManager_VirtualGames);
        mRecyclerView_VirtualGames.setAdapter(mVirtualGamesAdapter);




        new_apps_gameItems =   MyApplication.databaseHelper.getTopAppsData();
        mNewAppsAdapter = new NewAppsAdapter(getContext(),new_apps_gameItems);
        mRecyclerView_NewApps.setHasFixedSize(true);
        mRecyclerView_NewApps.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_NewApps =  new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_NewApps.setLayoutManager(layoutManager_NewApps);
        mRecyclerView_NewApps.setAdapter(mNewAppsAdapter);



        // OVER 5 MILLION USERS
        doNotMiss_gameItems =   MyApplication.databaseHelper.getDoNotMissData();
        mDoNotMissAdapter = new DoNotMissAdapter(getContext(),doNotMiss_gameItems);
        mRecyclerView_DoNotMiss.setHasFixedSize(true);
        mRecyclerView_DoNotMiss.setLayoutManager(new LinearLayoutManager(getContext()));

        layoutManager_DoNotMiss = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_DoNotMiss.setLayoutManager(layoutManager_DoNotMiss);
        mRecyclerView_DoNotMiss.setAdapter(mDoNotMissAdapter);



        casual_games_Items =    MyApplication.databaseHelper.getCasualData();
        mCasualGamesAdapter = new HomePageAdapter(getContext(),casual_games_Items);
        mRecyclerView_CasualGames.setHasFixedSize(true);
        mRecyclerView_CasualGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_CasualGames  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_CasualGames.setLayoutManager(layoutManager_CasualGames);
        mRecyclerView_CasualGames.setAdapter(mCasualGamesAdapter);



        math_gameItems =  MyApplication.databaseHelper.getMathData();
        mMathGamesAdapter = new HomePageAdapter(getContext(), math_gameItems);
        mRecyclerView_MathGames.setHasFixedSize(true);
        mRecyclerView_MathGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_MathGames = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_MathGames.setLayoutManager(layoutManager_MathGames);
        mRecyclerView_MathGames.setAdapter(mMathGamesAdapter);



        quiz_gameItems =   MyApplication.databaseHelper.getQuizData();
        mQuizGamesAdapter = new HomePageAdapter(getContext(),quiz_gameItems);
        mRecyclerView_QuizGames.setHasFixedSize(true);
        mRecyclerView_QuizGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_QuizGames =  new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_QuizGames.setLayoutManager(layoutManager_QuizGames);
        mRecyclerView_QuizGames.setAdapter(mQuizGamesAdapter);



        coloring_pages_Items =    MyApplication.databaseHelper.getColoringPagesDataFromHomePage();
        mColoringPagesAdapter = new HomePageAdapter(getContext(),coloring_pages_Items);
        mRecyclerView_ColoringPages.setHasFixedSize(true);
        mRecyclerView_ColoringPages.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_ColoringPages = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_ColoringPages.setLayoutManager(layoutManager_ColoringPages);
        mRecyclerView_ColoringPages.setAdapter(mColoringPagesAdapter);



        mRecyclerView_VirtualGames.setNestedScrollingEnabled(false);
        mRecyclerView_NewApps.setNestedScrollingEnabled(false);
        mRecyclerView_DoNotMiss.setNestedScrollingEnabled(false);
        mRecyclerView_CasualGames.setNestedScrollingEnabled(false);
        mRecyclerView_MathGames.setNestedScrollingEnabled(false);
        mRecyclerView_QuizGames.setNestedScrollingEnabled(false);
        mRecyclerView_CasualGames.setNestedScrollingEnabled(false);



        Log.i("test_fragment", "RefreshFragmentData");


        StopShimmer();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {

            case R.id.btn_virtual_pets_viewAll:

                tab_layout.getTabAt(1).select();

                break;

            case R.id.btn_casual_games_viewAll:

                tab_layout.getTabAt(2).select();

                break;

            case R.id.btn_coloring_pages_viewAll:

                tab_layout.getTabAt(3).select();
                break;


            case R.id.btn_quiz_games_viewAll:

                tab_layout.getTabAt(4).select();
                break;

            case R.id.btn_math_games_viewAll:

                tab_layout.getTabAt(5).select();

                break;

        }

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
//        mShimmerViewContainer.stopShimmer();
        super.onPause();
    }


    public void RefreshFlurryData()
    {

//        if(!MyApplication.sharedPreferences.contains(FLURRY_NUM_OF_USERS_KEY))
//        {
//            return;
//        }

//         String flurry_num_of_devices = MyApplication.sharedPreferences.getString(FLURRY_NUM_OF_USERS_KEY,"--:--");
//
//        char char1 = flurry_num_of_devices.charAt(0);
//        char char2 = flurry_num_of_devices.charAt(1);
//        char char3 = flurry_num_of_devices.charAt(2);
//        char char4 = flurry_num_of_devices.charAt(3);
//        char char5 = flurry_num_of_devices.charAt(4);
//        char char6 = flurry_num_of_devices.charAt(5);
//        char char7 = flurry_num_of_devices.charAt(6);
//        char char8 = flurry_num_of_devices.charAt(7);
//        char char9 = flurry_num_of_devices.charAt(8);
//
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(char1);
//        sb.append(char2);
//        sb.append(char3);
//        sb.append(" ");
//        sb.append(char4);
//        sb.append(char5);
//        sb.append(char6);
//        sb.append(" ");
//        sb.append(char7);
//        sb.append(char8);
//        sb.append(char9);
//
//        String flurry_num_of_devices2 = sb.toString();
//
//       text_view_flurry_newDevices.setText(flurry_num_of_devices2);

       text_view_flurry_newDevices.setText(MyApplication.sharedPreferences.getString(FLURRY_NUM_OF_USERS_KEY , "--:--"));


        textViewFlurrySessions.setText(MyApplication.sharedPreferences.getString(FLURRY_NUM_OF_SESSIONS_KEY,"---"));



//        String flurry_num_of_sessions =MyApplication.sharedPreferences.getString(FLURRY_NUM_OF_SESSIONS_KEY,"--:--");
//
//        char session_char1 = flurry_num_of_sessions.charAt(0);
//        char session_char2 = flurry_num_of_sessions.charAt(1);
//        char session_char3 = flurry_num_of_sessions.charAt(2);
//        char session_char4 = flurry_num_of_sessions.charAt(3);
//        char session_char5 = flurry_num_of_sessions.charAt(4);
//        char session_char6 = flurry_num_of_sessions.charAt(5);
//        char session_char7 = flurry_num_of_sessions.charAt(6);
//        char session_char8 = flurry_num_of_sessions.charAt(7);
//        char session_char9 = flurry_num_of_sessions.charAt(8);
//
//        StringBuilder sb_sessions = new StringBuilder();
//        sb_sessions.append(session_char1);
//        sb_sessions.append(session_char2);
//        sb_sessions.append(session_char3);
//        sb_sessions.append(" ");
//        sb_sessions.append(session_char4);
//        sb_sessions.append(session_char5);
//        sb_sessions.append(session_char6);
//        sb_sessions.append(" ");
//        sb_sessions.append(session_char7);
//        sb_sessions.append(session_char8);
//        sb_sessions.append(session_char9);
//
//        String flurry_num_of_sessions2 = sb_sessions.toString();
//
//
//       // textViewFlurrySessions.setText(MyApplication.sharedPreferences.getString(FLURRY_NUM_OF_SESSIONS_KEY , "--:--"));
//       textViewFlurrySessions.setText(flurry_num_of_sessions2);


    }


    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }
}

