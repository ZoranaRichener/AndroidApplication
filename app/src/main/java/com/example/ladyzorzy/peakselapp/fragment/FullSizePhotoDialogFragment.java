package com.example.ladyzorzy.peakselapp.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ladyzorzy.peakselapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

public class FullSizePhotoDialogFragment extends DialogFragment {

    private String url_full1;
    private String  url_full2;
    private String  url_full3;
    private String  url_full4;
    private String  url_full5;
    private String  url_full6;
    private String  url_full7;


    private ImageView fullSizeImage1;
    private ImageView FullSizeImage2;
    private ImageView FullSizeImage3;
    private ImageView FullSizeImage4;
    private ImageView FullSizeImage5;
    private ImageView FullSizeImage6;
    private ImageView FullSizeImage7;





    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

        Bundle bundle = getArguments();
        if(bundle != null)
        {
            url_full1 = bundle.getString("FULL1");
            url_full2 = bundle.getString("FULL2");
            url_full3 = bundle.getString("FULL3");
            url_full4 = bundle.getString("FULL4");
            url_full5 = bundle.getString("FULL5");
            url_full6 = bundle.getString("FULL6");
            url_full7 = bundle.getString("FULL7");


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_size_photo_dialog, container, false);

      //  mShimmerViewContainer= v.findViewById(R.id.shimmer_view_container_slide_show);

        fullSizeImage1 = v.findViewById(R.id.full_size_image);
        if(url_full1 != null) {
            Picasso.with(getActivity().getApplicationContext())
                    .load(url_full1)
                    .into(fullSizeImage1);

        } else {
            fullSizeImage1.setVisibility(View.INVISIBLE);
        }

        FullSizeImage2 = v.findViewById(R.id.full_size_image2);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full2)
                .into(FullSizeImage2);

        FullSizeImage3 = v.findViewById(R.id.full_size_image3);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full3)
                .into(FullSizeImage3);

        FullSizeImage4 = v.findViewById(R.id.full_size_image4);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full4)
                .into(FullSizeImage4);

        FullSizeImage5 = v.findViewById(R.id.full_size_image5);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full5)
                .into(FullSizeImage5);
        FullSizeImage6 = v.findViewById(R.id.full_size_image6);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full6)
                .into(FullSizeImage6);

        FullSizeImage7 = v.findViewById(R.id.full_size_image7);
        Picasso.with(getActivity().getApplicationContext())
                .load(url_full7)
                .into(FullSizeImage7);




       // mShimmerViewContainer.stopShimmerAnimation();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

}
