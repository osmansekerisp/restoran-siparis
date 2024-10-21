package com.android.restoransiparis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

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
        MainViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(MainViewModel.class);
        viewModel.getCustomerByPhoneNumber(phoneNumber).observe((ViewModelStoreOwner) context, customer -> {
            if (customer != null) {
                // Müşteri bulundu, bilgileri göster
                showCustomerInfo(context, customer);
            } else {
                // Yeni müşteri ekleme diyaloğunu göster
                showAddCustomerDialog(context, phoneNumber);
            }
        });
    }

    private void showCustomerInfo(Context context, Customer customer) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("CUSTOMER_ID", customer.getId());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    private void showAddCustomerDialog(Context context, String phoneNumber) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("NEW_PHONE_NUMBER", phoneNumber);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}