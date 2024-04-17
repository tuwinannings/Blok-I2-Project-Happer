/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 09068007
 */
public class Mens extends SpelObject{


    public Mens(Vak vak, Spel spel){
        super(vak, spel);
    }
    /**
     *
     * @param richting waarop de mens zich moet vepraatsen
     * @return true als de mens zich heeft verplaatst anders false
     */
    @Override
    public boolean verplaats(String richting){
        if(vak.getBuurvak(richting) != null ){
            if(vak.getBuurvak(richting).getSpelObject()==null){

                vak.getBuurvak(richting).setSpelObject(this);
                vak.setSpelObject(null);
                vak = vak.getBuurvak(richting);
                return true;

            }
            if(vak.getBuurvak(richting).getSpelObject() instanceof BlauweBlok ){
                
                if(vak.getBuurvak(richting).getSpelObject().verplaats(richting)){
                    vak.getBuurvak(richting).setSpelObject(this);
                    vak.setSpelObject(null);
                    vak = vak.getBuurvak(richting);
                    return true;
                }

            }
        }

        return false;
    }

}
