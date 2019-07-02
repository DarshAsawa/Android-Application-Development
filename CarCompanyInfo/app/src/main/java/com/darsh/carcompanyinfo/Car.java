package com.darsh.carcompanyinfo;

public class Car {
    private String make;
    private String model;
    private String owner;
    private String owner_tel;

    public Car(String make, String model, String owner, String owner_tel) {
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.owner_tel = owner_tel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner_tel() {
        return owner_tel;
    }

    public void setOwner_tel(String owner_tel) {
        this.owner_tel = owner_tel;
    }
}
