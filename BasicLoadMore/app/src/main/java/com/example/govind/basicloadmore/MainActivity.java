package com.example.govind.basicloadmore;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.govind.techie.Adapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;
    Adapter adapter;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    ArrayList list;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        manager = new LinearLayoutManager(this);

        String[] a =  {"25", "91", "65", "4", "60", "67", "56", "1", "80", "38", "29", "97", "11", "71", "59"};
        list = new ArrayList(Arrays.asList(a));

        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    fetchData();
                }
            }
        });
    }

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                for(int i=0;i<5;i++)
                {
                    list.add(Math.floor(Math.random()*100) + "");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 5000);
    }
}