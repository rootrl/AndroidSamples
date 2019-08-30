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
        Intent intent = new Intent(this, RecyclerViewActivity.class);

        startActivity(intent);
    }

    // Click to ConstraintLayout
    public void constraintLayout(View view) {
        navToActivity(this, ConstraintLayoutActivity.class);
    }

    protected void navToActivity(Context context, Class<?> cls)
    {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

}
