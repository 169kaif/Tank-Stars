package com.ts.maingame.screens.sprites;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Bullet2 extends ApplicationAdapter {
    public static final int SPEED=500;

    public Texture img;
    float x,y;

    public boolean remove=false;

    public Bullet2(float x,float y){
    this.x=x;
    this.y=y;
    img=new Texture("Tank Game (11).png");
    }

    public void update (float deltaTime) {
       // y += SPEED * deltaTime;
        x += SPEED * deltaTime;
        if (y > Gdx.graphics.getHeight() || x> Gdx.graphics.getWidth())
            remove = true;


    }
    public void update1 (float deltaTime) {
        // y += SPEED * deltaTime;
        x -= SPEED * deltaTime;
        if (y > Gdx.graphics.getHeight() || x> Gdx.graphics.getWidth())
            remove = true;


    }
    public void render (SpriteBatch batch) {
        batch.draw(img, x, y);
    }

    }



