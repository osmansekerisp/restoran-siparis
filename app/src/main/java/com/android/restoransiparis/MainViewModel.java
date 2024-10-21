package com.android.restoransiparis;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CustomerDao customerDao;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase db = RestoranSiparisApp.getInstance().getDatabase();
        customerDao = db.customerDao();
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public LiveData<Customer> getCustomerByPhoneNumber(String phoneNumber) {
        return customerDao.getCustomerByPhoneNumber(phoneNumber);
    }

    public void insertCustomer(Customer customer) {
        new Thread(() -> customerDao.insert(customer)).start();
    }
}