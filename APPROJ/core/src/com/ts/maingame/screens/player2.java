package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class player2 implements Screen {
    TANKKKKK ts;
    Texture img;

    public player2(TANKKKKK ts) {
        this.ts = ts;
    }

    @Override
    public void show() {
        img = new Texture("Tank Game.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);
        if (Gdx.input.getX() >= 28 && Gdx.input.getX() <= 221 && Gdx.input.getY() >= 406 && Gdx.input.getY() <= 453
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank2 = 1;
            if (ts.tank1 == 1) {
                ts.setScreen(new onvone(ts));
            }
            if (ts.tank1 == 2) {
                ts.setScreen(new twovone(ts));
            }

            if (ts.tank1 == 3) {
                ts.setScreen(new threevone(ts));
            }
    }

        if(Gdx.input.getX()>=295 && Gdx.input.getX()<=487 && Gdx.input.getY() >= 406 && Gdx.input.getY() <= 453
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank2=2;
            if (ts.tank1 == 1) {
                ts.setScreen(new onevtwo(ts));
            }
            if (ts.tank1 == 2) {
                ts.setScreen(new twovtwo(ts));
            }

            if (ts.tank1 == 3) {
                ts.setScreen(new threevtwo(ts));
            }
        }

        if(Gdx.input.getX()>=578 && Gdx.input.getX()<=771 && Gdx.input.getY() >= 406 && Gdx.input.getY() <= 453
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.tank2=3;
            if (ts.tank1 == 1) {
                ts.setScreen(new onvthree(ts));
            }
            if (ts.tank1 == 2) {
                ts.setScreen(new twovthree(ts));
            }

            if (ts.tank1 == 3) {
                ts.setScreen(new threevthree(ts));
            }

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
