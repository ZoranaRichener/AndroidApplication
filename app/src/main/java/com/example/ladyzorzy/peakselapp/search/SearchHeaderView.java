package com.example.ladyzorzy.peakselapp.search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;


import com.example.ladyzorzy.peakselapp.R;


public class SearchHeaderView extends RelativeLayout {


    Context context;

    View x_ico;
    View ico_back;

    EditText searchEditText;


    public EditText getEditeText() {
        return searchEditText;
    }


    public interface  SearchHeaderViewInterafce
    {
        void IconBackClicked();
        void EnteredTextChanged(String newText);

    }

    SearchHeaderViewInterafce searchHeaderViewInterafce;

    public void setSearchHeaderViewInterafce(SearchHeaderViewInterafce searchHeaderViewInterafce) {
        this.searchHeaderViewInterafce = searchHeaderViewInterafce;
    }



    public SearchHeaderView(Context context) {
        super(context);

        this.context = context;
        init();

    }

    public SearchHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        init();

    }


    public SearchHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        init();

    }


    private void init()
    {


        View root = View.inflate(context, R.layout.search_header_view, this);


        root.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        x_ico = root.findViewById(R.id.ic_x);


        x_ico.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetSearchText();
            }
        });


        searchEditText = (EditText) root.findViewById(R.id.search_et);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(searchHeaderViewInterafce!=null && editable!=null)
                {

                    searchHeaderViewInterafce.EnteredTextChanged(editable.toString());
                }

            }
        });


        ico_back = root.findViewById(R.id.ic_back);

        ico_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(searchHeaderViewInterafce!=null)
                {

                    searchHeaderViewInterafce.IconBackClicked();
                }
            }
        });


    }

    public void ResetSearchText()
    {
        searchEditText.setText("");
    }





}



