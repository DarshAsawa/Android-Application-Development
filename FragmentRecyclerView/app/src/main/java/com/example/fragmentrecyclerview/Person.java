package com.example.fragmentrecyclerview;

public class Person  {
    private String Name;
    private String TelNr;

    public Person(String name, String telNr) {
        Name = name;
        TelNr = telNr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTelNr() {
        return TelNr;
    }

    public void setTelNr(String telNr) {
        TelNr = telNr;
    }
}
