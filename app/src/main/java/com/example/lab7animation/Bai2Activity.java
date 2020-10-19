package com.example.lab7animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai2Activity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        imageView = findViewById(R.id.imageView2);
    }

    public void showAll(View view) {
        showImage("All");
    }

    public void showDoraemon(View view) {
        showImage("Doraemon");
    }

    public void showNobita(View view) {
        showImage("Nobita");
    }

    public void showImage(String img) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", -150f, 150f);
        animator.setDuration(2000);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
        animator.setDuration(2000);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", -150f, 150f);
        animator.setDuration(2000);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f);
        animator.setDuration(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator2).with(animator3).after(animator).after(animator1);
        animatorSet.start();

        final  String imgName = img;
        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (imgName == "All") {
                    imageView.setImageResource(R.drawable.all);
                }
                if (imgName == "Nobita") {
                    imageView.setImageResource(R.drawable.nobita);
                }
                if (imgName == "Doraemon") {
                    imageView.setImageResource(R.drawable.doraemon);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}