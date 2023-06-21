package com.ts.maingame.utilis;

public class Health {
    private int health;

    public Health(){
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(){
        health -= 25;
    }

}
