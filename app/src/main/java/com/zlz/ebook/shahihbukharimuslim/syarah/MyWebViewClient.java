package com.zlz.ebook.shahihbukharimuslim.syarah;

import android.content.Context;
import android.content.Intent;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private Context context;

    public MyWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.equals("file:///android_asset/syarah_bab1")){
            Intent i = new Intent(context, SyarahActivity.class);
            context.startActivity(i);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}

