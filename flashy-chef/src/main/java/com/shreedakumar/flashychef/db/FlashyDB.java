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
import com.shreedakumar.flashychef.utils.ContextProvider;

import java.util.concurrent.Executors;

@Database(entities = {Option.class}, version = 1)
public abstract class FlashyDB extends RoomDatabase {

    private static final String DB_NAME = "flashychef";
    private static volatile FlashyDB instance;

    public abstract OptionDao OptionDao();

    public static synchronized FlashyDB getInstance() {
        if (instance == null) {
            instance = create(ContextProvider.getContext());
        }
        return instance;
    }

    private static FlashyDB create(final Context context) {
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
                        StaticOptions staticOptions = new StaticOptions();
                        getInstance().OptionDao().insertAll(staticOptions.getStaticOptionsList());
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

}
