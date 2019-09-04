package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


// This is a sample witch shows how to make a http request and parse the response data with json struct
// package used: okhttp, gson
public class HttpRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);
    }
}
