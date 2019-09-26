package com.rootrl.androidsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class SwitchViewActivity extends AppCompatActivity {

    public final static String TAG = "SwitchViewActivity";

    TextView textView;

    ImageView imageView;

    VideoView videoView;

    View imageContentView;

    // text view
    public static final int VIEW_TYPE_TEXT_VIEW = 1;

    // image view
    public static final int VIEW_TYPE_IMAGE_VIEW = 2;

    // video view
    public static final int VIEW_TYPE_VIDEO_VIEW = 3;

    // 1 textView 2
    public int currentView = VIEW_TYPE_TEXT_VIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_view);

        imageContentView = findViewById(R.id.view);

        textView = findViewById(R.id.textView4);

        imageView = findViewById(R.id.imageView5);

        videoView = findViewById(R.id.videoView2);

        // 禁止弹窗
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mp, int what, int extra) {
                videoView.stopPlayback();
                return true;
            }
        });

        // 设置背景
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoView.setBackgroundColor(Color.TRANSPARENT);

                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            videoView.setBackgroundColor(Color.TRANSPARENT);
                        return true;
                    }
                });
            }
        });

        // 默认界面
        excuteTextView();

        final Handler handler = new Handler();

        Runnable r = new Runnable() {
            @Override
            public void run() {

                dispacheView();

                handler.postDelayed(this, 20000);
            }
        };

        handler.postDelayed(r, 20000);
    }

    protected void dispacheView()
    {
        setAllGone();

        if (currentView == VIEW_TYPE_TEXT_VIEW) {
            excuteImageView();
        } else if (currentView == VIEW_TYPE_IMAGE_VIEW) {
            excuteVoideoView();
        } else {
            excuteTextView();
        }
    }

    // 设置TextView
    protected void excuteTextView() {
        imageContentView.setVisibility(View.VISIBLE);
        textView.setText("This is a new Text");

        currentView = VIEW_TYPE_TEXT_VIEW;

        Log.e(TAG, "excuteTextView: ..." );
    }

    // 设置imageView
    protected void excuteImageView() {
        imageView.setVisibility(View.VISIBLE);

        currentView = VIEW_TYPE_IMAGE_VIEW;

        Log.e(TAG, "excuteImageView: ..." );
    }

    // 设置videoView
    protected void excuteVoideoView() {

        try {
            videoView.setBackgroundColor(Color.BLUE);

            videoView.setVideoPath("https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4");

            videoView.setVisibility(View.VISIBLE);

            videoView.start();

        } catch (Exception e) {
            Log.e(TAG, "excuteVoideoView: Error" );
        }

        currentView = VIEW_TYPE_VIDEO_VIEW;

        Log.e(TAG, "excuteVoideoView: ...." );
    }

    protected void setAllGone() {
        imageContentView.setVisibility(View.GONE);

        videoView.setVisibility(View.GONE);

        imageView.setVisibility(View.GONE);
    }
}
