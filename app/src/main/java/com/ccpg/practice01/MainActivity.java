package com.ccpg.practice01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ccpg.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private List<String> mDatas=new ArrayList<String>();
    private MyRecyclerAdapter recycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        initData();
        recycleAdapter = new MyRecyclerAdapter(MainActivity.this,mDatas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void initData() {
        for (int i=0;i<100;i++){
            mDatas.add("Item"+i);
        }
    }
}
