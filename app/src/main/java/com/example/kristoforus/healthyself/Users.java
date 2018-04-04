package com.example.kristoforus.healthyself;

/**
 * Created by kristoforus on 3/28/18.
 */

public class Users {
    private String name;
    private int caloriesUsed;

    public Users(){
        this.name = "";
        this.caloriesUsed = 0;
    }

    public Users(String name, int caloriesUsed){
        this.name = name;
        this.caloriesUsed = caloriesUsed;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setCaloriesUsed(int caloriesUsed){
        this.caloriesUsed = caloriesUsed;
    }

    public String getName(){
        return this.name;
    }

    public int getCaloriesUsed(){
        return this.caloriesUsed;
    }
}
