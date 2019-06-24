package com.example.loginapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            System.out.println("Message has been delievered. ");
    }
}
