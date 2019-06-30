package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.Inet4Address;

public class Details extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPno, etAddress, etWeb;
    ImageView imgSmile, imgNeutral, imgSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        etName = findViewById(R.id.etName);
        etPno = findViewById(R.id.etPno);
        etAddress = findViewById(R.id.etAddress);
        etWeb = findViewById(R.id.etWeb);
        imgSmile = findViewById(R.id.imgSmile);
        imgSad = findViewById(R.id.imgSad);
        imgNeutral = findViewById(R.id.imgNeutral);

        imgSad.setOnClickListener(this);
        imgNeutral.setOnClickListener(this);
        imgSmile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        {
            Intent intent=new Intent();
            intent.putExtra("Name",etName.getText().toString().trim());
            intent.putExtra("Phone",etPno.getText().toString().trim());
            intent.putExtra("Web",etWeb.getText().toString().trim());
            intent.putExtra("Map",etAddress.getText().toString().trim());

            if (view.getId()==R.id.imgSmile){
                intent.putExtra("Mood","Happy");

            }
            else if (view.getId()==R.id.imgNeutral){
                intent.putExtra("Mood","OK");

            }
            else if (view.getId()==R.id.imgSad) {
                intent.putExtra("Mood", "Sad");
            }

            setResult(RESULT_OK,intent);
            Details.this.finish();

        }

    }
}
