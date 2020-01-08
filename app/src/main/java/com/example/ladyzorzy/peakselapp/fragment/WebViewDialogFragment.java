package com.example.ladyzorzy.peakselapp.fragment;



import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ladyzorzy.peakselapp.R;


public class WebViewDialogFragment extends DialogFragment {

    private String web_content_url;
    public String title_text;
    private WebView webView;

    private ProgressBar progressBar;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);


        Bundle bundle = getArguments();
        if(bundle != null)
        {
            web_content_url = bundle.getString("CONTENT_URL");
            title_text = bundle.getString("TITLE_TEXT");


        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_web_view_dialog, container, false);

        Toolbar toolbar = v.findViewById(R.id.toolbar_read_more);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setTitle(title_text);
        progressBar = v.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
      //  progressBar.setBackgroundColor(R.color.colorAccent);
       // progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
     //   progressBar.getIndeterminateDrawable().setColorFilter(R.color.colorAccent, android.graphics.PorterDuff.Mode.MULTIPLY);



        webView = v.findViewById(R.id.webview);
        webView.setWebViewClient(new myWebClient());
        webView.getSettings().setJavaScriptEnabled(true);
        //----------------------------------------------------------------------------

        //  mWebView.getSettings().setSupportZoom(true);       //Zoom Control on web (You don't need this
        //if ROM supports Multi-Touch
        // mWebView.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by ROM
        webView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(false);

        // Load URL
        webView.loadUrl(web_content_url);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });



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

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

            webView.loadUrl("javascript:(function() { " +
                    "var head = document.getElementsByClassName('stats-footer')[0].style.display='none'; " +
                    "})()");

            webView.loadUrl("javascript:(function() { " +
                    "var head = document.getElementsByClassName('container-fluid footer-bottom')[0].style.display='none'; " +
                    "})()");


            progressBar.setVisibility(View.GONE);



        }
    }

}