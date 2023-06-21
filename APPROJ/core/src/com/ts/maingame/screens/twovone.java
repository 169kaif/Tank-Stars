package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class twovone implements Screen {
    TANKKKKK ts;
    Texture img;
    public twovone(TANKKKKK ts){
        this.ts=ts;
    }

    @Override
    public void show() {
        img = new Texture("9.png");

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);
        if(Gdx.input.getX()>=284 && Gdx.input.getX()<=514 && Gdx.input.getY() >= 324 && Gdx.input.getY() <= 388
                && Gdx.input.isTouched() == true) {
            //System.exit(0);

            ts.setScreen(new ingame(ts));
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

