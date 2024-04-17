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
public class DommeHapper extends Happer {
    private Random random;


    public DommeHapper(Vak vak, Spel spel){
        super(vak, spel);
        random = new Random();

    }

    /**
     * Kijkt op basis van de korste X en Y lokatie waar de happer heen moet
     * @return True als er een vrije richting is gevonden anders false
     */
    @Override
    public boolean zoekMens(){
        String nieuweRichting = null;
        while(nieuweRichting == null){
            if(random.nextInt(2)==1){
                if(getVak().getX() < spel.getMens().getVak().getX()){
                    nieuweRichting = "rechts";
                }
                if(getVak().getX() > spel.getMens().getVak().getX()){
                    nieuweRichting = "links";
                }
            }else{
                if(getVak().getY() < spel.getMens().getVak().getY()){
                    nieuweRichting = "onder";
                }
                if(getVak().getY() > spel.getMens().getVak().getY()){
                    nieuweRichting = "boven";
                }
            }
        }
        if(nieuweRichting != null){
            verplaats(nieuweRichting);
            return true;
        }else{
            return false;
        }
    }

}
