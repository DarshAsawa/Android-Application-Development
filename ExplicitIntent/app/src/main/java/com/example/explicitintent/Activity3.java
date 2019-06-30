package com.example.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    Button btnSubmit,btnCancel;
    EditText etSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        btnSubmit=findViewById(R.id.btnSubmit);
        etSurname=findViewById(R.id.etSurname);
        btnCancel=findViewById(R.id.btnCancel);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSurname.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "Enter all fields", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    String Surname=etSurname.getText().toString().trim();
                    Intent intent=new Intent();
                    intent.putExtra("surname",Surname);
                    setResult(RESULT_OK,intent);
                    Activity3.this.finish();


                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_CANCELED,intent);
                Activity3.this.finish();
            }
        });

    }
}
