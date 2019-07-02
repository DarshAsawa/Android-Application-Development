package com.example.fragmentrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    TextView tvName,tvTelephone;
    EditText etName,etTelephone;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName=findViewById(R.id.tvName);
        tvTelephone=findViewById(R.id.tvTelephone);

    }

    @Override
    public void OnItemClicked(int index) {
        tvName.setText(MyApplication.people.get(index).getName());
        tvTelephone.setText(MyApplication.people.get(index).getTelNr());
    }
}
