package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.rootrl.androidsamples.Gson.Ads.Ad;
import com.rootrl.androidsamples.Utils.HttpUtil;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


// This is a sample witch shows how to make a http request and convert the response data with json struct
// library used: okhttp, gson
public class HttpRequestActivity extends AppCompatActivity {

    public static final String TAG =  "HttpRequest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        HttpUtil.sendOkHttpRequest("http://45.76.152.173:8080/test", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: =====================" );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onResponse: =======================" );

                String responseText = response.body().string();

                Log.e(TAG, "onResponse: " + responseText );

                // 解析Json
                try {
                    JSONObject jsonObject = new JSONObject(responseText);

                    String weatherContent = jsonObject.toString();

                    Ad ad =  new Gson().fromJson(weatherContent, Ad.class);

                    Log.e(TAG, "onResponse: status" + ad.status );

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
