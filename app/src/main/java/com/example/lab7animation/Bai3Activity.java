package com.example.lab7animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai3Activity extends AppCompatActivity {
    ImageView imgHour, imgMinute, imgSecond;
    Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        imgHour = findViewById(R.id.imgHour);
        imgMinute = findViewById(R.id.imgMinute);
        imgSecond = findViewById(R.id.imgSecond);
        btnRun = findViewById(R.id.btnRun);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(imgSecond, "rotation", 0f, 360f);
                animator.setRepeatCount(Animation.INFINITE);
                animator.setDuration(60000);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imgMinute, "rotation", 0f, 360f);
                animator1.setDuration(3600000);
                animator1.setRepeatCount(Animation.INFINITE);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imgHour, "rotation", 0f, 360f);
                animator2.setRepeatCount(Animation.INFINITE);
                animator2.setDuration(43200000);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator1).with(animator).before(animator2);
                animatorSet.start();
            }
        });
    }
}