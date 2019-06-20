package com.example.loginapplication;

import android.view.animation.Animation;

public interface SecondActivityContract {
    public interface View{
        public void initializeListeners();
        public void initializeViews();
        public Animation initializeAnimation();
        public void startGoneAnimation();
    }
}
