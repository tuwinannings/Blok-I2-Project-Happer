/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 09068007
 */
public class SlimmeHapperTest {
    Happer happer;
    Mens mens;
    Spel spel;
    ZwarteBlok zwarteblok;
    BlauweBlok blauweblok;

    public SlimmeHapperTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        spel = new Spel();
        spel.setXHor(3);
        spel.setYVert(3);
        spel.setAantalBlauweBlokken(0);
        spel.setAantalZwarteBlokken(0);
        spel.setVakken();
        spel.setBuren();

        happer = new SlimmeHapper(spel.getSpelVakken()[2][2], spel);
        spel.setHapper(happer);
        spel.getSpelVakken()[2][2].setSpelObject(happer);
        mens = new Mens(spel.getSpelVakken()[0][0], spel);
        spel.setMens(mens);
        spel.getSpelVakken()[0][0].setSpelObject(mens);
        
        
        blauweblok = new BlauweBlok(spel.getSpelVakken()[0][1],spel);
        spel.getSpelVakken()[0][1].setSpelObject(blauweblok);
        zwarteblok = new ZwarteBlok(spel.getSpelVakken()[1][1],spel);
        spel.getSpelVakken()[1][1].setSpelObject(zwarteblok);


    }

    @After
    public void tearDown() {
    }

    /**
     * Test of zoekMens method, of class SlimmeHapper.
     */
    @Test
    public void testZoekMens() {
        assertTrue(happer.zoekMens());
        assertTrue(happer.zoekMens());
        assertTrue(happer.zoekMens());
        assertTrue(happer.zoekMens());
    }

}