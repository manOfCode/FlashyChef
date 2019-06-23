package com.shreedakumar.flashychef;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomeScreen extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_manage:
                    Intent intent = new Intent(HomeScreen.this, ManageScreen.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.home_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final CardView card = findViewById(R.id.message_card);
        card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mTextMessage.setText(getBreakfastRecommendation());            }
        });
        final Button button = findViewById(R.id.what_to_do_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mTextMessage.setText(getBreakfastRecommendation());
            }
        });

        Log.i("Shreeda","HomeScreen onCreate complete");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Shreeda","HomeScreen onStart complete");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Shreeda","HomeScreen onStop complete");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Shreeda","HomeScreen onDestroy complete");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Shreeda","HomeScreen onResume complete");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("Shreeda","HomeScreen onSaveInstanceState complete");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i("Shreeda","HomeScreen onRestoreInstanceState complete");
    }

    public String getBreakfastRecommendation() {
        List<String> options = Arrays.asList(getResources().getStringArray(R.array.breakfasts));
        int optionSize = options.size();
        int randomPosition = ThreadLocalRandom.current().nextInt(0, optionSize);
        return options.get(randomPosition);
    }
}
