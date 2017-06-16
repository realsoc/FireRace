package com.example.realsoc.firerace.model;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.realsoc.firerace.R;
import com.example.realsoc.firerace.Utils;

import java.util.Locale;
/**
 * Created by realsoc on 16/06/17.
 */
// From https://stackoverflow.com/questions/35086289/android-textview-counter-with-top-down-animation
    // Class for the Counter view, modify number with an animation
public class CounterView extends FrameLayout{
    private static int ANIMATION_START = 20;//até 1000
    private static int ANIMATION_RANGE = 20;
    private static int ANIMATION_ACCELERATION = 4;

    TextView currentTextView, nextTextView;
    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CounterView(Context context) {
        super(context);
        init(context);
    }
    // Creates and zera the counter
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.counter_layout, this);
        currentTextView = (TextView) getRootView().findViewById(R.id.currentTextView);
        nextTextView = (TextView) getRootView().findViewById(R.id.nextTextView);

        nextTextView.setTranslationY(getHeight());
         setValue(0);
    }
    // Modify value
    public void setValue(final int desiredValue) {
        if (currentTextView.getText() == null || currentTextView.getText().length() == 0) {
            currentTextView.setText(String.format(Locale.getDefault(), "%d", desiredValue));
        }

        final int oldValue = Integer.parseInt(currentTextView.getText().toString());
        long animationDuration = Utils.getCurrentAnimationDuration(ANIMATION_START,oldValue,desiredValue,ANIMATION_RANGE,ANIMATION_ACCELERATION);

        if (oldValue > desiredValue) {
            nextTextView.setText(String.format(Locale.getDefault(), "%d", oldValue-1));
            currentTextView.animate().translationY(-getHeight()).setDuration(animationDuration).start();
            nextTextView.setTranslationY(nextTextView.getHeight());
            Log.d("COUNTER_VIEW",String.valueOf(animationDuration));
            nextTextView.animate().translationY(0).setDuration(animationDuration).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {}
                @Override
                public void onAnimationEnd(Animator animation) {
                    currentTextView.setText(String.format(Locale.getDefault(), "%d", oldValue - 1));
                    currentTextView.setTranslationY(0);
                    if (oldValue - 1 != desiredValue) {
                        setValue(desiredValue);
                    }
                }
                @Override
                public void onAnimationCancel(Animator animation) {}
                @Override
                public void onAnimationRepeat(Animator animation) {}
            }).start();
        } else if (oldValue < desiredValue) {
            nextTextView.setText(String.format(Locale.getDefault(), "%d", oldValue+1));
            currentTextView.animate().translationY(getHeight()).setDuration(animationDuration).setInterpolator(new DecelerateInterpolator()).start();
            nextTextView.setTranslationY(-nextTextView.getHeight());
            nextTextView.animate().translationY(0).setDuration(animationDuration).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {}
                @Override
                public void onAnimationEnd(Animator animation) {
                    currentTextView.setText(String.format(Locale.getDefault(), "%d", oldValue + 1));
                    currentTextView.setTranslationY(0);
                    if (oldValue + 1 != desiredValue) {
                        setValue(desiredValue);
                    }
                }
                @Override
                public void onAnimationCancel(Animator animation) {}
                @Override
                public void onAnimationRepeat(Animator animation) {}
            }).start();
        }
    }
}
