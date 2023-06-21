package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class mainmenu implements Screen {

    TANKKKKK ts;
    Texture img,img1,img2;
    public mainmenu(TANKKKKK ts){
        this.ts=ts;
    }
    @Override
    public void show() {
        img = new Texture("mainmenu.png");

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);

        if(Gdx.input.getX()>=267 && Gdx.input.getX()<=495 && Gdx.input.getY() >= 153 && Gdx.input.getY() <= 217
                && Gdx.input.isTouched() == true) {
    //System.exit(0);
            ts.setScreen(new player1(ts));
        }
        if(Gdx.input.getX()>=267 && Gdx.input.getX()<=495 && Gdx.input.getY() >= 240 && Gdx.input.getY() <= 307
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new savedgames(ts));
        }
        if(Gdx.input.getX()>=267 && Gdx.input.getX()<=495 && Gdx.input.getY() >= 327 && Gdx.input.getY() <= 391
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new startingscreen(ts));
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
