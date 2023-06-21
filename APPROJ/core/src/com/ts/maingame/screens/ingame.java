package com.ts.maingame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.ts.maingame.TANKKKKK;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.renderers.*;
import com.ts.maingame.data.SaveLoad;
import com.ts.maingame.scenes.Hud;
import com.ts.maingame.screens.sprites.Bullet2;
import com.ts.maingame.screens.sprites.Player1;
import com.ts.maingame.screens.sprites.Player2;
import com.ts.maingame.utilis.tiledobj;
import com.ts.maingame.utilis.WordlContactListener;
import com.badlogic.gdx.math.*;

import java.util.ArrayList;


public class ingame implements Screen {
    public Player1 p1;
    public Player2 p2;
    TANKKKKK ts;
    Texture img,img1,img2;
    float player1x=0;
    float player2=0;
    float speed =40;

    private OrthographicCamera gcam;
    private Viewport gport;
    private ImmediateModeRenderer20 rendere;
    private float sample =1/100f;
    private Vector2 val1=new Vector2();
    private Vector2 val2=new Vector2();
    private float current=0;
    private TextureRegion tr;
    private float val=0;
    private float speed1=0.2f;
    Vector2 point1=new Vector2();
    Vector2 point2=new Vector2();
    Vector2 point3=new Vector2();
    //variable that loads map
    private TmxMapLoader maploader;

    private TiledMap map;
    Bezier bezier;
    private ShapeRenderer sr;

    //variable to render map
    private OrthogonalTiledMapRenderer m_renderer;
    private TextureAtlas atlas,atlas1;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Hud hud;
    float t;
    Bullet2 b1;
    private Bezier<Vector2> path1;
    private CatmullRomSpline<Vector2> path2;
    ArrayList<Bullet2> bullets;

    public savedgames saveplace = new savedgames(ts);

    public ingame(TANKKKKK ts) {
        atlas=new TextureAtlas("newt1.txt");
        atlas1=new TextureAtlas("newt2.txt");

        this.ts = ts;
        maploader = new TmxMapLoader();
        bullets=new ArrayList<Bullet2>();
        //create cam to follow tanks
        gcam = new OrthographicCamera();
        gport = new FitViewport(800, 48, gcam);
        world=new World(new Vector2(0,-10),true);
        hud = new Hud(ts.batch,p1,p2);
        map = maploader.load("ingamemap.tmx");
        m_renderer = new OrthogonalTiledMapRenderer(map,1);
        Vector2 x1 = new Vector2();
        Vector2 x2 = new Vector2();
        Vector2 x3 = new Vector2();
        Vector2 startPoint = new Vector2(100, 100);
        Vector2 controlPoint = new Vector2(200, 50);
        Vector2 endPoint = new Vector2(300, 100);



        // Create a quadratic Bezier curve with control points (0, 0), (100, 100), and (200, 0)
        bezier = new Bezier<>(new Vector2(100, 100), new Vector2(300, 300), new Vector2(200, 0));
        x1.set(0,0);
        x2.set(240,800);
        x3.set(480,0);
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        int points = 4;
        Vector2[] controlPoints = new Vector2[points];
        for (int i = 0; i < points; i++) {
            int x = (int) (Math.random() * width) ;
            int y = (int) (Math.random() * height);
            Vector2 point = new Vector2(x, y);
            controlPoints[i] = point;
        }

        path1 = new Bezier<Vector2>(controlPoints);
        path2 = new CatmullRomSpline<Vector2>(controlPoints, true);

        // setup ShapeRenderer
        sr = new ShapeRenderer();
        sr.setAutoShapeType(true);
        // setup ShapeRenderer

        Vector2 point1=new Vector2();
        Vector2 point2=new Vector2();
        Vector2 point3=new Vector2();
        point1.set(70,200);
        point2.set(375,480);
        point3.set(700,200);
        Bezier bezier = new Bezier<>(point1, point2, point3);


        rendere=new ImmediateModeRenderer20(false,false,0);
        b2dr=new Box2DDebugRenderer();
        gcam.setToOrtho(false, 800, 480);
        p1=new Player1(world,this);
        p2=new Player2(world,this);
        tiledobj.parseTiledObjectLayer(world,map.getLayers().get(2).getObjects());
        world.setContactListener(new WordlContactListener());
    }

    public void saveGame(){

        SaveLoad tmp_save = new SaveLoad(this);
        tmp_save.save();

    }

    public void loadGame(int i){

        SaveLoad tmp_save;
        tmp_save = saveplace.all_saves.get(i);
        tmp_save.load();

    }

    public TextureAtlas getAtlas(){
        return atlas;
    }
    public TextureAtlas getAtlas1(){
        return atlas1;
    }
    @Override
    public void show() {
//        img = new Texture("Tank Game (6).png");

    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched()){
            //update gamecam here
           gcam.position.x += 100*dt;
        }
        Class a=p1.getClass();
    ArrayList<Bullet2> bulletstoremove=new ArrayList<>();

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && p1.b2body.getLinearVelocity().x >= -2)
                if(p1.p1fuel.getFuel()>0) {
                    p1.b2body.applyLinearImpulse(new Vector2(-0.5f, 0), p1.b2body.getWorldCenter(), true);
                    p1.p1fuel.changeFuel(dt);
                }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && p1.b2body.getLinearVelocity().x <= 2)
                if (p2.p2fuel.getFuel()>0) {
                    p1.b2body.applyLinearImpulse(new Vector2(0.5f, 0), p1.b2body.getWorldCenter(), true);
                    p2.p2fuel.changeFuel(dt);
                }

            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) ){
            bullets.add(new Bullet2(-100,50));
            for(Bullet2 bullet:bullets){
                bullet.update(dt);
                if(bullet.remove)
                bulletstoremove.add(bullet);
            }
            bullets.remove(bulletstoremove);
        }


            if (Gdx.input.isKeyPressed(Input.Keys.A) && p1.b2body.getLinearVelocity().x >= -2)
                p2.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), p2.b2body.getWorldCenter(), true);

            if (Gdx.input.isKeyPressed(Input.Keys.D) && p1.b2body.getLinearVelocity().x <= 2)
                p2.b2body.applyLinearImpulse(new Vector2(0.1f, 0), p2.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.S) ){
            bullets.add(new Bullet2(-100,50));
            for(Bullet2 bullet:bullets){
                bullet.update(dt);
                if(bullet.remove)
                    bulletstoremove.add(bullet);
            }
            bullets.remove(bulletstoremove);
        }

    }

    public void update(float dt){

        //updates after handling input
        handleInput(dt);
        world.step(1/60f,10,2);
        p1.update(dt);
        p2.update(dt);
        gcam.update();
        m_renderer.setView(gcam);
    }

    public Player1 getP1() {
        return p1;
    }

    public void setP1(Player1 p1) {
        this.p1 = p1;
    }

    @Override
    public void render(float delta) {


       // m_renderer.setView(gcam);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        m_renderer.render();

        sr.begin();
        //sr.setColor(Color.WHITE);
        Vector2 st = new Vector2();
        st.set(70,200);
        Vector2 end = new Vector2();
        end.set(700,225);
        //draw path1
        for(int i = 0; i < 100; ++i){

            // create vectors to store start and end points of this section of the curve
            Vector2 st1 = new Vector2();
            st1.set(70,200);
            Vector2 end1 = new Vector2();
            end1.set(700,200);
            // get the start point of this curve section
            path1.valueAt(st1,t);
            // get the next start point(this point's end)
            path1.valueAt(end1, t-0.01f);
            // draw the curve
            //sr.line(st1.x, st1.y, end1.x, end1.y);

        }
        sr.line(st.x, st.y, end.x, end.y);

        //same as above but for catmullrom
        //sr.setColor(Color.RED);


        sr.end();

        m_renderer.setView(gcam);
        b2dr.render(world,gcam.combined);

        ts.batch.setProjectionMatrix(hud.stage.getCamera().combined);


        hud.stage.draw();
        ts.batch.begin();
        //sr.begin();



        for(Bullet2 bullet2:bullets){
            bullet2.render(ts.batch);
        }



        update(delta);

        ts.batch.setProjectionMatrix(gcam.combined);
        p1.draw(ts.batch);
        p2.draw(ts.batch);
        if(Gdx.input.getX()>=727 && Gdx.input.getX()<=777 && Gdx.input.getY() >= 19 && Gdx.input.getY() <= 73
                && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new pause(ts));
       }
       if(Gdx.input.getX()>=23 && Gdx.input.getX()<=73 && Gdx.input.getY() >= 19 && Gdx.input.getY() <= 73 && Gdx.input.isTouched() == true) {
            //System.exit(0);
           ts.setScreen(new ingameoptions(ts));
       }
        if(Gdx.input.isKeyPressed(Input.Keys.D) == true) {
            //System.exit(0);
            player1x+=Gdx.graphics.getDeltaTime()*speed;
        }
        if(Gdx.input.getX()>=642 && Gdx.input.getX()<=733 && Gdx.input.getY() >= 346 && Gdx.input.getY() <= 401
               && Gdx.input.isTouched() == true) {
            //System.exit(0);
            ts.setScreen(new ingameoptions(ts));
       }
       // sr.end();
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
        map.dispose();
        m_renderer.dispose();
        world.dispose();
        b2dr.dispose();

    }
}
