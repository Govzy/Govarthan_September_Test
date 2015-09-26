package com.kingbell.govarthan_september_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebsiteActivity extends ActionBarActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        wv = (WebView) findViewById(R.id.webView);
        String url = getIntent().getStringExtra("urlA");
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);

    }
}
