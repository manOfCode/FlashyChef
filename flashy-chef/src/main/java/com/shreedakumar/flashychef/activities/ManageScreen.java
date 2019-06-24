package com.shreedakumar.flashychef.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.shreedakumar.flashychef.R;
import com.shreedakumar.flashychef.utils.ManageOptionsAdapter;

import java.util.Arrays;
import java.util.List;

public class ManageScreen extends AppCompatActivity {

    private TextView mTextMessage;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager layoutManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(ManageScreen.this, HomeScreen.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_manage:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_screen);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.manage_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // Ugly workaround to make the selection stick for ManageScreen
        navigation.getMenu().getItem(1).setChecked(true);

        List<String> options = Arrays.asList(getResources().getStringArray(R.array.breakfasts));
        recyclerView = (RecyclerView) findViewById(R.id.options_recycle);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        mAdapter = new ManageOptionsAdapter(options);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Shreeda","ManageScreen onStart complete");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Shreeda","ManageScreen onStop complete");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Shreeda","ManageScreen onDestroy complete");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Shreeda","ManageScreen onResume complete");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("Shreeda","ManageScreen onSaveInstanceState complete");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i("Shreeda","ManageScreen onRestoreInstanceState complete");
    }
}
