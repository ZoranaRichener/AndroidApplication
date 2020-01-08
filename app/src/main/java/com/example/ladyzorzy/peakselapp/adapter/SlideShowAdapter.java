package com.example.ladyzorzy.peakselapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SlideShowAdapter extends RecyclerView.Adapter<SlideShowAdapter.SlideShowViewHolder > {

    private Context mContext;
    private ArrayList<GamesItemHome> mSlideShowList;


    public SlideShowAdapter(Context context, ArrayList<GamesItemHome> DoNotMissGamesList) {
        mContext = context;
        mSlideShowList = DoNotMissGamesList;
    }

    public SlideShowAdapter(ArrayList<GamesItemHome> gameItems)

    {
        mSlideShowList = gameItems;
    }

    @Override
    public SlideShowAdapter.SlideShowViewHolder  onCreateViewHolder(final ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mContext).inflate(R.layout.slide_show_item, parent, false);

        final SlideShowAdapter.SlideShowViewHolder slideShowViewHolder =  new SlideShowAdapter.SlideShowViewHolder(v);

        slideShowViewHolder.cardViewContainer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String ID = mSlideShowList.get(slideShowViewHolder.getAdapterPosition()).getID();

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                SinglePageFragment singlePageFragment = new SinglePageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("id", ID);

                singlePageFragment.setArguments(bundle);


                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame1, singlePageFragment).addToBackStack(null).commit();

            }
        });
        return slideShowViewHolder;

    }


    @Override
    public void onBindViewHolder(SlideShowAdapter.SlideShowViewHolder holder, int position) {

        GamesItemHome currentItem = mSlideShowList.get(position);
        String id = currentItem.getID();

        String image = currentItem.getFeautred_image();

        Picasso.with(mContext).load(image).fit().centerInside().into(holder.mImageViewImage);

    }

    @Override
    public int getItemCount() {
        return mSlideShowList.size();
    }

    public class SlideShowViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageViewImage;

        public View cardViewContainer;

        public SlideShowViewHolder (View itemView) {
            super(itemView);


            mImageViewImage = itemView.findViewById(R.id.image_view_slide_show_image);
            cardViewContainer = itemView.findViewById(R.id.card_view_slide_show);


        }
    }
}





