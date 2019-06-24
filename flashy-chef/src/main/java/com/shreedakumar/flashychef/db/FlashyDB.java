package com.shreedakumar.flashychef.db;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.shreedakumar.flashychef.configuration.StaticOptions;
import com.shreedakumar.flashychef.db.dao.OptionDao;
import com.shreedakumar.flashychef.db.model.Option;

import java.util.concurrent.Executors;

//https://developer.android.com/training/data-storage/room#java
// Based on https://android.jlelse.eu/android-architecture-components-room-introduction-4774dd72a1ae
@Database(entities = {Option.class}, version = 1)
public abstract class FlashyDB extends RoomDatabase {

    private static final String DB_NAME = "flashychef";
    private static volatile FlashyDB instance;

    public abstract OptionDao OptionDao();

    public static synchronized FlashyDB getInstance(Context context, AppCompatActivity activity) {
        if (instance == null) {
            instance = create(context, activity);
        }
        return instance;
    }

    private static FlashyDB create(final Context context, final AppCompatActivity activity) {
        Log.i("Shreeda", "Creating DB");
        return Room.databaseBuilder(
                context,
                FlashyDB.class,
                DB_NAME).addCallback(new RoomDatabase.Callback() {
            public void onCreate (SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        StaticOptions staticOptions = new StaticOptions(activity);
                        getInstance(context, activity).OptionDao().insertAll(staticOptions.getStaticOptionsList());
                    }
                });
                Log.i("Shreeda", "Inserted an option on DB create");
            }

            public void onOpen (SupportSQLiteDatabase db) {
                super.onOpen(db);
                Log.i("Shreeda", "Not doing anything on DB open");

            }
        }).allowMainThreadQueries().build();
    }

    //https://stackoverflow.com/questions/44697418/how-to-populate-android-room-database-table-on-first-run
    /*private static RoomDatabase.Callback fillData = new RoomDatabase.Callback() {
        public void onCreate (SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    getInstance(context).OptionDao().insertAll(new Option("NewBreaky", "Breakfast", "Indian"));
                }
            });
            Log.i("Shreeda", "Not doing anything on DB create");
        }

        public void onOpen (SupportSQLiteDatabase db) {
            // do something every time database is open
            *//*Option option = new Option("NewBreaky", "Breakfast", "Indian");
            db.beginTransaction();
            instance.OptionDao().insertAll(option);
            db.endTransaction();*//*
            Log.i("Shreeda", "Inserted an option on DB open");

        }
    };*/
}
