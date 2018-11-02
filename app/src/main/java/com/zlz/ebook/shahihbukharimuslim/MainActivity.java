package com.zlz.ebook.shahihbukharimuslim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.zlz.ebook.shahihbukharimuslim.syarah.SyarahActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final Context context = this;
    GridView gridView;
    ArrayList<GridItem> gridArray = new ArrayList<>();
    CustomGridAdapter customGridAdapter;
    private CardView DaftarIsi, Search, Keterangan, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DaftarIsi = (CardView) findViewById(R.id.btnDaftarIsi) ;
        Search = (CardView) findViewById(R.id.btnSearch) ;
        Keterangan = (CardView) findViewById(R.id.btnKeterangan) ;
        About = (CardView) findViewById(R.id.btnAbout) ;

        DaftarIsi.setOnClickListener(this);
        Search.setOnClickListener(this);
        Keterangan.setOnClickListener(this);
        About.setOnClickListener(this);




//mainMenu();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Silahkan Download E-Book Shahih Bukhari Muslim di playstore : \n" +
                        "https://play.google.com/store/apps/details?id=com.zlz.ebook.shahihbukhari muslim ||www.everyzalz.blogspot.com");
                startActivity(Intent.createChooser(share, "Bagikan Link.."));
                Snackbar.make(view, "Bagikan Link..", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    private void mainMenu() {
//        if (getIntent().getBooleanExtra("EXIT", false) == true) {
//            finish();
//
//        }
//
//        // set grid view item
//
//        Bitmap undanganIcon = BitmapFactory.decodeResource(this.getResources(),
//                R.drawable.ic_invit);
//        Bitmap undanganIcon2 = BitmapFactory.decodeResource(this.getResources(),
//                R.drawable.ic_invit);
//        Bitmap exitIcon = BitmapFactory.decodeResource(this.getResources(),
//                R.drawable.ic_share);
//        Bitmap aboutIcon = BitmapFactory.decodeResource(this.getResources(),
//                R.drawable.ic_power);
//
//
//        gridArray.add(new GridItem(undanganIcon, "Daftar Isi"));
//        gridArray.add(new GridItem(undanganIcon2, "About"));
//        gridArray.add(new GridItem(exitIcon, "Share"));
//        gridArray.add(new GridItem(aboutIcon, "Exit"));
//
//        gridView = (GridView) findViewById(R.id.grid_menu);
//        customGridAdapter = new CustomGridAdapter(this, R.layout.grid_row,
//                gridArray);
//
//        gridView.setAdapter(customGridAdapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//                                    long arg3) {
//
//                if (gridArray.get(arg2).getTitle().toString()
//                        .equals("Daftar Isi")
//                        ) {
//                    // Toast.makeText(getApplicationContext(),
//                    // "VIEW : " + gridArray.get(arg2).getTitle(),
//                    // Toast.LENGTH_SHORT).show();
//                    Intent Home = new Intent(getApplicationContext(),
//                           BookActivity.class);
//                    startActivity(Home);
//
////                } else if (gridArray.get(arg2).getTitle().toString()
////                        .equals("Chat Room")) {
////                    // Toast.makeText(getApplicationContext(),
////                    // "VIEW : " + gridArray.get(arg2).getTitle(),
////                    // Toast.LENGTH_SHORT).show();
////                    Intent Chat = new Intent(getApplicationContext(),
////                            ChatActivity.class);
////
////                    // askPermission(Manifest.permission.MAPS_RECEIVE, requestCode);
////                    startActivity(Chat);
//                } else if (gridArray.get(arg2).getTitle().toString()
//                        .equals("About")) {
//                    final Dialog dialog = new Dialog(context);
//                    dialog.setContentView(R.layout.about);
//                    dialog.setTitle("About Apps");
//
//                    // set the custom dialog components - text, image and button
//                    TextView text = (TextView) dialog.findViewById(R.id.text);
//                    text.setGravity(Gravity.CENTER);
//                    text.setText("\n" +
//                            "\n" +
//                            "www.everyzalz.blogspot.com\n" +
//                            "\n" +
//                            "-zalzondabuzz-\n" +
//                            "2018" +
//                            "\n" +
//                            "\n"
//                    );
//
//                    dialog.show();
//
//                } else if (gridArray.get(arg2).getTitle().toString()
//                        .equals("Share")) {
//                    // Toast.makeText(getApplicationContext(),
//                    // "VIEW : " + gridArray.get(arg2).getTitle(),
//                    // Toast.LENGTH_SHORT).show();
//                    Intent share = new Intent(Intent.ACTION_SEND);
//                    share.setType("text/plain");
//                    share.putExtra(Intent.EXTRA_TEXT, "Download E-Book Shahih Bukhari Muslim di playstore : \n" +
//                            "https://play.google.com/store/apps/details?id=com.zlz.ebook.shahihbukharimuslim || www.everyzalz.blogspot.com");
//                    startActivity(Intent.createChooser(share, "Bagikan Link.."));
//
//                } else if (gridArray.get(arg2).getTitle().toString()
//                        .equals("Exit"))
//
//                {
//                    AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
//                    ab.setTitle("Shahih Bukhari Muslim");
//                    ab.setMessage("Apakah anda yakin ingin keluar?");
//                    ab.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                            //if you want to kill app . from other then your main avtivity.(Launcher)
//                            android.os.Process.killProcess(android.os.Process.myPid());
//                            System.exit(1);
//
//                            //if you want to finish just current activity
//
//                            MainActivity.this.finish();
//                        }
//                    });
//                    ab.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    ab.show();
//                }
//            }
//
//
//        });
//    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Shahih Bukhari Muslim");
        ab.setMessage("Apakah anda yakin ingin keluar?");
        ab.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //if you want to kill app . from other then your main avtivity.(Launcher)
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                //if you want to finish just current activity

                MainActivity.this.finish();
            }
        });
        ab.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ab.show();
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.btnDaftarIsi : i = new Intent(this, BookActivity.class);startActivity(i); break;
            case R.id.btnSearch : i = new Intent(this, MainActivity.class);startActivity(i); break;
            case R.id.btnKeterangan : i = new Intent(this, SyarahActivity.class);startActivity(i); break;
            case R.id.btnAbout : i = new Intent(this, BookActivity.class);startActivity(i); break;
            default:break;
        }
    }
}
