package com.example.fragmentrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application
{
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        people=new ArrayList<Person>();
        people.add(new Person("Darsh","8700014599"));
        people.add(new Person("Dad","9810481097"));

    }
}
