package com.zlz.ebook.shahihbukharimuslim;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DescriptionActivity extends AppCompatActivity {

//    private WebView simpleWebView;
//
//    private static final String TAG = "DescriptionActivity";
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_description);
//
//
//        simpleWebView =(WebView) findViewById(R.id.desWebView);
//        simpleWebView.setWebViewClient(new WebViewClient());
//
//
//        Bundle extras = getIntent().getExtras();
//
//        if (!extras.equals(null)){
//
//            String data = extras.getString("titles");
//
//            Log.e(TAG, "onCreate: the data is "+data);
//
//
//
//
//
//            String url = "file:///android_asset/"+data+".html";
//
//            simpleWebView.loadUrl(url);
//
//        }
//
//        WebSettings webSettings = simpleWebView.getSettings();
//
//        webSettings.setBuiltInZoomControls(true);
//
//        webSettings.setDisplayZoomControls(false);
//
//        webSettings.setJavaScriptEnabled(true);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (simpleWebView.canGoBack()){
//
//            simpleWebView.goBack();
//        }
//
//        else {
//
//            super.onBackPressed();
//        }
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_description);
//        loadFragment(new FragmentHome());
    //Menampilkan halaman Fragment yang pertama kali muncul
    getFragmentPage(new MenuFragment());

    /*Inisialisasi BottomNavigationView beserta listenernya untuk
     *menangkap setiap kejadian saat salah satu menu item diklik
     */
    BottomNavigationView bottomNavigation = findViewById(R.id.navigation);
    bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            //Menantukan halaman Fragment yang akan tampil
            switch (item.getItemId()){
                case R.id.menu_home:
                    fragment = new MenuFragment();
                    break;

                case R.id.menu_syarah:
//                    fragment = new SyarahActivity();
                    break;

                case R.id.menu_keterangan:
                    fragment = new MenuFragment();
                    break;

            }
            return getFragmentPage(fragment);
        }
    });
}

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}