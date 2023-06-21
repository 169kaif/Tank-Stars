package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class pause implements Screen {

    TANKKKKK ts;
    Texture img;
    public pause(TANKKKKK ts){
        this.ts=ts;
    }
    @Override
    public void show() {
        img = new Texture("paused.png");
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);
        ts.batch.end();
        if(Gdx.input.getX()>=284 && Gdx.input.getX()<=516 && Gdx.input.getY() >= 324 && Gdx.input.getY() <= 388
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new ingame(ts));
        }
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
