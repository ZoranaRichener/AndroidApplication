package com.example.ladyzorzy.peakselapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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

public class SimilarGamesAdapter  extends RecyclerView.Adapter<SimilarGamesAdapter.SimilarGamesViewHolder> {

    private Context mContext;
    private ArrayList<GameItemSingle> mSimilarGamesList;


    public SimilarGamesAdapter(Context context, ArrayList<GameItemSingle> SimilarGamesList) {
        mContext = context;
        mSimilarGamesList = SimilarGamesList;
    }

    public SimilarGamesAdapter(ArrayList<GameItemSingle> gameItems)
    {
        mSimilarGamesList = gameItems;
    }

    //public SingleGamesAdapter.SingleGamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    @Override
    public SimilarGamesAdapter.SimilarGamesViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mContext).inflate(R.layout.game_item_home, parent, false);

        final SimilarGamesAdapter.SimilarGamesViewHolder SimilarGamesViewHolder =  new SimilarGamesAdapter.SimilarGamesViewHolder(v);

        SimilarGamesViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String ID = mSimilarGamesList.get(SimilarGamesViewHolder.getAdapterPosition()).get_id();
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                SinglePageFragment singlePageFragment = new SinglePageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("id", ID);
//                 Log.e("onClick",ID );
                singlePageFragment.setArguments(bundle);


                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame1, singlePageFragment).addToBackStack(null).commit();

            }
        });
        return SimilarGamesViewHolder;
    }


    @Override
    public void onBindViewHolder(SimilarGamesAdapter.SimilarGamesViewHolder holder, int position) {

        GameItemSingle currentItem = mSimilarGamesList.get(position);


        String id = currentItem.get_id();
        String title = currentItem.getTitle_rendered();
        String image = currentItem.getApp_icon();


        holder.mTextViewTitle.setText(title);
        holder.mTextViewTitle.setMaxLines(2);
        holder.mTextViewTitle.setEllipsize(TextUtils.TruncateAt.END);


        Picasso.with(mContext).load(image).fit().centerInside().into(holder.mImageViewImage);


    }

    @Override
    public int getItemCount() {
        return mSimilarGamesList.size();
    }

    public class SimilarGamesViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextViewTitle;
        public ImageView mImageViewImage;
        public View mLinearLayout;


        public SimilarGamesViewHolder(View itemView) {
            super(itemView);


            mTextViewTitle = itemView.findViewById(R.id.text_view_title);

            mImageViewImage = itemView.findViewById(R.id.image_view_image);

            mLinearLayout = itemView.findViewById(R.id.layout_home_page);





        }
    }
}



