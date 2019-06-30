package com.example.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvDisplay=findViewById(R.id.tvDisplay);
        String name=getIntent().getStringExtra("data");
        tvDisplay.setText(name.toUpperCase() + " Welcome to Activity 2");
    }
}
