package com.shreedakumar.flashychef.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Option {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "option_name")
    public String optionName;

    @ColumnInfo(name = "cuisine")
    public String cuisine;

    @ColumnInfo(name = "category")
    public String category;
}
