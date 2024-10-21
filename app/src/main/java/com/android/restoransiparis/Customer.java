package com.android.restoransiparis;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers")
public class Customer {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phoneNumber;
    private String address;

    public Customer(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}