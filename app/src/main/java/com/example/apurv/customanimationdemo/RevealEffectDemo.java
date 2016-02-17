package com.example.apurv.customanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class RevealEffectDemo extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ViewGroup viewGroup;
    private View viewBoxRed;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reveal_effect_demo);
        viewGroup = (ViewGroup) findViewById(R.id.relative_layout_view_group_reveal);
        toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        viewBoxRed = (View) findViewById(R.id.view_box_red_reveal);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hideFromTopRight(viewGroup);
                    //hideFromCenter(viewGroup);
                } else {
                    showFromTopRight(viewGroup);
                    //showFromCenter(viewGroup);
                }

            }
        });
    }

    private void showFromCenter(final ViewGroup view) {
        int x = view.getWidth() / 2;
        int y = view.getHeight() / 2;
        float finalRadius = (float) Math.hypot(x, y);

        Animator animator = ViewAnimationUtils.createCircularReveal(view, x, y, 0, finalRadius);
        animator.setDuration(5000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);
            }
        });
        animator.start();
    }

    private void showFromTopRight(final ViewGroup view) {
        int x = view.getLeft() + view.getRight();
        int y = view.getTop();
        float finalRadius = (float) Math.max(view.getWidth(), view.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(view, x, y, 0, finalRadius);
        //animator.setDuration(5000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);

            }
        });
        animator.start();
    }

    private void hideFromTopRight(final ViewGroup view) {
        int x = view.getLeft() + view.getRight();
        int y = view.getTop();
        float initialRadius = (float) Math.max(view.getWidth(), view.getHeight());
        final Animator animator = ViewAnimationUtils.createCircularReveal(view, x, y, initialRadius, 0);
        //animator.setDuration(5000);
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);

            }


        });

        animator.start();
    }

    private void hideFromCenter(final ViewGroup view) {
        int x = view.getWidth() / 2;
        int y = view.getHeight() / 2;
        float initialRadius = (float) Math.hypot(x, y);

        Animator animator = ViewAnimationUtils.createCircularReveal(view, x, y, initialRadius, 0);
        animator.setDuration(5000);
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        animator.start();
    }

}
