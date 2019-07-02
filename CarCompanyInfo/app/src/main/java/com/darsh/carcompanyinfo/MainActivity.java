package com.darsh.carcompanyinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {
    Button btnCarInfo,btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel,tvName,tvTel;
    FragmentManager fragmentManager;
    Fragment buttonfrag,listfrag,carinfofrag,ownerinfofrag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCarInfo=findViewById(R.id.btnCarInfo);
        btnOwnerInfo=findViewById(R.id.btnOwnerInfo);
        ivMake=findViewById(R.id.ivMake);
        tvModel=findViewById(R.id.tvModel);
        tvTel=findViewById(R.id.tvTel);
        tvName=findViewById(R.id.tvName);

        fragmentManager=getSupportFragmentManager();

        buttonfrag=fragmentManager.findFragmentById(R.id.buttonfrag);
        listfrag=fragmentManager.findFragmentById(R.id.buttonfrag);
        carinfofrag=fragmentManager.findFragmentById(R.id.carinfofrag);
        ownerinfofrag=fragmentManager.findFragmentById(R.id.ownerinfofrag);

        fragmentManager.beginTransaction()
                .show(listfrag)
                .show(carinfofrag)
                .show(buttonfrag)
                .hide(ownerinfofrag)
                .commit();

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carinfofrag)
                        .show(ownerinfofrag)
                        .commit();

            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(carinfofrag)
                        .hide(ownerinfofrag)
                        .commit();
            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(CarApplication.cars.get(index).getOwner());
        tvTel.setText(CarApplication.cars.get(index).getOwner_tel());
        tvModel.setText(CarApplication.cars.get(index).getModel());

        if (CarApplication.cars.get(index).getMake().equals("volkswagen")){
            ivMake.setImageResource(R.drawable.volkswagen);
        }
        else if (CarApplication.cars.get(index).getMake().equals("BMW")){
            ivMake.setImageResource(R.drawable.bmw);
        }
        else if (CarApplication.cars.get(index).getMake().equals("toyato")){
            ivMake.setImageResource(R.drawable.toyato);
        }



    }
}
