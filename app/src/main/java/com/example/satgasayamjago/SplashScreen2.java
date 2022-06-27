package com.example.satgasayamjago;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class SplashScreen2 extends AppCompatActivity {
    VideoView VideoView;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        Handler h = new Handler();
        h.postDelayed(() -> {
            startActivity(new Intent(SplashScreen2.this,
                    MainActivity.class));
            SplashScreen2.this.overridePendingTransition(
                    android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, 8915);

        VideoView = findViewById(R.id.splash2);
        VideoView.setMediaController(null);
        VideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash2));
        VideoView.start();

        TextView ketukan = findViewById(R.id.ketukan);
        ketukan.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreen2.this,MainActivity.class);
            startActivity(intent);
        });
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        ketukan.startAnimation(anim);
    }
}