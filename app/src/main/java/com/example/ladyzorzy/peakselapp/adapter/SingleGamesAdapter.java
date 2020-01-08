package com.example.ladyzorzy.peakselapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SingleGamesAdapter extends RecyclerView.Adapter<SingleGamesAdapter.SingleGamesViewHolder> {

    private Context mContext;
    private ArrayList<GameItemSingle> mVirtualPetGamesList;


    public SingleGamesAdapter (Context context, ArrayList<GameItemSingle> VirtualPetGamesList) {
        mContext = context;
        mVirtualPetGamesList = VirtualPetGamesList;
    }

    public SingleGamesAdapter (ArrayList<GameItemSingle> gameItems) {
        mVirtualPetGamesList = gameItems;
    }

    @Override
    public SingleGamesAdapter.SingleGamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.single_game_item, parent, false);

        final SingleGamesViewHolder singleGamesViewHolder = new SingleGamesViewHolder(v);

        singleGamesViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String id = mVirtualPetGamesList.get(singleGamesViewHolder.getAdapterPosition()).get_id();
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                SinglePageFragment singlePageFragment = new SinglePageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Log.e("onClick",id );
                singlePageFragment.setArguments(bundle);
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame1, singlePageFragment).addToBackStack(null).commit();

            }
        });
        return singleGamesViewHolder;
    }

    @Override
    public void onBindViewHolder(SingleGamesAdapter.SingleGamesViewHolder holder, int position) {

        GameItemSingle currentItem = mVirtualPetGamesList.get(position);

        String title_rendered = currentItem.getTitle_rendered();
        String app_icon = currentItem.getApp_icon();
        holder.mTextViewTitle.setText(title_rendered);
        holder.mTextViewTitle.setMaxLines(2);
        holder.mTextViewTitle.setEllipsize(TextUtils.TruncateAt.END);
        holder.mTextViewTitle.setText(title_rendered);


        Picasso.with(mContext).load(app_icon).into(holder.mImageViewImage);

        Picasso.with(mContext).load(app_icon).into(holder.mImageViewImage);

    }

    @Override
    public int getItemCount() {
        return mVirtualPetGamesList.size();
    }

    public class SingleGamesViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextViewTitle;
        public ImageView mImageViewImage;

        private View mLinearLayout;



        public SingleGamesViewHolder(View itemView) {
            super(itemView);


            mTextViewTitle = itemView.findViewById(R.id.text_view_title);

            mImageViewImage = itemView.findViewById(R.id.image_view_image);

            mLinearLayout = itemView.findViewById(R.id.linear_layout_single_page);



        }
    }
}