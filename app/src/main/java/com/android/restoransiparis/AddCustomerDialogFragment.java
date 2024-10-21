package com.android.restoransiparis;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

public class AddCustomerDialogFragment extends DialogFragment {

    private MainViewModel viewModel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_customer, null);

        EditText editTextName = view.findViewById(R.id.edit_text_name);
        EditText editTextPhone = view.findViewById(R.id.edit_text_phone);
        EditText editTextAddress = view.findViewById(R.id.edit_text_address);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        builder.setView(view)
                .setTitle("Yeni Müşteri Ekle")
                .setPositiveButton("Ekle", (dialog, id) -> {
                    String name = editTextName.getText().toString();
                    String phone = editTextPhone.getText().toString();
                    String address = editTextAddress.getText().toString();
                    Customer newCustomer = new Customer(name, phone, address);
                    viewModel.insertCustomer(newCustomer);
                })
                .setNegativeButton("İptal", (dialog, id) -> {
                    AddCustomerDialogFragment.this.getDialog().cancel();
                });
        return builder.create();
    }
}