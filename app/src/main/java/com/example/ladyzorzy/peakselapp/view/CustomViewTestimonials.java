package com.example.ladyzorzy.peakselapp.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;

public class CustomViewTestimonials extends RelativeLayout {

    LayoutInflater mInflater;

    public CustomViewTestimonials(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init();

    }
    public CustomViewTestimonials(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mInflater = LayoutInflater.from(context);
        init();
    }
    public CustomViewTestimonials(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        init();
    }

    TextView titleTxt;
    TextView contentTxt;
    RatingBar ratingBar;

    public void init()
    {

        //  TestimonialsItem currentItem = mTestimonialsList.get(1);

        View v = mInflater.inflate(R.layout.custom_view_testimonials, this, true);
       // CardView card_view_testimonials = v.findViewById(R.id.card_view_testimonials);
        titleTxt = (TextView) v.findViewById(R.id.textViewAuthor);
        contentTxt = (TextView) v.findViewById(R.id.textViewContent) ;
        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar2) ;


    }

    public void SetTitle(String titleText)
    {

        titleTxt.setText(titleText);
    }
    public void SetContent(String contentText)
    {

        contentTxt.setText(contentText);
    }

    public void SetRating(float ratingFloat)
    {

        ratingBar.setRating(ratingFloat);
    }
}
