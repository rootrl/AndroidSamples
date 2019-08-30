package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rootrl.androidsamples.Adapter.RecyclerViewAdapter;
import com.rootrl.androidsamples.Data.DataUtils;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.viewRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new RecyclerViewAdapter(this, DataUtils.getDatas()));
    }
}
