/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author 09068007
 */
public class Spel{

    private Vak[][] spelVakken;
    private Mens mens;
    private Happer happer;
    private int xHor;
    private int yVert;
    private String[] richtingen ={"rechts","links","boven","onder"};
    private Random random;
    private boolean gestart;
    private int zwarteBlokken;
    private int blauweBlokken;

    public Spel(){
        xHor = 20;
        yVert = 13;
        zwarteBlokken = 10;
        blauweBlokken = 45;
        random = new Random();
        gestart=false;
        setVakken(); // als eerste
        setBuren();
        mens = new Mens(spelVakken[0][0], this);
        spelVakken[0][0].setSpelObject(mens);
        happer = new SlimmeHapper(spelVakken[xHor-1][yVert-1], this);
        spelVakken[xHor-1][yVert-1].setSpelObject(happer);
        setZwarteBlokken(zwarteBlokken);
        setBlauweBlokken(blauweBlokken);

    }

    public void startSpel(){
        gestart=true;
    }
    
    public void stopSpel(){
        gestart=false;
    }

    public void resetSpel(){
        gestart=false;
        genereerSpelVeld();
    }

    /*
     * Genreerd het spelVeld
     * setVakken moet altijd als eerste worden aangeroepen
     * anders kunnen de andere spelobjecten niet geplaatst worden
     */
    public void genereerSpelVeld(){
        setVakken(); // als eerste
        setBuren();
        mens.setVak(spelVakken[0][0]);
        spelVakken[0][0].setSpelObject(mens);
        happer.setVak(spelVakken[xHor-1][yVert-1]);
        spelVakken[xHor-1][yVert-1].setSpelObject(happer);
        setZwarteBlokken(zwarteBlokken);
        setBlauweBlokken(blauweBlokken);    
    }

    public void setMens(Mens mens){
        this.mens = mens;
    }

    public void setHapper(Happer happer){
        this.happer = happer;
    }
    /**
     * Genereert alle spel vakken voor het speelveld
     */
    public void setVakken(){
        spelVakken = new Vak[xHor][yVert];

        for(int x=0;x<xHor;x++){
            //System.out.print(x);
            for(int y=0;y<yVert;y++){
                //System.out.print(y);
                spelVakken[x][y]= new Vak(x,y);
            }
            //System.out.println();
        }
    }

    /**
     * Kijkt of elke vak een buur heeft en voegt die toe aan de hashmap van het vak
     */
    public void setBuren(){
        for(int x=0;x<xHor;x++){
            //System.out.print(x);
            for(int y=0;y<yVert;y++){
                //System.out.print(y);
                if(y!=0)spelVakken[x][y].setBuren("boven", spelVakken[x][y-1]);
                if(x!=xHor-1)spelVakken[x][y].setBuren("rechts", spelVakken[x+1][y]);
                if(y!=yVert-1)spelVakken[x][y].setBuren("onder", spelVakken[x][y+1]);
                if(x!=0)spelVakken[x][y].setBuren("links", spelVakken[x-1][y]);
                //System.out.println(x+","+y+" "+spelVakken[x][y].printBuren());
            }
        }
    }
    /**
     * @param aantal Het aantal zwarteblokken dat op het speelveld komen te staan
     */
    public void setZwarteBlokken(int aantal){
        int a =0;
        while(a < aantal){
            for(int x=0;x<xHor;x++){
                for(int y=0;y<yVert;y++){
                    if(spelVakken[x][y].getSpelObject()==null && random.nextInt(30)==1 && a < aantal){
                        spelVakken[x][y].setSpelObject(new ZwarteBlok(spelVakken[x][y], this));
                        //System.out.println(x+","+y);

                        a++;
                    }
                }
            }
        }
    }
    /**
     * @param aantal Het aantal blauwe blokken dat op het speelveld komen te staan
     */
      public void setBlauweBlokken(int aantal){
        int a =0;
        while(a < aantal){
            for(int x=0;x<xHor;x++){
                for(int y=0;y<yVert;y++){
                    if(spelVakken[x][y].getSpelObject()==null && random.nextInt(30)==1 && a < aantal){
                        spelVakken[x][y].setSpelObject(new BlauweBlok(spelVakken[x][y], this));
                        //System.out.println(x+","+y);

                        a++;
                    }
                }
            }
        }
    }

      /**
       * @param richting De richting die de mens op moet
       * @return True als verplaatsen gelukt is anders false
       */
    public boolean verplaatsMens(String richting){
        if(mens.verplaats(richting)){
            return true;
        }
        return false;
    }

    public void verplaatsHapper(){
        if(happer.isIngesloten()) gameOver("Je hebt gewonnen!");
        happer.zoekMens();

    }

    public void gameOver(String commentaar){
        //System.out.println(commentaar);
        JOptionPane.showMessageDialog(null, commentaar);
        resetSpel();
    }

    public boolean getGestart(){
        return gestart;
    }

    public int getXHor(){
        return xHor;
    }

    public int getYVert(){
        return yVert;
    }

    public void setXHor(int xHor){
        this.xHor = xHor;
    }

    public void setYVert(int yVert){
        this.yVert = yVert;
    }

    public int getAantalZwarteBlokken(){
        return zwarteBlokken;
    }

    public int getAantalBlauweBlokken(){
        return blauweBlokken;
    }

    public void setAantalZwarteBlokken(int zwarteBlokken){
        this.zwarteBlokken = zwarteBlokken;
    }

    public void setAantalBlauweBlokken(int blauweBlokken){
        this.blauweBlokken = blauweBlokken;
    }

    public Mens getMens(){
        return mens;
    }

    public Happer getHapper(){
        return happer;
    }

    public String[] getRichtingen(){
        return richtingen;
    }
    public Vak[][] getSpelVakken(){
        return spelVakken;
    }


}
