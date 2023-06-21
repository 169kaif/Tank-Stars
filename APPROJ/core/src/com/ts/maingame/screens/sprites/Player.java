package com.ts.maingame.screens.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.ts.maingame.screens.ingame;

public abstract class Player {
    protected World world;
    protected  Body b2body;
    protected  TextureRegion playertank;

    Player( ingame ig){

    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getB2body() {
        return b2body;
    }

    public void setB2body(Body b2body) {
        this.b2body = b2body;
    }

    public TextureRegion getPlayertank() {
        return playertank;
    }

    public void setPlayertank(TextureRegion playertank) {
        this.playertank = playertank;
    }
//public abstract

}
