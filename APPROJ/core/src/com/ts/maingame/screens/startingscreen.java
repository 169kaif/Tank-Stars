package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ts.maingame.TANKKKKK;

public class startingscreen implements Screen {
    TANKKKKK ts;
    Texture img,img1,img2;



    public startingscreen(TANKKKKK ts){
        this.ts=ts;
    }


    @Override
    public void show() {
        img = new Texture("startingscreen.png");
        img1 = new Texture("mainmenu.png");

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        ts.batch.begin();
        ts.batch.draw(img, 0, 0);

        if(Gdx.input.getX()>=10 && Gdx.input.getX()<=203 && Gdx.input.getY() >= 400 && Gdx.input.getY() <= 480
            && Gdx.input.isTouched() == true) {
                    System.exit(0);
                }



            if(Gdx.input.getX()>=600 && Gdx.input.getX()<=793 && Gdx.input.getY() >= 400 && Gdx.input.getY() <= 480
                    && Gdx.input.isTouched() == true) {
                //System.exit(0);
               // ts.batch.draw(img1,0,0);
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


