package com.ts.maingame.screens.sprites;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class Weapons extends InTile {
    public Weapons(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        BodyDef bdef=new BodyDef();
        FixtureDef fdef=new FixtureDef();
        PolygonShape shape= new PolygonShape();


        Body body;
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect=((RectangleMapObject)object).getRectangle();
            bdef.type=BodyDef.BodyType.StaticBody;
            bdef.position.set((bounds.getX()+bounds.getWidth()/2),(bounds.getY()+bounds.getHeight()/2));

            body=world.createBody(bdef);
            shape.setAsBox(bounds.getWidth()/2, bounds.getHeight()/2);
            fdef.shape=shape;
            body.createFixture(fdef);

        }
    }
}
