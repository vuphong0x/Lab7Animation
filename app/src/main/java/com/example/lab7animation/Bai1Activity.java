package com.example.lab7animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Bai1Activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        imageView= findViewById(R.id.imageView);
    }

    public void moving(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "x", 360f);
        animator.setDuration(2000);
        animator.start();
    }

    public void rotation(View view) {
        int dest = 360;
        if (imageView.getRotation() == 360) {
            dest = 0;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", dest);
        animator.setDuration(2000);
        animator.start();
    }

    public void zoom(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        imageView.startAnimation(animation);
    }
}