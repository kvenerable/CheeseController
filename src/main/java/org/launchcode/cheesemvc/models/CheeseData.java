package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<cheese> cheeses = new ArrayList<>();
    //getAll
    public static ArrayList <cheese> getAll(){
        return cheeses;
    }
    //add
    public static void add(cheese newcheese){
        cheeses.add(newcheese);
    }

    //remove
    public static void remove(int id){
        cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);

    }

    //getById
    public static cheese getById(int id){
        cheese theCheese = null;
        for(cheese candidateCheese : cheeses){
            theCheese = candidateCheese;
        }
        return theCheese;

    }
}
