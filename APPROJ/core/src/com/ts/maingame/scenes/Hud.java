package com.ts.maingame.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ts.maingame.screens.sprites.Player1;
import com.ts.maingame.screens.sprites.Player2;

import javax.swing.text.View;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Player1 p1;

    private Player2 p2;

    Label p1Health;
    Label p1Fuel;
    Label p2Health;
    Label p2Fuel;


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Player1 getP1() {
        return p1;
    }

    public void setP1(Player1 p1) {
        this.p1 = p1;
    }

    public Player2 getP2() {
        return p2;
    }

    public void setP2(Player2 p2) {
        this.p2 = p2;
    }

    public Label getP1Health() {
        return p1Health;
    }

    public void setP1Health(Label p1Health) {
        this.p1Health = p1Health;
    }

    public Label getP1Fuel() {
        return p1Fuel;
    }

    public void setP1Fuel(Label p1Fuel) {
        this.p1Fuel = p1Fuel;
    }

    public Label getP2Health() {
        return p2Health;
    }

    public void setP2Health(Label p2Health) {
        this.p2Health = p2Health;
    }

    public Label getP2Fuel() {
        return p2Fuel;
    }

    public void setP2Fuel(Label p2Fuel) {
        this.p2Fuel = p2Fuel;
    }

    public Hud(SpriteBatch sb, Player1 _p1, Player2 _p2){

        p1 = _p1;
        p2 = _p2;

        viewport = new FitViewport(800,480, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        p1Health = new Label(String.format("%03d", 100), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p2Health = new Label(String.format("%03d", 100), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p1Fuel = new Label(String.format("%02d", 10), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p2Fuel = new Label(String.format("%02d", 10), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(p1Health).expandX().padTop(10);
        table.add(p2Health).expandX().padTop(10);
        table.row();
        table.add(p1Fuel).expandX();
        table.add(p2Fuel).expandX();
        stage.addActor(table);

    }

}
