package com.ccpg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccpg.practice01.R;

import java.util.List;

/**
 * Created by lenovo on 2017/7/13.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener;
    public MyRecyclerAdapter(Context mContext,List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.inflater = LayoutInflater.from(mContext);
    }
    public interface OnItemClickListener{
        void onClick(int position);
        void onLongClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout. item_home,parent, false);  ;
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.textView.setText(mDatas.get(i));
        if(mOnItemClickListener!=null){
            myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(i);
                }
            });
            myViewHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onLongClick(i);

                    return false;
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
