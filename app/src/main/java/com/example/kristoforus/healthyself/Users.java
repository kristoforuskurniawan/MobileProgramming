package com.example.kristoforus.healthyself;

/**
 * Created by kristoforus on 3/28/18.
 */

public class Users {
    private String name;
    private int calories_used;
    private int km_walked;

    public Users(){
        this.name = "";
        this.calories_used = 0;
        this.km_walked = 0;
    }

    public Users(String name, int caloriesUsed, int kmWalked){
        this.name = name;
        this.calories_used = caloriesUsed;
        this.km_walked = kmWalked;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setCalories_used(int calories_used){
        this.calories_used = calories_used;
    }

    public void setKm_walked(int km_walked) { this.km_walked = km_walked; }

    public String getName(){
        return this.name;
    }

    public int getCalories_used(){
        return this.km_walked * 160;
    }

    public int getKm_walked() { return this.km_walked; }
}
