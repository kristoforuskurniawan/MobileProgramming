package com.example.kristoforus.healthyself;

/**
 * Created by kristoforus on 4/2/18.
 */

public class Doctors { // This class is not yet used.
    private String name;
    private int ID;

    public Doctors(){
        name = "unknown";
        ID = 0;
    }

    public Doctors(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }
}
