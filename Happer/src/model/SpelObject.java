/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 09068007
 */
public class SpelObject {
    public Vak vak;
    public Spel spel;


    public SpelObject(Vak vak, Spel spel){
        this.vak = vak;
        this.spel = spel;
    }

    public Vak getVak(){
        return vak;
    }

    public void setVak(Vak vak){
        this.vak = vak;
    }

    public boolean verplaats(String richting){

        if(vak.getBuurvak(richting) != null ){
            if(vak.getBuurvak(richting).getSpelObject()==null){

                vak.getBuurvak(richting).setSpelObject(this);
                vak.setSpelObject(null);
                vak = vak.getBuurvak(richting);
                return true;

            }
        }

        return false;
    }

}
