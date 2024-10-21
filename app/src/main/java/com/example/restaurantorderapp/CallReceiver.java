package com.example.restaurantorderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                handleIncomingCall(context, phoneNumber);
            }
        }
    }

    private void handleIncomingCall(Context context, String phoneNumber) {
        // TODO: Check if the number is in the database
        // If not, show dialog to add new customer
        // If yes, display customer information
        Toast.makeText(context, "Incoming call from: " + phoneNumber, Toast.LENGTH_LONG).show();
    }
}