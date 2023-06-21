package com.ts.maingame.utilis;

public class Fuel {

    private float fuel;

    public Fuel(){
        this.fuel = 10;
    }

    public float getFuel() {
        return fuel;
    }

    public void changeFuel(float delta){
        this.fuel -= 3*delta;
    }
}
