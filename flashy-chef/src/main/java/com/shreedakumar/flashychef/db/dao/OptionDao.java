package com.shreedakumar.flashychef.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.shreedakumar.flashychef.db.model.Option;

import java.util.List;

//https://developer.android.com/training/data-storage/room#java
@Dao
public interface OptionDao {


        @Query("SELECT * FROM option")
        List<Option> getAll();

        @Query("SELECT * FROM option WHERE uid IN (:optionIds)")
        List<Option> loadAllByIds(int[] optionIds);

        @Query("SELECT * FROM option WHERE option_name = :optionName " + " LIMIT 1")
        Option findByOption(String optionName);

        @Insert
        void insertAll(Option... options);

        @Insert
        void insertAll(List<Option> options);

        @Delete
        void delete(Option option);

        @Query("DELETE FROM option WHERE option_name = :option")
        void deleteOptionByName(String option);
}