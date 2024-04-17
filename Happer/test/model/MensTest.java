/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class MensTest {
    Vak vak1, vak2, vak3;
    Mens mens;
    BlauweBlok bBlok;
    ZwarteBlok zBlok;

    public MensTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        vak1 = new Vak(0,0);
        mens = new Mens(vak1, null);
        vak1.setSpelObject(mens);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void geval1(){

        assertFalse(mens.verplaats("rechts"));

    }

    @Test
    public void geval2(){
        vak2 = new Vak(0,1);
        vak1.setBuren("rechts", vak2);
        assertTrue(mens.verplaats("rechts"));
    }

    @Test
    public void geval3(){
        vak2 = new Vak(0,1);
        bBlok = new BlauweBlok(vak2, null);
        vak2.setSpelObject(bBlok);

        vak1.setBuren("rechts", vak2);
        assertTrue(mens.verplaats("rechts"));
    }

    @Test
    public void geval4(){
        vak2 = new Vak(0,1);
        zBlok = new ZwarteBlok(vak2, null);
        vak2.setSpelObject(zBlok);

        vak1.setBuren("rechts", vak2);
        assertFalse(mens.verplaats("rechts"));
    }





}