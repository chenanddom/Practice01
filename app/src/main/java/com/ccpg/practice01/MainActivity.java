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
        initData();//初始化数据
        recycleAdapter = new MyRecyclerAdapter(MainActivity.this,mDatas);//初始化一个适配器
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);//创建布局管理器
        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置滑动的方向
        recyclerView.setAdapter(recycleAdapter);//设置适配器
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置增加或删除条目的动画
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,LinearLayoutManager.VERTICAL));
    }
    private void initData() {
        for (int i=0;i<100;i++){
            mDatas.add("Item"+i);
        }
    }
}
