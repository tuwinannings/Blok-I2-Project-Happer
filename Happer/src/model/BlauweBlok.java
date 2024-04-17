/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 09068007
 */
public class BlauweBlok  extends Blok {

    BlauweBlok(Vak vak, Spel spel) {
        super(vak, spel);
    }
    /**
     * Verplaats het blok naar een buurvak
     * @param richting Richting die hij op moet schuiven
     * @return geeft true terug als hij zichzelf heeft verplaatst
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
