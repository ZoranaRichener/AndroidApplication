package com.example.ladyzorzy.peakselapp.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;
import com.example.ladyzorzy.peakselapp.data.GameItemSingle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>  {

    private Context context;

    private List<GameItemSingle> gameListFiltered;
    private GameAdapterListener listener;

    public void RefreshAdapter(List<GameItemSingle> newList)
    {
        gameListFiltered = newList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, category;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.game_title);
            category = view.findViewById(R.id.game_category);
            thumbnail = view.findViewById(R.id.thumbnail);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected game in callback

                    listener.onGameSelected(gameListFiltered.get(getAdapterPosition()));


                }
            });
        }
    }

    public SearchAdapter(Context context, List<GameItemSingle> contactList, GameAdapterListener listener) {
        this.context = context;
        this.listener = listener;

        this.gameListFiltered = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final GameItemSingle contact = gameListFiltered.get(position);
        holder.title.setText(contact.getTitle_rendered());

        holder.category.setText(contact.get_type().replace("_", " ").substring(0,1).toUpperCase() + contact.get_type().replace("_", " ").substring(1));

        String app_icon = contact.getApp_icon();

        Picasso.with(context).load(app_icon).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return gameListFiltered.size();
    }


    public interface GameAdapterListener {
        void onGameSelected(GameItemSingle contact);

    }
}