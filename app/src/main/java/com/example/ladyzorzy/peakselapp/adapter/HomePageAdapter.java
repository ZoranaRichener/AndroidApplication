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
import com.example.ladyzorzy.peakselapp.data.GamesItemHome;
import com.example.ladyzorzy.peakselapp.fragment.SinglePageFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.VirtualPetGamesViewHolder> {

    private Context mContext;
    private ArrayList<GamesItemHome> mVirtualPetGamesList;


    public HomePageAdapter(Context context, ArrayList<GamesItemHome> VirtualPetGamesList) {
        mContext = context;
        mVirtualPetGamesList = VirtualPetGamesList;
    }

    public HomePageAdapter(ArrayList<GamesItemHome> gameItems)
    {

        mVirtualPetGamesList = gameItems;
    }

    @Override
    public HomePageAdapter.VirtualPetGamesViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mContext).inflate(R.layout.game_item_home, parent, false);

        final VirtualPetGamesViewHolder virtualPetGamesViewHolder =  new VirtualPetGamesViewHolder(v);

        virtualPetGamesViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String ID = mVirtualPetGamesList.get(virtualPetGamesViewHolder.getAdapterPosition()).getID();
                Log.e("id_game", ID);

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                SinglePageFragment singlePageFragment = new SinglePageFragment();

                Bundle bundle = new Bundle();
                bundle.putString("id", ID);
                singlePageFragment.setArguments(bundle);

                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame1, singlePageFragment).addToBackStack(null).commit();

            }
        });
        return virtualPetGamesViewHolder;
    }



    @Override
    public void onBindViewHolder(VirtualPetGamesViewHolder holder, int position) {

        GamesItemHome currentItem = mVirtualPetGamesList.get(position);

        //Log.e("daliimaID", id);
        String title = currentItem.getTitle();
        String image = currentItem.getImage();


        holder.mTextViewTitle.setText(title);
        holder.mTextViewTitle.setMaxLines(2);
        holder.mTextViewTitle.setEllipsize(TextUtils.TruncateAt.END);


        Picasso.with(mContext).load(image).fit().centerInside().into(holder.mImageViewImage);

    }

    @Override
    public int getItemCount() {
        return mVirtualPetGamesList.size();
    }

    public class VirtualPetGamesViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextViewTitle;
        public ImageView mImageViewImage;
        public View mLinearLayout;



        public VirtualPetGamesViewHolder(View itemView) {
            super(itemView);


            mTextViewTitle = itemView.findViewById(R.id.text_view_title);
            mImageViewImage = itemView.findViewById(R.id.image_view_image);
            mLinearLayout = itemView.findViewById(R.id.layout_home_page);



        }
    }
}



