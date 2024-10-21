package com.android.restoransiparis;

import android.app.Application;
import androidx.room.Room;

public class RestoranSiparisApp extends Application {
    private static RestoranSiparisApp instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "restoran_siparis_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static RestoranSiparisApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}