package com.darsh.carcompanyinfo;

import android.app.Application;

import java.util.ArrayList;

public class CarApplication extends Application
{
    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars=new ArrayList<>();
        cars.add(new Car("BMW","i6","Darsh","8700014599"));
        cars.add(new Car("volkswagen","Polo","Umang","8130047607"));
        cars.add(new Car("toyato","etios","Alok","9810481097"));
        cars.add(new Car("BMW","i6","Darsh","8700014599"));
        cars.add(new Car("volkswagen","Polo","Umang","8130047607"));
        cars.add(new Car("toyato","etios","Alok","9810481097"));
        cars.add(new Car("BMW","i6","Darsh","8700014599"));
        cars.add(new Car("volkswagen","Polo","Umang","8130047607"));
        cars.add(new Car("toyato","etios","Alok","9810481097"));



    }
}
