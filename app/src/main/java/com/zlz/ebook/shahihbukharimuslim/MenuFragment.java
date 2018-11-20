package com.zlz.ebook.shahihbukharimuslim;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zlz.ebook.shahihbukharimuslim.syarah.MyWebViewClient;


/**
 * Fragment class for each nav menu item
 */
public class MenuFragment extends Fragment {

    private WebView simpleWebView;

    private static final String TAG = "MenuFragment";
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;

    private View mContent;
    private TextView mTextView;

//    public static Fragment newInstance(String text, int color) {
//        Fragment frag = new MenuFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_TEXT, text);
//        args.putInt(ARG_COLOR, color);
//        frag.setArguments(args);
//        return frag;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        simpleWebView = (WebView) getView().findViewById(R.id.desWebView);
        simpleWebView.setWebViewClient(new WebViewClient());


        Bundle extras = getActivity().getIntent().getExtras();

        if (!extras.equals(null)) {

            String data = extras.getString("titles");
            Log.e(TAG, "onCreate: the data is " + data);
            String url = "file:///android_asset/" + data + ".html";
            String summary = "<p><a title=\"pijit\" href=\"file:///android_asset/syarah_bab1\">clik</a></p>";
            simpleWebView.setWebViewClient(new MyWebViewClient(getActivity()));
            simpleWebView.loadData(summary, "text/html", null);
            simpleWebView.loadUrl(url);
            
            //custom alert for java script
            simpleWebView.setWebChromeClient(new WebChromeClient(){

                public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                    AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                            setTitle("YourAlertTitle").
                            setMessage(message).
                            setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //do nothing
                                }
                            }).create();
                    dialog.show();
                    result.confirm();
                    return true;
                } });

        }

        WebSettings webSettings = simpleWebView.getSettings();

        webSettings.setBuiltInZoomControls(true);

        webSettings.setDisplayZoomControls(false);

        webSettings.setJavaScriptEnabled(true);

}



    //    public class WebAppInterface {
//
//        Context mContext;
//
//        /** Instantiate the interface and set the context */
//        WebAppInterface(Context c) {
//            mContext = c;
//        }
//
//        /** Show a toast from the web page */
//        @JavascriptInterface
//        public void nextScreen(String pro_cat_id) {
//
//            startActivity(new Intent(mContext,
//                    SyarahActivity.class));
//        }}
    public void onBackPressed() {
        if (simpleWebView.canGoBack()) {

            simpleWebView.goBack();
        } else {

            super.getActivity().onBackPressed();
        }
    }

 }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putString(ARG_TEXT, mText);
//        outState.putInt(ARG_COLOR, mColor);
//        super.onSaveInstanceState(outState);
//    }
