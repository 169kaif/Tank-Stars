package com.ts.maingame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ts.maingame.screens.ingame;
import com.ts.maingame.screens.startingscreen;

public class TANKKKKK extends Game {
	public SpriteBatch batch;
	//Texture img,img1,img2;
	public int tank1;
	public int tank2;
	public static final int PPM=300;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new startingscreen(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {


	}
}
