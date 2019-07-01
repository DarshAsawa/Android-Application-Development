package com.example.falsecall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay=findViewById(R.id.tvDisplay);
        if (getIntent().getData() !=null){
            tvDisplay.setText(getIntent().getData().toString());
        }
        else
        {
            tvDisplay.setText("NO DATA RECIEVED");
        }
    }
}
