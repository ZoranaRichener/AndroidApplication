package com.example.ladyzorzy.peakselapp;

import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;
import com.example.ladyzorzy.peakselapp.data.Notification;
import com.example.ladyzorzy.peakselapp.data.TestimonialsItem;
import com.example.ladyzorzy.peakselapp.database.DatabaseHelper;
import com.example.ladyzorzy.peakselapp.fragment.CasualGamesFragment;
import com.example.ladyzorzy.peakselapp.fragment.ColoringPagesFragment;
import com.example.ladyzorzy.peakselapp.fragment.ForYouFragment;
import com.example.ladyzorzy.peakselapp.fragment.MathGamesFragment;
import com.example.ladyzorzy.peakselapp.fragment.QuizGamesFragment;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;
import com.example.ladyzorzy.peakselapp.fragment.VirtualPetGamesFragment;
import com.example.ladyzorzy.peakselapp.fragment.WebViewDialogFragment;
import com.example.ladyzorzy.peakselapp.search.CustomSearchView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private Toolbar mTopToolbar;
    private DrawerLayout mDrawerLayout;
    private ImageView imageViewMenu;
    private ImageView ico_search;
    private ViewPager view_pager;
    private TabLayout tab_layout;
    CustomSearchView customSearchView;

    ArrayList<GamesItemHome> mSliderList = new ArrayList<>();
    ArrayList<GamesItemHome> mTopAppsAndGamesList = new ArrayList<>();
    ArrayList<GamesItemHome> mVirtualPetGamesList = new ArrayList<>();
    ArrayList<GamesItemHome> mDoNotMissGamesList = new ArrayList<>();
    ArrayList<GamesItemHome> mCasualGamesList = new ArrayList<>();
    ArrayList<GamesItemHome> mQuizGamesList = new ArrayList<>();
    ArrayList<GamesItemHome> mColoringPagesList = new ArrayList<>();
    ArrayList<GamesItemHome> mMathGamesList = new ArrayList<>();

    ArrayList<TestimonialsItem> mTestimonialList = new ArrayList<>();

    // Json parsiranje HomePage elementi
    private RequestQueue mRequestQueue;

    //Json parsiranje SinglePage elementi
    private String mJsonUrlColoringPagesString = "https://peaksel.com/wp-json/wp/v2/coloring_pages?per_page=24";
    private String mJSONURLCasualString = "https://peaksel.com/wp-json/wp/v2/casual_games?per_page=24";
    private String mJsonUrlVirtualString = "https://peaksel.com/wp-json/wp/v2/virtual_pet_games?per_page=24";
    private String mJsonUrlMathString = "https://peaksel.com/wp-json/wp/v2/math_games?per_page=7";
    private String mJsonUrlQuizString = "https://peaksel.com/wp-json/wp/v2/quiz_games?per_page=21";

    ArrayList<GameItemSingle> result = new ArrayList<>();

    ArrayList<Notification> notification_list = new ArrayList<>();

    DatabaseHelper databaseHelper;

    private CoordinatorLayout mCLayout;


    public static MainActivity mainActivityInstance;


    public String Notification0= "notification0.json";
    public String Notification1 = "notification1.json";
    public String Notification2 = "notification2.json";

    public void GetDataForFragmentWithIndex(int fragmentIndex)
    {



        switch (fragmentIndex)
        {


            case 0:
                ReturnJsonObjectData();

                parseJsonArray(mJsonUrlVirtualString,0);
                parseJsonArray(mJSONURLCasualString,0);
                parseJsonArray(mJsonUrlColoringPagesString,0);
                parseJsonArray(mJsonUrlQuizString,0);
                parseJsonArray(mJsonUrlMathString,0);
                parseTestimonialsArray(mJsonUrlVirtualString, 0);
                parseTestimonialsArray(mJSONURLCasualString, 0);
                parseTestimonialsArray(mJsonUrlColoringPagesString, 0);
                parseTestimonialsArray(mJsonUrlQuizString, 0);
                parseTestimonialsArray(mJsonUrlMathString, 0);
                //getNotificationsJson(Notification1);



                break;
            case 1:

                parseJsonArray(mJsonUrlVirtualString, 1);
                parseTestimonialsArray(mJsonUrlVirtualString, 1);

                break;
            case 2:
                parseJsonArray(mJSONURLCasualString, 2);
                parseTestimonialsArray(mJSONURLCasualString, 2);
                break;
            case 3:

                parseJsonArray(mJsonUrlColoringPagesString, 3);
                parseTestimonialsArray(mJsonUrlColoringPagesString, 3);

                break;
            case 4:

                parseJsonArray(mJsonUrlQuizString, 4);
                parseTestimonialsArray(mJsonUrlQuizString, 4);

                break;
            case 5:


                parseJsonArray(mJsonUrlMathString, 5);
                parseTestimonialsArray(mJsonUrlMathString, 5);
                break;
            default:

                break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNotificationsJson(Notification1);
        getNotificationsJson(Notification2);

        mainActivityInstance = this;

        mRequestQueue = Volley.newRequestQueue(MainActivity.this);

        //VECTOR ITEMS SUPPORT
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        //FB SHIMMER

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);


        initComponent();


        databaseHelper = new DatabaseHelper(this);


        //Dodatak za Navigation Drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageViewMenu = findViewById(R.id.image_view_menu);


        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDrawer();
            }
        });

        customSearchView = findViewById(R.id.custom_search_view);

        ico_search = findViewById(R.id.ico_search);

        ico_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IcoSearchClicked();
            }
        });


        // Navigation Drawer open-close listeneri
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    public void OpenDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    public void IcoSearchClicked() {
        customSearchView.ShowSearchView(true);
    }



    @Override
    public void onBackPressed() {



        if(customSearchView.onBackPressed())
        {
            return;
        }



        if (getSupportFragmentManager().getBackStackEntryCount() != 1) {
            getSupportFragmentManager().popBackStackImmediate();

        }


        super.onBackPressed();
    }



    //Inicijalizacija komponenti -view page i tab layout
    private void initComponent() {

        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setTabTextColors(getResources().getColor(R.color.normal), getResources().getColor(R.color.selected));
        setupViewPager(view_pager);

        tab_layout.getTabAt(0).setIcon(R.drawable.tabs_ico_for_you);
        tab_layout.getTabAt(1).setIcon(R.drawable.tabs_ico_virtual_pet_games);
        tab_layout.getTabAt(2).setIcon(R.drawable.tabs_ico_casual_games);
        tab_layout.getTabAt(3).setIcon(R.drawable.tabs_ico_coloring_pages);
        tab_layout.getTabAt(4).setIcon(R.drawable.tabs_ico_quiz_games);
        tab_layout.getTabAt(5).setIcon(R.drawable.tabs_ico_math_games);

        tab_layout.getTabAt(0).setText("FOR YOU");


        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.selected), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.normal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            if (fragmentManager.getFragments() != null) {
                fragmentManager.getFragments().clear();
            }
            //... your other code here
        }

        @Override
        public Fragment getItem(int position) {

            return listOfFragments[position];
        }

        @Override
        public int getCount() {

            return listOfFragments.length;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            return listOfTitles[position];
        }
    }

    SectionsPagerAdapter adapter;

    Fragment[] listOfFragments = {ForYouFragment.newInstance(),VirtualPetGamesFragment.newInstance(),CasualGamesFragment.newInstance(),
            ColoringPagesFragment.newInstance(), QuizGamesFragment.newInstance(), MathGamesFragment.newInstance()  };
    String[] listOfTitles = {"FOR YOU", "VIRTUAL PET GAMES","CASUAL GAMES","COLORING PAGES", "QUIZ GAMES", "MATH GAMES"  };

    private void setupViewPager(ViewPager viewPager) {
        adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Log.i("test_fragment", "setupViewPager called");
    }

    private void RefreshSinglePageFragment()
    {
        try {

//            ((VirtualPetGamesFragment) listOfFragments[1]).RefreshFragmentData();
            SinglePageFragment.singlePageFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshSinglePageFragment--> " + e);
        }
    }

    private void RefreshForYouFragment()
    {
        try {

            //((ForYouFragment) listOfFragments[0]).RefreshFragmentData();

            ForYouFragment.forYouFragmentInstance.RefreshFragmentData();

//            ((ForYouFragment) listOfFragments[0]).StopShimmer();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshForYouFragment--> " + e);
        }
    }

    private void RefreshVirtualPetGamesFragment()
    {
        try {

//            ((VirtualPetGamesFragment) listOfFragments[1]).RefreshFragmentData();
            VirtualPetGamesFragment.virtualPetGamesFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshVirtualPetGamesFragment--> " + e);
        }
    }

    private void RefreshCasualGamesFragment()
    {
        try {

//            ((CasualGamesFragment) listOfFragments[2]).RefreshFragmentData();
            CasualGamesFragment.casualGamesFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshCasualGamesFragment--> " + e);
        }
    }


    private void RefreshColoringPagesFragment()
    {
        try {

//            ((ColoringPagesFragment) listOfFragments[3]).RefreshFragmentData();
            ColoringPagesFragment.coloringPagesFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshColoringPagesFragment--> " + e);
        }
    }

    private void RefreshQuizGamesFragment()
    {
        try {

//            ((QuizGamesFragment) listOfFragments[4]).RefreshFragmentData();

            QuizGamesFragment.quizGamesFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshQuizGamesFragment--> " + e);
        }
    }

    private void RefreshMathGamesFragment()
    {
        try {

//            ((MathGamesFragment) listOfFragments[5]).RefreshFragmentData();
            MathGamesFragment.mathGamesFragmentInstance.RefreshFragmentData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired RefreshMathGamesFragment--> " + e);
        }
    }


    // PARSIRANJE

    private void InitializeLists(JSONObject response) {

        try {
            mSliderList = JedinstvenaMetoda(response, "slider");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            mTopAppsAndGamesList = JedinstvenaMetoda(response, "top_apps_and_games");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            mVirtualPetGamesList = JedinstvenaMetoda(response, "virtual_pet_games");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            mDoNotMissGamesList = JedinstvenaMetoda(response, "do_not_miss");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            mCasualGamesList = JedinstvenaMetoda(response, "casual_games");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            mQuizGamesList = JedinstvenaMetoda(response, "quiz_games");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            mColoringPagesList = JedinstvenaMetoda(response, "coloring_pages");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            mMathGamesList = JedinstvenaMetoda(response, "math_games");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("test_fragment", "obradjene liste");

    }

    //Metoda koja unosi liste podataka u DB
    private void InsertDataInDB() {

        MyApplication.databaseHelper.insertSliderItemArray(mSliderList);
        MyApplication.databaseHelper.insertTopAppsItemArray(mTopAppsAndGamesList);
        MyApplication.databaseHelper.insertVirtualGamesItemArray(mVirtualPetGamesList);
        MyApplication.databaseHelper.insertDo_Not_MissItemArray(mDoNotMissGamesList);
        MyApplication.databaseHelper.insertCasualGamesItemArray(mCasualGamesList);
        MyApplication.databaseHelper.insertQuizGamesItemArray(mQuizGamesList);
        MyApplication.databaseHelper.insertColoringPagesItemArray(mColoringPagesList);
        MyApplication.databaseHelper.insertMathGamesItemArray(mMathGamesList);
        // Toast.makeText(MainActivity.this, "All list added!", Toast.LENGTH_LONG).show();


//        shimmerFrameLayout.stopShimmer();
//        shimmerFrameLayout.setVisibility(GONE);

        Log.i("test_fragment", "InsertDataInDB finished");

    }

    /**
     * Metoda koja vraca glavni Json objekat za Home page
     */
    private void ReturnJsonObjectData() {


        if(SucsesfullyEnteredFragmentInDBForIndex[0])
        {

            Log.i("test_shimmer","prolazzz 1");
            RefreshAppropriateFragment(0);
            return;
        }
        Log.i("test_shimmer","prolazzz 2");

        String url = "https://peaksel.com/wp-json/app/v1/front-page";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        InitializeLists(response);
                        InsertDataInDB();
                        SucsesfullyEnteredFragmentInDBForIndex[0] = true;
                        RefreshAppropriateFragment(0);

                        StartFlurryRequest();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        //cancel all previous requests
        mRequestQueue.cancelAll(0);
        request.setTag(0);
        mRequestQueue.add(request);


    }

    private ArrayList<GamesItemHome> JedinstvenaMetoda(JSONObject response, String root_node_name) throws JSONException {

        JSONObject jsonObject = response.getJSONObject(root_node_name);

        String category_name = jsonObject.getString("category_name");

        JSONArray arr_games = jsonObject.getJSONArray("games");

        ArrayList<GamesItemHome> result = new ArrayList<>();

        for (int i = 0; i < arr_games.length(); i++) {
            String id = arr_games.getJSONObject(i).getString("ID");
            String title = arr_games.getJSONObject(i).getString("title");
            String image = arr_games.getJSONObject(i).getString("image");
            String featured_image = arr_games.getJSONObject(i).getString("featured_image");
            String category = arr_games.getJSONObject(i).getString("category");
            String link = arr_games.getJSONObject(i).getString("link");

            result.add(new GamesItemHome(category_name, id, title, image, featured_image, category, link));
        }

        return result;
    }
    /////////////////// KRAJ HOME PAGE PARSIRANJE I UNOS U BAZU


    ///////////////////POCETAK SINGLE PAGE PARSIRANJE I UNOS U BAZU
    private void InsertSingleDataInDB() {

        databaseHelper = new DatabaseHelper(this);
        // db.clearDB();
        databaseHelper.inserSinglePageItemArray(result);

    }

    private void InsertTestimonialInDB() {
        databaseHelper  = new DatabaseHelper(this);
        databaseHelper.insertTestimonialItemArray(mTestimonialList);
        mTestimonialList.size();

    }

    public static String html2text(String html) {

        return Jsoup.parse(html).text();
    }


    private  void parseTestimonialsArray(String url, int fragmentIndexForRefresh){

        final int  fragIndexFinal = fragmentIndexForRefresh;

        if(SucsesfullyEnteredTestimonialsInDBForIndex[fragIndexFinal])
        {
            return;
        }


        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                //pristup acf objektu
                                JSONObject acf_object = jsonObject.getJSONObject("acf");


                                JSONArray testimonialsArray = acf_object.getJSONArray("testimonials");


                                for (int t = 0; t < testimonialsArray.length(); t++) {

                                    JSONObject testimonialsObject = testimonialsArray.getJSONObject(t);
                                    String content = testimonialsObject.getString("content");

                                    String content_text = html2text(content);
                                    //String content_text = content;

                                    String testimonials_author = testimonialsObject.getString("author");

                                    String rating = testimonialsObject.getString("rating");


                                    mTestimonialList.add(new TestimonialsItem(id,content_text,testimonials_author,rating));

                                }


                            }

                            InsertTestimonialInDB();

                            SucsesfullyEnteredTestimonialsInDBForIndex[fragIndexFinal] = true;

                        } catch (JSONException e) {
                            Log.i("izuzeci", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred

                        //mCLayout not defined!!!
                        if(mCLayout!=null)
                        {
                            Snackbar.make(
                                    mCLayout,
                                    "Error...",
                                    Snackbar.LENGTH_LONG
                            ).show();
                        }


                    }
                }
        );

        String requestTag = "testimonial" + fragmentIndexForRefresh;
        mRequestQueue.cancelAll(requestTag);
        jsonArrayRequest.setTag(requestTag);
        mRequestQueue.add(jsonArrayRequest);
    }



    boolean[] SucsesfullyEnteredFragmentInDBForIndex =  {false, false,false, false,false, false};
    boolean[] SucsesfullyEnteredTestimonialsInDBForIndex =  {false, false,false, false,false, false};



    private void parseJsonArray(String url, final int fragmentIndexForRefresh) {


        if(SucsesfullyEnteredFragmentInDBForIndex[fragmentIndexForRefresh])
        {
            RefreshAppropriateFragment(fragmentIndexForRefresh);
            return;
        }

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String id = jsonObject.getString("id");

                                String date = jsonObject.getString("date");

                                String date_gmt = jsonObject.getString("date_gmt");

                                JSONObject guid_object = jsonObject.getJSONObject("guid");
                                String guid_rendered = guid_object.getString("rendered");

                                String modified = jsonObject.getString("modified");
                                String modified_gmt = jsonObject.getString("modified_gmt");
                                String slug = jsonObject.getString("slug");
                                String status = jsonObject.getString("status");
                                String type = jsonObject.getString("type");
                                String link = jsonObject.getString("link");

                                JSONObject title_object = jsonObject.getJSONObject("title");
                                String title_rendered = title_object.getString("rendered");
                                title_rendered = title_rendered.replaceAll("[^a-z A-Z]", "");


                                JSONObject content_object = jsonObject.getJSONObject("content");

                                String content_rendered = content_object.getString("rendered");

                                //  String content_rendered_text = html2text(content_rendered);
                                // String content_rendered_text = content_rendered;


                                String author = jsonObject.getString("author");
                                String featured_media = jsonObject.getString("featured_media");
                                String template = jsonObject.getString("template");

                                //pristup acf objektu
                                JSONObject acf_object = jsonObject.getJSONObject("acf");

                                String acf_android_app_url = acf_object.getString("android_app_url");
                                String acf_ipone_app_url = acf_object.getString("iphone_app_url");
                                String acf_amazon_app_url = acf_object.getString("amazon_app_url");
                                String acf_windows_phone_app_url = acf_object.getString("windows_phone_app_url");
                                String acf_video_link = acf_object.getString("video_link");
                                String acf_social_fb_url = acf_object.getString("social_facebook_url");
                                String acf_press_kit_url = acf_object.getString("press_kit_url");
                                String acf_app_icon = acf_object.getString("app_icon");
                                String acf_stream_app_url = acf_object.getString("steam_app_url");
                                String acf_printable_pdf = acf_object.getString("printable_pdf");


                                String acf_game_price = acf_object.getString("game_price");
                                String acf_game_wallpaper = acf_object.getString("game_wallpapers");
                                String acf_promo_text = acf_object.getString("promo_text");

                                String featured_image = jsonObject.getString("featured_image");
                                String app_icon = jsonObject.getString("app_icon_image");

                                JSONObject screenshoot_images_object = jsonObject.getJSONObject("screenshot_images");

                                JSONObject jsonObjectScreenshoot1 = screenshoot_images_object.getJSONObject("screenshot_1");

                                String full1 = "";
                                String medium1 = "";

                                if (!jsonObjectScreenshoot1.getString("medium").equals("false")) {
                                    full1 = jsonObjectScreenshoot1.getString("full");
                                    medium1 = jsonObjectScreenshoot1.getString("medium");
                                }

                                String full2 = "";
                                String medium2 = "";
                                JSONObject jsonObjectScreenshoot2 = screenshoot_images_object.getJSONObject("screenshot_2");
                                jsonObjectScreenshoot2.getString("full");
                                jsonObjectScreenshoot2.getString("medium");
                                if (!jsonObjectScreenshoot2.getString("medium").equals("false")) {
                                    full2 = jsonObjectScreenshoot2.getString("full");
                                    medium2 = jsonObjectScreenshoot2.getString("medium");
                                }


                                String full3 = "";
                                String medium3 = "";
                                JSONObject jsonObjectScreenshoot3 = screenshoot_images_object.getJSONObject("screenshot_3");
                                jsonObjectScreenshoot3.getString("full");
                                jsonObjectScreenshoot3.getString("medium");
                                if (!jsonObjectScreenshoot3.getString("medium").equals("false")) {
                                    full3 = jsonObjectScreenshoot3.getString("full");
                                    medium3 = jsonObjectScreenshoot3.getString("medium");
                                }


                                String full4 = "";
                                String medium4 = "";
                                JSONObject jsonObjectScreenshoot4 = screenshoot_images_object.getJSONObject("screenshot_4");
                                jsonObjectScreenshoot4.getString("full");
                                jsonObjectScreenshoot4.getString("medium");
                                if (!jsonObjectScreenshoot4.getString("medium").equals("false")) {
                                    full4 = jsonObjectScreenshoot4.getString("full");
                                    medium4 = jsonObjectScreenshoot4.getString("medium");
                                }


                                String full5 = "";
                                String medium5 = "";
                                JSONObject jsonObjectScreenshoot5 = screenshoot_images_object.getJSONObject("screenshot_5");
                                jsonObjectScreenshoot5.getString("full");
                                jsonObjectScreenshoot5.getString("medium");

                                if (!jsonObjectScreenshoot5.getString("medium").equals("false")) {
                                    full5 = jsonObjectScreenshoot5.getString("full");
                                    medium5 = jsonObjectScreenshoot5.getString("medium");

                                }
                                JSONObject jsonObjectScreenshoot6 = screenshoot_images_object.getJSONObject("screenshot_6");
                                jsonObjectScreenshoot6.getString("full");
                                jsonObjectScreenshoot6.getString("medium");

                                String full6 = "";
                                String medium6 = "";
                                if (!jsonObjectScreenshoot6.getString("medium").equals("false")) {
                                    full6 = jsonObjectScreenshoot6.getString("full");
                                    medium6 = jsonObjectScreenshoot6.getString("medium");
                                }

                                String full7 = "";
                                String medium7 = "";

                                JSONObject jsonObjectScreenshoot7 = screenshoot_images_object.getJSONObject("screenshot_7");
                                if (!jsonObjectScreenshoot7.getString("medium").equals("false")) {
                                    full7 = jsonObjectScreenshoot7.getString("full");
                                    medium7 = jsonObjectScreenshoot7.getString("medium");
                                }

                                String full8 = "";
                                String medium8 = "";

                                JSONObject jsonObjectScreenshoot8 = screenshoot_images_object.getJSONObject("screenshot_8");
                                if (!jsonObjectScreenshoot7.getString("medium").equals("false")) {

                                    full8 = jsonObjectScreenshoot8.getString("full");
                                    medium8 = jsonObjectScreenshoot8.getString("medium");

                                }


                                result.add(new GameItemSingle(id, date, date_gmt, guid_rendered, modified, modified_gmt, slug, status, type, link, content_rendered,
                                        title_rendered, author, featured_media, template, acf_android_app_url, acf_ipone_app_url, acf_amazon_app_url, acf_windows_phone_app_url,
                                        acf_video_link, acf_social_fb_url, acf_press_kit_url, acf_app_icon, acf_stream_app_url, acf_printable_pdf, acf_game_price, acf_game_wallpaper, acf_promo_text,
                                        featured_image, app_icon, medium1, medium2, medium3, medium4, medium5, medium6, medium7, medium8, full1, full2, full3, full4, full5, full6, full7, full8));



                            }

                            InsertSingleDataInDB();
                            Log.i("TITLE", result.get(0).getTitle_rendered());


                            SucsesfullyEnteredFragmentInDBForIndex[fragmentIndexForRefresh] = true;

                            RefreshAppropriateFragment(fragmentIndexForRefresh);

                        } catch (JSONException e) {
                            Log.i("izuzeci", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        if(mCLayout!=null)
                        {
                            Snackbar.make(
                                    mCLayout,
                                    "Error...",
                                    Snackbar.LENGTH_LONG
                            ).show();
                        }
                    }
                }
        );

        String requestTag = "testimonial" + fragmentIndexForRefresh;
        mRequestQueue.cancelAll(requestTag);
        jsonArrayRequest.setTag(requestTag);
        mRequestQueue.add(jsonArrayRequest);
    }

    private void RefreshAppropriateFragment(int fragmentIndexForRefresh)
    {
        switch(fragmentIndexForRefresh)
        {
            case 0:

                RefreshForYouFragment();
                break;
            case 1:

                RefreshVirtualPetGamesFragment();
                break;
            case 2:

                RefreshCasualGamesFragment();
                break;
            case 3:

                RefreshColoringPagesFragment();
                break;
            case 4:

                RefreshQuizGamesFragment();
                break;
            case 5:

                RefreshMathGamesFragment();
                break;

        }
    }


    //Metoda za hendlovanje on click listenera za navigation drawer items
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        Bundle bundle = null;

        switch (item.getItemId()) {

            case R.id.my_apps_and_games:

                tab_layout.getTabAt(0).select();

                break;

            case R.id.virtual_pet_games:

                tab_layout.getTabAt(1).select();

                break;
            case R.id.casual_games:
                tab_layout.getTabAt(2).select();


                break;
            case R.id.quiz_games:
                tab_layout.getTabAt(4).select();

                break;

            case R.id.coloring_pages:
                tab_layout.getTabAt(3).select();

                break;

            case R.id.math_games:
                tab_layout.getTabAt(5).select();

                break;

            case R.id.about:

                fragment = new WebViewDialogFragment();

                bundle = new Bundle();
                bundle.putString("TITLE_TEXT", "About Us");
                bundle.putString("CONTENT_URL", "https://peaksel.com/about-us/");
                fragment.setArguments(bundle);
                FragmentManager fragmentManagerAboutUs = getSupportFragmentManager();
                fragmentManagerAboutUs.beginTransaction().replace(R.id.content_frame1, fragment).addToBackStack(null).commit();

                break;


            case R.id.jobs:

                fragment = new WebViewDialogFragment();

                bundle = new Bundle();
                bundle.putString("TITLE_TEXT", "Jobs");
                bundle.putString("CONTENT_URL", "https://peaksel.com/jobs/");
                fragment.setArguments(bundle);
                FragmentManager fragmentManagerJobs = getSupportFragmentManager();
                fragmentManagerJobs.beginTransaction().replace(R.id.content_frame1, fragment).addToBackStack(null).commit();

                break;


            case R.id.contact_us:


                fragment = new WebViewDialogFragment();

                bundle = new Bundle();
                bundle.putString("TITLE_TEXT", "Contact us");
                bundle.putString("CONTENT_URL", "https://peaksel.com/contact/");
                fragment.setArguments(bundle);
                FragmentManager fragmentManagerContact = getSupportFragmentManager();
                fragmentManagerContact.beginTransaction().replace(R.id.content_frame1, fragment).addToBackStack(null).commit();

                break;

            case R.id.game_publising:

                fragment = new WebViewDialogFragment();
                bundle = new Bundle();
                bundle.putString("TITLE_TEXT", "Game Publishing");
                bundle.putString("CONTENT_URL", "https://peaksel.com/game-publishing/");
                fragment.setArguments(bundle);
                FragmentManager fragmentManagerGamePublising = getSupportFragmentManager();
                fragmentManagerGamePublising.beginTransaction().replace(R.id.content_frame1, fragment).addToBackStack(null).commit();
        }

        mDrawerLayout.closeDrawers();
        return true;
    }

    private void StartFlurryRequest()
    {
        String flurry_newDevices_url = "https://api-metrics.flurry.com/public/v1/data/appUsage/all/company?metrics=newDevices&dateTime=2010-01-01/2050-01-01&token=eyJhbGciOiJIUzI1NiIsImtpZCI6ImZsdXJyeS56dXVsLnByb2Qua2V5c3RvcmUua2V5LjIifQ.eyJpc3MiOiJodHRwczovL3p1dWwuZmx1cnJ5LmNvbTo0NDMvdG9rZW4iLCJpYXQiOjE0OTM5NzI2MzIsImV4cCI6MzMwNTA4ODE0MzIsInN1YiI6IjM5MjAwNCIsImF1ZCI6IjQiLCJ0eXBlIjo0LCJqdGkiOiIxMzU2In0.sQBYZMnE-HCtO2b5oi_6wARsR2FtVlq9DPx_n5S4tMc";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, flurry_newDevices_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            for(int i = 0; i < response.length(); i++){

                                JSONArray rows = response.getJSONArray("rows");

                                String newDevices = rows.getJSONObject(i).getString("newDevices");


                                SendNumberOfUsersToFragment(newDevices);


                            }

                        } catch (JSONException e) {
                            Log.i("izuzeci", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        final String flurry_sessions_url="https://api-metrics.flurry.com/public/v1/data/appUsage/all/company?metrics=sessions&dateTime=2010-01-01/2050-01-01&token=eyJhbGciOiJIUzI1NiIsImtpZCI6ImZsdXJyeS56dXVsLnByb2Qua2V5c3RvcmUua2V5LjIifQ.eyJpc3MiOiJodHRwczovL3p1dWwuZmx1cnJ5LmNvbTo0NDMvdG9rZW4iLCJpYXQiOjE0OTM5NzI2MzIsImV4cCI6MzMwNTA4ODE0MzIsInN1YiI6IjM5MjAwNCIsImF1ZCI6IjQiLCJ0eXBlIjo0LCJqdGkiOiIxMzU2In0.sQBYZMnE-HCtO2b5oi_6wARsR2FtVlq9DPx_n5S4tMc";

        JsonObjectRequest sessionsRequest = new JsonObjectRequest(Request.Method.GET, flurry_sessions_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            for(int i = 0; i < response.length(); i++){

                                JSONArray rows = response.getJSONArray("rows");

                                String sessions = rows.getJSONObject(i).getString("sessions");

                                SendNumberOfSessionsToFragment(sessions);

                            }

                        } catch (JSONException e) {
                            Log.i("izuzeci", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
        mRequestQueue.add(sessionsRequest);
    }




    private void SendNumberOfUsersToFragment(String numOfUsers)
    {


            MyApplication.sharedPreferences.edit().putString(ForYouFragment.FLURRY_NUM_OF_USERS_KEY, numOfUsers).apply();

            try {

//                ((ForYouFragment) listOfFragments[0]).RefreshFlurryData();
                ForYouFragment.forYouFragmentInstance.RefreshFlurryData();
            }
            catch(Exception e)
            {
                Log.i("test_fragment", "Error fired SendNumberOfUsersToFragment--> " + e);
            }

    }

    private void SendNumberOfSessionsToFragment(String numOfSessions)
    {


        MyApplication.sharedPreferences.edit().putString(ForYouFragment.FLURRY_NUM_OF_SESSIONS_KEY, numOfSessions).apply();

        try {

//            ((ForYouFragment) listOfFragments[0]).RefreshFlurryData();
            ForYouFragment.forYouFragmentInstance.RefreshFlurryData();
        }
        catch(Exception e)
        {
            Log.i("test_fragment", "Error fired SendNumberOfSessionsToFragment--> " + e);
        }

    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {

        super.onSaveInstanceState(savedInstanceState);
    }

    public boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }


    public void getNotificationsJson(String url){

     String json;
        try {
            InputStream is = getAssets().open(url);
            int size = is.available();
            byte [] buffer = new byte[size];
            is.read();
            is.close();

            json= new String(buffer,"UTF-8");
            JSONObject jsonObject = new JSONObject(json);

            String name = jsonObject.getString("name");
            String hideFlags = jsonObject.getString("hideFlags");
            String notificationName = jsonObject.getString("notificationName");
            String  xmlIndex = jsonObject.getString("xmlIndex");

            Notification notification = new Notification(name,hideFlags,notificationName,xmlIndex);

            Log.i("naziv_notifikacije",notification.getName());


//            "name": "notification 22",
//                    "hideFlags": 0,
//                    "notificationName": "World_Bee_Day",
//                    "xmlIndex": 22,
            Log.i("nameeeeee",name);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("notification0.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
