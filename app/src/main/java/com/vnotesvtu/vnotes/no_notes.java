package com.vnotesvtu.vnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;


public class no_notes extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_notes);
        lottieAnimationView = findViewById(R.id.no_notes);
        lottieAnimationView.setAnimation(R.raw.rocket);
        lottieAnimationView.playAnimation();
    }
}