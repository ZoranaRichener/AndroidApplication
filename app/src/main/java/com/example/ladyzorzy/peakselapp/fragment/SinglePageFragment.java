package com.example.ladyzorzy.peakselapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.MainActivity;
import com.example.ladyzorzy.peakselapp.MyApplication;
import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.adapter.SimilarGamesAdapter;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.data.TestimonialsItem;
import com.example.ladyzorzy.peakselapp.database.DatabaseHelper;
import com.example.ladyzorzy.peakselapp.view.CustomViewTestimonials;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class SinglePageFragment extends Fragment {

    public static SinglePageFragment singlePageFragmentInstance;


    TextView tvReadMore;
    Button btnInstall;

    TextView textViewTitle;
    TextView textViewCategory;
    ImageView imageViewAppIcon;
    ImageView ivFeaturedImage;
    ImageView screenshootImage1;
    ImageView screenshootImage2;
    ImageView screenshootImage3;
    ImageView screenshootImage4;
    ImageView screenshootImage5;
    ImageView screenshootImage6;
    ImageView screenshootImage7;
    ImageView screenshootImage8;
    TextView tv_promoText;

    GameItemSingle singlePageItem;

    ArrayList<TestimonialsItem> testimonial_items;

    ArrayList<GameItemSingle> similar_games_Items;
    SimilarGamesAdapter mSimilarGamesAdapter;
    RecyclerView mRecyclerView_SimilarGames;

    private CustomViewTestimonials view1;
    private CustomViewTestimonials view2;
    private CustomViewTestimonials view3;

    private String id;
    private String category;
    private String package_name;

    private RecyclerView.LayoutManager layoutManager_SimilarGames;
    private View linear_layout_testimonials;


    ImageView ic_back;
    ImageView ico_search;

    private ShimmerFrameLayout mShimmerViewContainer;

    public SinglePageFragment() {
        // Required empty public constructor
    }


    public static SinglePageFragment newInstance() {
        SinglePageFragment fragment = new SinglePageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_single_page,container, false);

        mShimmerViewContainer = rootView.findViewById(R.id.shimmer_view_container_slide_show);
       // mShimmerViewContainer.startShimmerAnimation();

        ic_back = rootView.findViewById(R.id.ic_back);
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivityInstance.onBackPressed();
            }
        });

        ico_search = rootView.findViewById(R.id.ico_search);
        ico_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivityInstance.IcoSearchClicked();
            }
        });

        return rootView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        singlePageFragmentInstance=this;

        mShimmerViewContainer.startShimmerAnimation();

       // mShimmerViewContainer.setVisibility(View.VISIBLE);
       // mShimmerViewContainer.startShimmerAnimation();


        RefreshFragmentData();


    }


    public void RefreshFragmentData() {

        Context context = getActivity().getApplicationContext();
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");

        }

        textViewTitle = getActivity().findViewById(R.id.text_view_single_page_title);
        textViewCategory = getActivity().findViewById(R.id.text_view_category);
        imageViewAppIcon = getActivity().findViewById(R.id.image_app_icon);
        ivFeaturedImage = getActivity().findViewById(R.id.ivFeaturedImage);
        tv_promoText = getActivity().findViewById(R.id.tvPromoText);
        linear_layout_testimonials= getActivity().findViewById(R.id.linear_layout_testimonials);



        DatabaseHelper database = new DatabaseHelper(getContext());
        singlePageItem = database.getSinglePageData(id);


        category = singlePageItem.get_type().toUpperCase().trim();
        String game_category = singlePageItem.get_type().replace("_", " ");
        String game_category2 = game_category.substring(0, 1).toUpperCase() + game_category.substring(1);

        textViewCategory.setText(game_category2);

        textViewCategory.setMaxLines(2);
        textViewCategory.setEllipsize(TextUtils.TruncateAt.END);

        textViewTitle.setText(singlePageItem.getTitle_rendered());
        textViewTitle.setMaxLines(2);
        textViewTitle.setEllipsize(TextUtils.TruncateAt.END);

        tv_promoText.setText(singlePageItem.getAcf_promo_text());


        Picasso.with(getActivity().getApplicationContext())
                .load(singlePageItem.getApp_icon())
                .into(imageViewAppIcon);

        Picasso.with(getActivity().getApplicationContext())
                .load(singlePageItem.getFeatured_image())
                .into(ivFeaturedImage);

        //TESTIMONIALS CUSTOM VIEW
        view1 = getActivity().findViewById(R.id.my_custom_view);
        view2 = getActivity().findViewById(R.id.my_custom_view1);
        view3 = getActivity().findViewById(R.id.my_custom_view2);


        btnInstall = getActivity().findViewById(R.id.btnInstall);
       // btnInstall.setText("TEST");

        package_name = singlePageItem.getAcf_android_app_url();
       // btnInstall.setText(package_name);


        boolean isAppInstalled = appInstalledOrNot(package_name);

        if(isAppInstalled) {
            //This intent will help you to launch if the package is already installed
            btnInstall.setText("OPEN");
            btnInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = getContext().getPackageManager().getLaunchIntentForPackage(package_name);
                    startActivity(intent);
                }
            });


        } else {
            btnInstall.setText("INSTALL");

            btnInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Log.i("onclickk",singlePageItem.getAcf_android_app_url());
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=" + singlePageItem.getAcf_android_app_url()));
                        startActivity(intent);
                    } catch (Exception e) {

                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" +singlePageItem.getAcf_android_app_url()));
                            startActivity(browserIntent);
                        } catch (Exception e2) {

                        }
                    }
                }
            });

        }



        // SCREENSHOOT IMAGES

        if (!singlePageItem.getScreenshootMedium1().equals("")) {

            screenshootImage1 = getActivity().findViewById(R.id.screenshoot_image_1);
            screenshootImage1.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium1())
                    .into(screenshootImage1);



        screenshootImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();

                b.putString("FULL1",singlePageItem.getScreenshootFull1());

                dialogFragment.setArguments(b);
                Log.i("slika" ,"slika  1 -->" + singlePageItem.getScreenshootMedium1());
                Log.i("full_slika" , "slika  1 -->" +singlePageItem.getScreenshootFull1());
            }
        });

        }

        if (!singlePageItem.getScreenshootMedium2().equals("")) {

            screenshootImage2 = getActivity().findViewById(R.id.screenshoot_image_2);
            screenshootImage2.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium2())
                    .into(screenshootImage2);



        screenshootImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();

                b.putString("FULL2",singlePageItem.getScreenshootFull2());
                dialogFragment.setArguments(b);
                Log.i("slika" , "slika  2 -->" + singlePageItem.getScreenshootMedium2());
                Log.i("full_slika" , "slika  2 -->" +singlePageItem.getScreenshootFull2());
            }
        });

        }

        if (!singlePageItem.getScreenshootMedium3().equals("")) {
            screenshootImage3 = getActivity().findViewById(R.id.screenshoot_image_3);
            screenshootImage3.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium3())
                    .into(screenshootImage3);


        screenshootImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();

                b.putString("FULL3",singlePageItem.getScreenshootFull3());
                dialogFragment.setArguments(b);
                Log.i("slika" , "slika  3 -->" +singlePageItem.getScreenshootMedium3());
                Log.i("full_slika" , "slika  3 -->" +singlePageItem.getScreenshootFull3());

            }
        });

    }

        if (!singlePageItem.getScreenshootMedium4().equals("")) {
            screenshootImage4 = getActivity().findViewById(R.id.screenshoot_image_4);
            screenshootImage4.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium4())
                    .into(screenshootImage4);


        screenshootImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();

                b.putString("FULL4",singlePageItem.getScreenshootFull4());
                dialogFragment.setArguments(b);
                Log.i("slika" , "slika  4 -->" +singlePageItem.getScreenshootMedium4());
                Log.i("full_slika" , "slika  4 -->" +singlePageItem.getScreenshootFull4());
            }
        });

        }

        if (!singlePageItem.getScreenshootMedium5().equals("")) {
            screenshootImage5 = getActivity().findViewById(R.id.screenshoot_image_5);
            screenshootImage5.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium5())
                    .into(screenshootImage5);

        screenshootImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();

                b.putString("FULL5",singlePageItem.getScreenshootFull5());
                dialogFragment.setArguments(b);
                Log.i("slika" ,"slika  5 -->" +singlePageItem.getScreenshootMedium5());
            }
        });

        }

       if (!singlePageItem.getScreenshootMedium6().equals("")) {
            screenshootImage6 = getActivity().findViewById(R.id.screenshoot_image_6);
            screenshootImage6.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium6())
                    .into(screenshootImage6);


        screenshootImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                dialogFragment.show(ft, "dialog");

                Bundle b = new Bundle();
                b.putString("FULL6",singlePageItem.getScreenshootFull6());
                dialogFragment.setArguments(b);
                Log.i("slika" , "slika  6 -->"+singlePageItem.getScreenshootMedium6());
            }
        });

       }

        if (!singlePageItem.getScreenshootMedium7().equals("")) {
            screenshootImage7 = getActivity().findViewById(R.id.screenshoot_image_7);
            screenshootImage7.setVisibility(View.VISIBLE);
            Picasso.with(getActivity().getApplicationContext())
                    .load(singlePageItem.getScreenshootMedium7())
                    .into(screenshootImage7);


            screenshootImage7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    FullSizePhotoDialogFragment dialogFragment = new FullSizePhotoDialogFragment();
                    dialogFragment.show(ft, "dialog");

                    Bundle b = new Bundle();
                    b.putString("FULL7",singlePageItem.getScreenshootFull7());
                    dialogFragment.setArguments(b);
                    Log.i("slika" , "slika 7 -->"+singlePageItem.getScreenshootMedium7());
                }
            });


        }


        //READ MORE
        tvReadMore = (TextView) getActivity().findViewById(R.id.tvReadMore);

        tvReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("read_more_dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                ReadMoreDialogFragment dialogFragment = new ReadMoreDialogFragment();
                dialogFragment.show(ft, "read_more_dialog");

                Bundle b = new Bundle();
                b.putString("TITLE_TEXT",singlePageItem.getTitle_rendered());
                b.putString("CONTENT_TEXT",singlePageItem.getContent_rendered());
                dialogFragment.setArguments(b);
            }
        });


        // SIMILAR GAMES
        mRecyclerView_SimilarGames = getActivity().findViewById(R.id.recycle_similar_games);
        DatabaseHelper databaseSimilarGames = new DatabaseHelper(getContext());
        similar_games_Items = databaseSimilarGames.getGamesByCategory(category);
        mSimilarGamesAdapter = new SimilarGamesAdapter(getContext(),similar_games_Items);
        mRecyclerView_SimilarGames.setHasFixedSize(true);
        mRecyclerView_SimilarGames.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutManager_SimilarGames = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView_SimilarGames.setLayoutManager(layoutManager_SimilarGames);
        mRecyclerView_SimilarGames.setAdapter(mSimilarGamesAdapter);



        try {

            DatabaseHelper databaseTestimonials = new DatabaseHelper(getContext());

            testimonial_items = databaseTestimonials.getAllTestimonialData(Integer.parseInt(id));

            if (testimonial_items.size()> 1) {

                testimonial_items.get(0).getAuthor();

                view1.SetTitle(testimonial_items.get(0).getAuthor());
                view1.SetContent(testimonial_items.get(0).getContent());

                view2.SetTitle(testimonial_items.get(1).getAuthor());
                view2.SetContent(testimonial_items.get(1).getContent());

                view3.SetTitle(testimonial_items.get(2).getAuthor());
                view3.SetContent(testimonial_items.get(2).getContent());

                view1.SetRating(5.0f);
                // view3.setVisibility(View.GONE);

            } else {
                linear_layout_testimonials.setVisibility(View.GONE);

            }
        } catch (Exception e){

        }

        StopShimmer();

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


    private void StopShimmer()
    {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
    }

    public boolean appInstalledOrNot(String uri) {
        PackageManager pm = getContext().getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }

}