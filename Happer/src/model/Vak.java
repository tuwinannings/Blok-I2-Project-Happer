/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;

/**
 *
 * @author 09068007
 */
public class Vak {
    private int x;
    private int y;
    private HashMap<String, Vak> buuren;
    private SpelObject spelObject;

    public Vak(int x, int y){
        buuren = new HashMap<String, Vak>();
        this.x = x;
        this.y = y;
    }

    public Vak getBuurvak(String richting){
        return buuren.get(richting);
    }

    public SpelObject getSpelObject(){
        return spelObject;
    }

    public void setSpelObject(SpelObject spelobject){
        this.spelObject = spelobject;
    }

    /**
     * @param richting Richting van de buurvak
     * @param vak De buurvak
     */
    public void setBuren(String richting, Vak vak){
        buuren.put(richting, vak);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * geef een true terug als de buur bestaat en geen spelobject bevat
     * @param richting van de buur
     * @return True als buurvak bestaat en leeg is anders false
     */
    public boolean leegBuurvak(String richting){
        if(getBuurvak(richting)!=null && getBuurvak(richting).getSpelObject() == null){
            return true;
        }
        return false;
    }


}
