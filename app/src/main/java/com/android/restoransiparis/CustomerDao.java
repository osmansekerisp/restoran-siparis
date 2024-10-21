package com.android.restoransiparis;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);

    @Query("SELECT * FROM customers ORDER BY name ASC")
    LiveData<List<Customer>> getAllCustomers();

    @Query("SELECT * FROM customers WHERE phoneNumber = :phoneNumber LIMIT 1")
    LiveData<Customer> getCustomerByPhoneNumber(String phoneNumber);
}