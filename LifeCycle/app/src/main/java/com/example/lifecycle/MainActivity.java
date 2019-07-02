package com.example.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Life Cycle Events","in onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life Cycle Events","in onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life Cycle Events","in onResume()");
   }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life Cycle Events","in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life Cycle Events","in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life Cycle Events","in onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle Events","in onRestart()");
    }
}
