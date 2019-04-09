package com.akvelon.myfirstapp.lesson6.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RoomUserInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;

    public abstract UserDao userDao();

    public static AppDatabase getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                instance =
                        Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                                "room_database.db")
                                .fallbackToDestructiveMigration()
                                // Only for tests!!!
                                .allowMainThreadQueries()
                                .build();
            }
        }
        return instance;
    }
}