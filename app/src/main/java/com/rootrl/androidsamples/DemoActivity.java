package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import com.rootrl.androidsamples.Utils.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DemoActivity extends AppCompatActivity {

    public static final String TAG = "DemoActivity";

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Log.e("=== DemoActivity =====", "onCreate: " + getPackageResourcePath() );

        HttpUtil.sendOkHttpRequest("http://www.xueyiwang.vip/index.php/di_landing/userInfoAdd", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: ==========="  );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onResponse: " +  response.body().string());
            }
        });

        // videoView.setVideoPath();
    }
}
