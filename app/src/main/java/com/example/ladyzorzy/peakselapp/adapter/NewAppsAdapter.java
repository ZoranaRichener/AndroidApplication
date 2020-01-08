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

public class NewAppsAdapter extends RecyclerView.Adapter<NewAppsAdapter.TopAppsViewHolder > {

    private Context mContext;
    private ArrayList<GamesItemHome> mDoNotMissGamesList;


    public NewAppsAdapter(Context context, ArrayList<GamesItemHome> DoNotMissGamesList) {
        mContext = context;
        mDoNotMissGamesList = DoNotMissGamesList;
    }

    public NewAppsAdapter(ArrayList<GamesItemHome> gameItems)
    {
        mDoNotMissGamesList = gameItems;
    }


    @Override
    public NewAppsAdapter.TopAppsViewHolder  onCreateViewHolder(final ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mContext).inflate(R.layout.new_apps_item, parent, false);


        final NewAppsAdapter.TopAppsViewHolder  virtualPetGamesViewHolder =  new NewAppsAdapter.TopAppsViewHolder(v);

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
    public void onBindViewHolder(NewAppsAdapter.TopAppsViewHolder holder, int position) {


        GamesItemHome currentItem = mDoNotMissGamesList.get(position);

        String title = currentItem.getTitle();
        String category= currentItem.getCategory();
        String id = currentItem.getID();
        String image = currentItem.getImage();

        holder.mTextViewTitle.setText(title);
        holder.mTextViewTitle.setMaxLines(2);
        holder.mTextViewTitle.setEllipsize(TextUtils.TruncateAt.END);

        holder.mTextViewCategory.setText(category);
        holder.mTextViewCategory.setMaxLines(1);
        holder.mTextViewCategory.setEllipsize(TextUtils.TruncateAt.END);



        Picasso.with(mContext).load(image).fit().centerInside().into(holder.mImageViewImage);


    }

    @Override
    public int getItemCount() {
        return mDoNotMissGamesList.size();
    }

    public class TopAppsViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextViewTitle;
        public TextView mTextViewCategory;
        public ImageView mImageViewImage;
        public View mLinearLayout;


        public TopAppsViewHolder (View itemView) {
            super(itemView);


            mTextViewTitle = itemView.findViewById(R.id.text_view_top_apps_title);
            mTextViewCategory = itemView.findViewById(R.id.text_view_top_apps_category);
            mImageViewImage = itemView.findViewById(R.id.image_view_top_apps_image);
            mLinearLayout = itemView.findViewById(R.id.linear_layout_new_apps);

        }
    }
}




