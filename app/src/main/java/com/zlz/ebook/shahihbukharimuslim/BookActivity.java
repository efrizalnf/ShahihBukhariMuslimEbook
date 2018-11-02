package com.zlz.ebook.shahihbukharimuslim;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private Context mContext;

    private ArrayList<String> titleText;

    private RecyclerView mRecyclerView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        mContext = BookActivity.this;

        titleText = new ArrayList<String>();

        titleText.add(Constants.PENDAHULUAN);
        titleText.add(Constants.BAB_I);
        titleText.add(Constants.BAB_II);
        titleText.add(Constants.BAB_III);
        titleText.add(Constants.BAB_IV);
        titleText.add(Constants.BAB_V);
        titleText.add(Constants.BAB_VI);
        titleText.add(Constants.BAB_VII);
        titleText.add(Constants.BAB_VIII);
        titleText.add(Constants.BAB_IX);
        titleText.add(Constants.BAB_X);
        titleText.add(Constants.BAB_XI);
        titleText.add(Constants.BAB_XII);

        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);


        TitleAdapter adapter = new TitleAdapter(mContext, titleText, new MyCustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(mContext, "clicked - "+String.valueOf(titleText.get(position)), Toast.LENGTH_SHORT).show();

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",String.valueOf(titleText.get(position)));

                startActivity(desIntent);

            }
        });

        mRecyclerView.setAdapter(adapter);

    }
}
