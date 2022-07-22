package com.example.vnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class no_internet extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie);
        lottieAnimationView.setAnimation(R.raw.try_animation);
        lottieAnimationView.playAnimation();
    }
}