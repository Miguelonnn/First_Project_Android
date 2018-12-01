package com.example.mikel.miprimeraaplicacion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MyWebsitesActivity extends MainMenu  {

    protected void onCreate(Bundle savedInstanceState) {
        WebView navigator;
        TextView textView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_websites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        textView = findViewById(R.id.textViewWeb);
        textView.setText(bundle.getString("title"));

        navigator = (WebView) findViewById(R.id.webview1);
        navigator.setWebViewClient(new WebViewClient());
        navigator.getSettings().setJavaScriptEnabled(true);
        navigator.loadUrl(bundle.getString("url"));

    }
}




