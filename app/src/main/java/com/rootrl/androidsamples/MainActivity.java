package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.e("TAG", "Max memory is " + maxMemory + "KB");

        String androidId = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Log.e("OnMain", "onCreate: " + androidId );

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

    // Click to HttpRequest
    public void httpRequestActivity(View view) {
        navToActivity(this, HttpRequestActivity.class);
    }

    // Click to ViewPager
    public void bannerActivity(View view) {
        navToActivity(this, BannerActivity.class);
    }

    // Click to immersion model
    public void immersionActivity(View view) {
        navToActivity(this, ImmertionActivity.class);
    }

    public void switchViewActivity(View view) {
        navToActivity(this, SwitchViewActivity.class);
    }

    protected void navToActivity(Context context, Class<?> cls)
    {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

}
