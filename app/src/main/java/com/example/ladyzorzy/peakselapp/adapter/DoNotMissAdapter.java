package com.example.ladyzorzy.peakselapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//Over 5 millions users adapter
public class DoNotMissAdapter extends RecyclerView.Adapter<DoNotMissAdapter.DoNotMissViewHolder > {


    private Context mContext;
    private ArrayList<GamesItemHome> mDoNotMissGamesList;


    public DoNotMissAdapter(Context context, ArrayList<GamesItemHome> DoNotMissGamesList) {
        mContext = context;
        mDoNotMissGamesList = DoNotMissGamesList;
    }

    public DoNotMissAdapter(ArrayList<GamesItemHome> gameItems)
    {

        mDoNotMissGamesList = gameItems;
    }


    @Override
    public DoNotMissAdapter.DoNotMissViewHolder  onCreateViewHolder(final ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mContext).inflate(R.layout.do_not_miss_game_item, parent, false);

        final DoNotMissAdapter.DoNotMissViewHolder  virtualPetGamesViewHolder =  new DoNotMissViewHolder (v);

        virtualPetGamesViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String ID = mDoNotMissGamesList.get(virtualPetGamesViewHolder.getAdapterPosition()).getID();
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                SinglePageFragment singlePageFragment = new SinglePageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("id", ID);
                Log.e("onClick",ID );
                singlePageFragment.setArguments(bundle);


                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame1, singlePageFragment).addToBackStack(null).commit();

            }
        });
        return virtualPetGamesViewHolder;
    }


    @Override
    public void onBindViewHolder(DoNotMissAdapter.DoNotMissViewHolder holder, int position) {


        GamesItemHome currentItem = mDoNotMissGamesList.get(position);

        String title = currentItem.getTitle();
        String category = currentItem.getCategory();
        String id = currentItem.getID();

        String featured_image = currentItem.getFeautred_image();

        String image = currentItem.getImage();

        holder.mTextViewTitle.setText(title);
        holder.mTextViewTitle.setMaxLines(1);

        holder.getmTextViewCategory.setText(category);

        Picasso.with(mContext).load(featured_image).fit().centerInside().into(holder.mImageViewFeaturedImage);

        Picasso.with(mContext).load(image).fit().centerInside().into(holder.mImageViewIcon);


    }

    @Override
    public int getItemCount() {
        return mDoNotMissGamesList.size();
    }

    public class DoNotMissViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextViewTitle;
        public TextView getmTextViewCategory;
        public ImageView mImageViewFeaturedImage;
        public ImageView mImageViewIcon;
        public View mLinearLayout;



        public DoNotMissViewHolder (View itemView) {
            super(itemView);


            mTextViewTitle = itemView.findViewById(R.id.textViewTitle);
            getmTextViewCategory = itemView.findViewById(R.id.textViewCategory);
            mImageViewFeaturedImage = itemView.findViewById(R.id.image_view_featured_image);
            mImageViewIcon = itemView.findViewById(R.id.mImageViewIcon);
            mLinearLayout = itemView.findViewById(R.id.linear_layout_over_5_millions);



        }
    }
}




