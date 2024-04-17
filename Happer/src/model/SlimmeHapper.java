/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 09068007
 */
public class SlimmeHapper extends Happer {

    public SlimmeHapper(Vak vak, Spel spel){
        super(vak, spel);
    }

    /**
     * Geeft op basis van algoritme de richting weer die de happer naar de mens lijd
     * @return True als er een richting is gevonden anders false
     */
    @Override
    public boolean zoekMens(){
        int[][] route = new int[spel.getXHor()][spel.getYVert()];
        int getal = 1;
        int buurvakX;
        int buurvakY;
        String nieuweRichting = null;

        //aan bestaande en lege vak rondom de mens krijgt een getal toegekend
        for(String richting : spel.getRichtingen()){
            if(spel.getMens().getVak().leegBuurvak(richting)){
                buurvakX = spel.getMens().getVak().getBuurvak(richting).getX();
                buurvakY = spel.getMens().getVak().getBuurvak(richting).getY();
                route[buurvakX][buurvakY] = getal;
            }
        }

        //gaat elke vak na met een getal
        //geeft de buurvakken van een vak een getal dat hoger is dan zijn getal
        for(int a=0;a<spel.getXHor()*spel.getYVert();a++){
            for(int x=0;x<spel.getXHor();x++){
                for(int y=0;y<spel.getYVert();y++){
                    if(route[x][y]==getal){
                        for(String richting : spel.getRichtingen()){
                            if(spel.getSpelVakken()[x][y].leegBuurvak(richting)){
                                buurvakX = spel.getSpelVakken()[x][y].getBuurvak(richting).getX();
                                buurvakY = spel.getSpelVakken()[x][y].getBuurvak(richting).getY();
                                if(route[buurvakX][buurvakY]==0)route[buurvakX][buurvakY] = getal+1;
                            }
                        }
                    }
                }
            }
            getal++;
        }

        //kijkt naar de toegewezen getallen van de buurvakken rondom happer
        //de nieuwe richting wordt bepaald door de buurvak met het laagste getal
        //ook wordt steeds gekeken of de happer niet al als buurvak object de mens heeft
        //zo ja dan wordt dat de nieuwe richting
        for(String richting : spel.getRichtingen()){
            if(spel.getHapper().getVak().leegBuurvak(richting)){
                buurvakX = spel.getHapper().getVak().getBuurvak(richting).getX();
                buurvakY = spel.getHapper().getVak().getBuurvak(richting).getY();
                if(route[buurvakX][buurvakY] < getal && route[buurvakX][buurvakY] != 0){
                    getal = route[buurvakX][buurvakY];
                    nieuweRichting = richting;
                }
            }
            if(spel.getHapper().getVak().getBuurvak(richting) != null &&
                    spel.getHapper().getVak().getBuurvak(richting).getSpelObject() instanceof Mens){
                buurvakX = spel.getHapper().getVak().getBuurvak(richting).getX();
                buurvakY = spel.getHapper().getVak().getBuurvak(richting).getY();
                if(route[buurvakX][buurvakY] < getal){
                    getal = route[buurvakX][buurvakY];
                    nieuweRichting = richting;
                }
            }
        }

        //Hieronder code voor een print test uitvoer
        System.out.println();
        for(int y=0;y<spel.getYVert();y++){
            for(int x=0;x<spel.getXHor();x++){
                    if(spel.getMens().getVak() == spel.getSpelVakken()[x][y]){
                        System.out.print(" M ");
                    }else if(spel.getHapper().getVak() == spel.getSpelVakken()[x][y]){
                        System.out.print(" H ");
                    }else if(route[x][y]>0){
                        System.out.print(" "+route[x][y]+" ");
                    }else{
                        System.out.print(" B ");
                    }

                }
            System.out.println();
        }

        if(nieuweRichting != null){
            verplaats(nieuweRichting);
            return true;
        }else{
            return false;
        }

    }

}
