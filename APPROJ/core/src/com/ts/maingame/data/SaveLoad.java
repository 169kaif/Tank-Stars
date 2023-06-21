package com.ts.maingame.data;

import com.ts.maingame.screens.ingame;
import com.ts.maingame.screens.savedgames;

import java.io.*;

public class SaveLoad {
    ingame ig;

    public SaveLoad(ingame ig){
        this.ig = ig;
        ig.saveplace.all_saves.add(this);
    }

    public void save(){

        try{
            ObjectOutputStream obj_save = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage ds = new DataStorage();

            ds.p1 = ig.p1;
            ds.p2 = ig.p2;

            obj_save.writeObject(ds);
        }
        catch(Exception e){
            System.out.println("Exception during save!");
        }
    }

    public void load(){

        try{
            ObjectInputStream obj_read = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            DataStorage ds = (DataStorage)obj_read.readObject();

            ig.p1 = ds.p1;
            ig.p2 = ds.p2;
        }
        catch(Exception e){
            System.out.println("Exception during load!");
        }

    }

}
