package com.example.cricketchirps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    TextView tvMessage,tvDisplay;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalc=findViewById(R.id.btnCalc);
        tvMessage=findViewById(R.id.tvMessage);
        tvDisplay=findViewById(R.id.tvDisplay);
        etNumber=findViewById(R.id.etNumber);

        tvDisplay.setVisibility(View.GONE);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter all fields.", Toast.LENGTH_SHORT).show();
                }
                else {
                    int chirps = Integer.parseInt(etNumber.getText().toString().trim());
                   double temp=(chirps/3)+4;
                    tvDisplay.setText("Temperature outside (in celsius): "+temp+" ");
                    tvDisplay.setVisibility(View.VISIBLE);
                }



            }
        });
    }

}
