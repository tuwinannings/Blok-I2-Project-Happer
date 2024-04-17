/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;

/**
 *
 * @author 09068007
 */
public class Happer extends SpelObject {
    private Random random;

    public Happer(Vak vak, Spel spel){
        super(vak, spel);
        random = new Random();
    }

    /**
     * Verplaatst de happer naar een buurvak
     * @param richting Richting van de buurvak waar de happer zich heen moet verplaatsen
     * @return True als de happer zich heeft verplaatst
     *         False als buurvak niet bestaat en/of niet leeg is en als mens op de aangegeven buurvak staat
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
            if(vak.getBuurvak(richting).getSpelObject() instanceof Mens){
                vak.getBuurvak(richting).setSpelObject(this);
                vak.setSpelObject(null);
                vak = vak.getBuurvak(richting);
                spel.gameOver("Je hebt verloren!");
                return false;
            }
        }

        return false;
    }

    /**
     * Kiest een willekeurige richting van de happer
     * @return true als de richting bestaat anders false
     */
    public boolean randomRichting(){
        int i = random.nextInt(spel.getRichtingen().length);
        String nieuweRichting = spel.getRichtingen()[i];
        if(nieuweRichting != null){
            verplaats(nieuweRichting);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     *  Kijkt of de happer wel of niet is ingesloten door objecten
     * @return True als de happer geen leeg buurvak omzich heen heeft anders false
     */
    public boolean isIngesloten(){
        int richtingen=0;
        for(String richting : spel.getRichtingen()){
            if(getVak().leegBuurvak(richting)){
                richtingen++;
            }
        }
        if(richtingen==0){
            return true;
        }else{
            return false;
        }
    }

    public boolean zoekMens(){
        return false;
    }


}
