package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;
import com.ts.maingame.data.SaveLoad;

import java.util.ArrayList;

public class savedgames implements Screen {
    TANKKKKK ts;
    Texture img;

    public ArrayList<SaveLoad> all_saves = new ArrayList<SaveLoad>();
    public savedgames(TANKKKKK ts){
        this.ts=ts;
    }
    @Override
    public void show() {
        img = new Texture("Tank Game (3).png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);
        if(Gdx.input.getX()>=14 && Gdx.input.getX()<=241 && Gdx.input.getY() >= 220 && Gdx.input.getY() <= 285
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new ingame(ts));
        }
        if(Gdx.input.getX()>=286 && Gdx.input.getX()<=514 && Gdx.input.getY() >= 220 && Gdx.input.getY() <= 285
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new ingame(ts));
        }
        if(Gdx.input.getX()>=557 && Gdx.input.getX()<=784 && Gdx.input.getY() >= 220 && Gdx.input.getY() <= 285
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new ingame(ts));
        }
        if(Gdx.input.getX()>=578 && Gdx.input.getX()<=784 && Gdx.input.getY() >= 407 && Gdx.input.getY() <= 464
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new mainmenu(ts));
        }
        ts.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
