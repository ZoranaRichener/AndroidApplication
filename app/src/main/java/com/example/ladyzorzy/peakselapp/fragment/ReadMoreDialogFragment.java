package com.example.ladyzorzy.peakselapp.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;


public class ReadMoreDialogFragment extends DialogFragment {

    private String  content_text;
    public String title_text;
    private TextView textView_content;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

        Bundle bundle = getArguments();
        if(bundle != null)
        {
            content_text = bundle.getString("CONTENT_TEXT");
            title_text = bundle.getString("TITLE_TEXT");


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_more_dialog, container, false);

        Toolbar toolbar = v.findViewById(R.id.toolbar_read_more);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setTitle(title_text);




        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });

        textView_content = v.findViewById(R.id.text_view_read_more);
       // textView_content.setText(Html.fromHtml(content_text,TextView.BufferType.SPANNABLE));

        textView_content.setText(Html.fromHtml(content_text), TextView.BufferType.SPANNABLE);

        //textView_content.setText(content_text);



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