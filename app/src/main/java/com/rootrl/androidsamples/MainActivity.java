package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Click to recycleView
    public void recycleView(View view) {

        navToActivity(this, RecyclerViewActivity.class);
    }

    // Click to ConstraintLayout
    public void constraintLayout(View view) {
        navToActivity(this, ConstraintLayoutActivity.class);
    }

    public void viewPagerLayout(View view) {
        navToActivity(this, ViewPagerActivity.class);
    }

    // Click to Demo Activity
    public void demoActivity(View view) {
        navToActivity(this, DemoActivity.class);
    }

    protected void navToActivity(Context context, Class<?> cls)
    {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

}
