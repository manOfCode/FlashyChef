package com.shreedakumar.flashychef.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

//https://developer.android.com/training/data-storage/room#java
public class FlashyDBFactory {
    private static FlashyDB flashyDB = null;
    private static final FlashyDBFactory factoryInstance = new FlashyDBFactory();

    public static FlashyDBFactory getFactoryInstance() {
        return factoryInstance;
    }

    public static FlashyDB getDb(Context context) {
        if (flashyDB != null) {
            return flashyDB;
        } else {
            synchronized (flashyDB) {
                flashyDB = Room.databaseBuilder(context,
                        FlashyDB.class, "flashychef").addCallback(fillData).build();
            }
        }
        return flashyDB;
    }

    private FlashyDBFactory() {
    }


    //https://stackoverflow.com/questions/44697418/how-to-populate-android-room-database-table-on-first-run
    static RoomDatabase.Callback fillData = new RoomDatabase.Callback() {
        public void onCreate (SupportSQLiteDatabase db) {
            // do something after database has been created
        }
        public void onOpen (SupportSQLiteDatabase db) {
            // do something every time database is open
        }
    };
}
