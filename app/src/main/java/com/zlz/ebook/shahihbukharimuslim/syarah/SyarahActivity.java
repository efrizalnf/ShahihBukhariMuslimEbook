package com.zlz.ebook.shahihbukharimuslim.syarah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zlz.ebook.shahihbukharimuslim.R;

public class SyarahActivity extends AppCompatActivity {
    private View parentView;
    private WebView webView1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_syarah);
        webView1 = (WebView) findViewById(R.id.syarahWebView);
        String summary = "<html><head><title>Title of the document</title></head><body><h1><a href=\"file:///android_asset/syarah_bab1\">LINK</a></h1><h1><a href=\"http://www.google.com/\">Link to GOOGLE.COM</a></h1></body></html>";
        webView1.loadData(summary, "text/html", null);
//        webView1.setWebViewClient(new MyWebViewClient(this));
    }
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        parentView = inflater.inflate(R.layout.fragment_syarah, container, false);
//        WebView mWebView=(WebView)findViewById(R.id.syarahWebView);
//
//        mWebView.loadUrl("file://android_asset/syarah_bab1");
//        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.getSettings().setSaveFormData(true);
//        mWebView.getSettings().setBuiltInZoomControls(true);
//        mWebView.setWebViewClient(new MyWebViewClient());
//        return parentView;
//    }
//    private class MyWebViewClient extends WebViewClient
//    {
//        @Override
//        //show the web page in webview but not in web browser
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl (url);
//            return true;
//        }
//    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        parentView = inflater.inflate(R.layout.fragment_syarah, container, false);
//        //mainMenu();
//        return parentView;
//    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_syarah, container, false);
//    }
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);}
}
