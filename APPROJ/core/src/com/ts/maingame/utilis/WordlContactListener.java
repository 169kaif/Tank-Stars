package com.ts.maingame.utilis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.ts.maingame.screens.sprites.Player1;
import com.ts.maingame.screens.sprites.Player2;

public class WordlContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA =contact.getFixtureA();
        Fixture fixB= contact.getFixtureB();

    if(fixA.getUserData()=="front1" || fixB.getUserData()=="front" ){
        Fixture front1 =fixA.getUserData()=="front1" ? fixA : fixB;
        Fixture object = front1 ==fixA? fixB :fixA;

    if(object.getUserData() !=null && ((Player1.class.isAssignableFrom(object.getUserData().getClass())) || Player2.class.isAssignableFrom(object.getUserData().getClass()))){
        ((Player1) object.getUserData()).hit();
    }
    }
       //Gdx.app.log("Begin Contact","");
    }
    @Override
    public void endContact(Contact contact) {
       Gdx.app.log("End Contact","");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
