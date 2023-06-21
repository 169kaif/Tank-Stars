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

public class Player2 extends Sprite {

    public Fuel p2fuel;
    public Health p2health;
    public World world;
    public Body b2body;
    private TextureRegion playertank,f1,f2,f3,d1,d2,d3;
    public enum State{MOVING, FIRING,STOP,DAMAGED};
    public State currentState;
    public State previousState;
    private Animation tankFire;
    private Animation   tankDamage;
    private boolean runningright;
    private float health;
    private float fuel;

    private Animation   movement;

    public Player2(World world, ingame ig){
        super(ig.getAtlas1().findRegion("45"));

        p2fuel= new Fuel();
        p2health = new Health();

        this.world=world;
        currentState=State.STOP;
        previousState=State.STOP;
        fuel=100;
        runningright=false;
        Array<TextureRegion> firingframes=new Array<TextureRegion>();
        f1=(new TextureRegion(getTexture(),0,120,200,120));
        f1.flip(true,false);
        f2=new TextureRegion(getTexture(),0,240,200,120);
        f2.flip(true,false);
        f3=new TextureRegion(getTexture(),0,360,200,120);
        f3.flip(true,false);
        firingframes.add((f1));
        firingframes.add(f2);
        firingframes.add(f3);
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
        playertank.flip(true,false);
        movement.add(new TextureRegion(getTexture(),0,0,200,120));
        setBounds(0,0,200,200);
        setRegion(playertank);

    }

    public Fuel getP2fuel() {
        return p2fuel;
    }

    public void setP2fuel(Fuel p2fuel) {
        this.p2fuel = p2fuel;
    }

    public Health getP2health() {
        return p2health;
    }

    public void setP2health(Health p2health) {
        this.p2health = p2health;
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

    public TextureRegion getF1() {
        return f1;
    }

    public void setF1(TextureRegion f1) {
        this.f1 = f1;
    }

    public TextureRegion getF2() {
        return f2;
    }

    public void setF2(TextureRegion f2) {
        this.f2 = f2;
    }

    public TextureRegion getF3() {
        return f3;
    }

    public void setF3(TextureRegion f3) {
        this.f3 = f3;
    }

    public TextureRegion getD1() {
        return d1;
    }

    public void setD1(TextureRegion d1) {
        this.d1 = d1;
    }

    public TextureRegion getD2() {
        return d2;
    }

    public void setD2(TextureRegion d2) {
        this.d2 = d2;
    }

    public TextureRegion getD3() {
        return d3;
    }

    public void setD3(TextureRegion d3) {
        this.d3 = d3;
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

    public void update(float dt){
        setPosition(b2body.getPosition().x-getWidth()/2,b2body.getPosition().y-getHeight()/2);
        setRegion((getFrame(dt)));
    }


    float stateTimer;
    public TextureRegion getFrame(float dt){

        currentState=getState();
        TextureRegion region1 ;
        switch (currentState){

            case FIRING:

                region1=(((TextureRegion) (tankFire.getKeyFrame(stateTimer,true))));


                break;
            default:


                 region1=playertank;
                ;





        }

        stateTimer=currentState== previousState ? stateTimer+dt:0;
        previousState=currentState;
        return region1;

    }

    public State getState(){

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            return State.FIRING;

        }
        else{
            return State.STOP;
        }


    }
    public void definePlayer(){
        BodyDef bdef=new BodyDef();
        bdef.position.set(700,200);
        bdef.type=BodyDef.BodyType.DynamicBody;
        b2body=world.createBody(bdef);
        FixtureDef fdef =new FixtureDef();
        fdef.friction=0.75f;
        CircleShape shape = new CircleShape();
        shape.setRadius(0.05f);
        fdef.shape = shape;
        b2body.createFixture(fdef);
        EdgeShape front1 =new EdgeShape();
        front1.set(new Vector2(-30,7),new Vector2(30,7));
        fdef.shape=front1;
        fdef.isSensor=true;
        b2body.createFixture(fdef).setUserData("front1");

    }
    public void hit(){
        Gdx.app.log("TANKKK","Collision");
    }

}
