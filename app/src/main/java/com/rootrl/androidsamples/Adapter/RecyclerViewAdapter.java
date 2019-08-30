package com.rootrl.androidsamples.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rootrl.androidsamples.Data.Data;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VH> {

    private List<Data> dataList;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Data> datas) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        this.dataList = datas;
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, android.R.layout.simple_list_item_2, null));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.mTextView.setText(dataList.get(position).getNum());
        if (position % 2 == 0) {
            holder.mDescTextView.setVisibility(View.VISIBLE);
            holder.mDescTextView.setText(dataList.get(position).getTime());
        } else {
            holder.mDescTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView mTextView;
        TextView mDescTextView;

        public VH(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            mDescTextView = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }
}