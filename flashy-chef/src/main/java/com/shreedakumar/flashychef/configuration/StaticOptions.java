package com.shreedakumar.flashychef.configuration;

import androidx.appcompat.app.AppCompatActivity;
import com.shreedakumar.flashychef.R;
import com.shreedakumar.flashychef.db.model.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticOptions {

    public static final List<Option> optionList = new ArrayList<Option>();

    public StaticOptions(AppCompatActivity activity) {
        for (String breakfastName : Arrays.asList(activity.getResources().getStringArray(R.array.breakfasts))) {
            optionList.add( new Option(breakfastName, "Breakfast", "Indian"));
        }
    }

    public List<Option> getStaticOptionsList() {
        return optionList;
    }
}
