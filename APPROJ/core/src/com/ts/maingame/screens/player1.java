package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class player1 implements Screen {
    Texture img;
    TANKKKKK ts;
    public player1(TANKKKKK ts){
        this.ts=ts;
    }
    @Override
    public void show() {
        img = new Texture("Tank Game (5).png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);
        if(Gdx.input.getX()>=28 && Gdx.input.getX()<=221 && Gdx.input.getY() >= 350 && Gdx.input.getY() <= 405
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank1=1;
            ts.setScreen(new player2(ts));
        }
        if(Gdx.input.getX()>=295 && Gdx.input.getX()<=487 && Gdx.input.getY() >= 350 && Gdx.input.getY() <= 405
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank1=2;
            ts.setScreen(new player2(ts));
        }

        if(Gdx.input.getX()>=578 && Gdx.input.getX()<=771 && Gdx.input.getY() >= 350 && Gdx.input.getY() <= 405
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank1=3;
            ts.setScreen(new player2(ts));
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
