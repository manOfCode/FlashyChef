package com.shreedakumar.flashychef.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.shreedakumar.flashychef.db.dao.OptionDao;
import com.shreedakumar.flashychef.db.model.Option;

@Database(entities = {Option.class}, version = 1)
public abstract class FlashyDB extends RoomDatabase {

    //https://developer.android.com/training/data-storage/room#java
    public abstract OptionDao OptionDao();
}
