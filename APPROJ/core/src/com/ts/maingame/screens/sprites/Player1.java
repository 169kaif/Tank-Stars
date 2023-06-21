package com.ts.maingame.screens.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.ts.maingame.screens.ingame;
import com.ts.maingame.utilis.Fuel;
import com.ts.maingame.utilis.Health;

import java.util.ArrayList;

public class Player1 extends Sprite {
    public Fuel p1fuel;
    public Health p1health;
    public World world;
    public Body b2body;
    private TextureRegion playertank;
    public enum State{MOVING, FIRING,STOP,DAMAGED};
    public State currentState;
    public State previousState;
    private Animation tankFire;
    private Animation   tankDamage;
    private boolean runningright;
    private float health;
    private float fuel;

    private Animation   movement;

    public Fuel getP1fuel() {
        return p1fuel;
    }

    public void setP1fuel(Fuel p1fuel) {
        this.p1fuel = p1fuel;
    }

    public Health getP1health() {
        return p1health;
    }

    public void setP1health(Health p1health) {
        this.p1health = p1health;
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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public Animation getTankFire() {
        return tankFire;
    }

    public void setTankFire(Animation tankFire) {
        this.tankFire = tankFire;
    }

    public Animation getTankDamage() {
        return tankDamage;
    }

    public void setTankDamage(Animation tankDamage) {
        this.tankDamage = tankDamage;
    }

    public boolean isRunningright() {
        return runningright;
    }

    public void setRunningright(boolean runningright) {
        this.runningright = runningright;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public Animation getMovement() {
        return movement;
    }

    public void setMovement(Animation movement) {
        this.movement = movement;
    }

    public float getStateTimer() {
        return stateTimer;
    }

    public void setStateTimer(float stateTimer) {
        this.stateTimer = stateTimer;
    }

    public Player1(World world, ingame ig){
        super(ig.getAtlas().findRegion("37"));

        p1fuel=new Fuel();
        p1health = new Health();
        this.world=world;
        currentState=State.STOP;
        previousState=State.STOP;
        runningright=false;
        Array<TextureRegion> firingframes=new Array<TextureRegion>();

        firingframes.add(new TextureRegion(getTexture(),200,0,200,120));
        firingframes.add(new TextureRegion(getTexture(),0,120,200,120));
        firingframes.add(new TextureRegion(getTexture(),200,120,200,120));
        tankFire=new Animation(0.1f,firingframes);
        Array<TextureRegion> damageframes=new Array<TextureRegion>();
        Array<TextureRegion> movement=new Array<TextureRegion>();

        damageframes.add(new TextureRegion(getTexture(),0,240,200,120));
        damageframes.add(new TextureRegion(getTexture(),200,240,200,120));
        damageframes.add(new TextureRegion(getTexture(),0,360,200,120));
        damageframes.add(new TextureRegion(getTexture(),200,360,200,120));
        tankDamage=new Animation(0.1f,damageframes);

        definePlayer();
        playertank=new TextureRegion(getTexture(),0,0,200,120);
        movement.add(new TextureRegion(getTexture(),0,0,200,120));
        movement.add(new TextureRegion(getTexture(),0,0,200,120));
        movement.add(new TextureRegion(getTexture(),0,0,200,120));
        movement.add(new TextureRegion(getTexture(),0,0,200,120));

        setBounds(0,0,225,225);
        //playertank.flip(true,false);
        //setRegion(playertank);

    }
    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        setRegion((getFrame(dt)));
    }
    float stateTimer;
    public TextureRegion getFrame(float dt){

        currentState=getState();
        TextureRegion region,region1;
        switch (currentState){

            case FIRING:

                region= ((TextureRegion) tankFire.getKeyFrame(stateTimer,true));

                // region=  tankFire.getKeyFrame(stateTimer,true);
                //region= (TextureRegion) tankFire.getKeyFrame(stateTimer,true);
                break;
            default:


                region= playertank;
                ;





        }

    stateTimer=currentState== previousState ? stateTimer+dt:0;
    previousState=currentState;
    return region;

    }

    public State getState(){

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            return State.FIRING;

        }
        else{
            return State.STOP;
        }


    }
    public void definePlayer(){
        BodyDef bdef=new BodyDef();
        bdef.position.set(70,200);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef =new FixtureDef();
        fdef.friction=0.75f;
        CircleShape shape = new CircleShape();
        shape.setRadius(0.05f);
        fdef.shape = shape;
        b2body.createFixture(fdef);
        EdgeShape front1 =new EdgeShape();
        front1.set(new Vector2(-10,7),new Vector2(10,7));
        fdef.shape=front1;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("front1");

    }
    public void hit(){
        Gdx.app.log("TANKKK","Collision");
    }

}
