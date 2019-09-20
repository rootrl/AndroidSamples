package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rootrl.androidsamples.Banner.BannerAdapter;
import com.rootrl.androidsamples.Banner.BannerView;
import com.rootrl.androidsamples.Banner.BannerViewPager;

public class BannerActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String[] mUrls = {"http://pb9.pstatp.com/origin/24990000d4c26180d691",
            "http://pb9.pstatp.com/origin/1dcf002c646ac321e698",
            "http://pb9.pstatp.com/origin/1dcf002c646ac321e698"};
    private BannerView mBannerView;
    private BannerViewPager mBannerViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        initView();
        setupBannerView();
    }

    private void initView() {
        mBannerView = findViewById(R.id.bannerView);
    }

    private void setupBannerView() {

        mBannerViewPager = mBannerView.getBannerViewPager();

        mBannerView.setAdapter(mBannerAdapter);
        mBannerView.setScrollerDuration(1288);
        mBannerView.startLoop();
    }

    private BannerAdapter mBannerAdapter = new BannerAdapter() {
        @Override
        public View getView(int position, View convertView) {
            ImageView bannerIv;
            if (convertView == null) {
                bannerIv = new ImageView(BannerActivity.this);
                bannerIv.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                bannerIv = (ImageView) convertView;
                Log.d(TAG, "getView: 界面复用" + bannerIv);
            }

            Glide.with(BannerActivity.this).load(mUrls[position]).into(bannerIv);

            return bannerIv;
        }

        @Override
        public int getCount() {
            return mUrls.length;
        }
    };
}
