/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.sogyo.mancalamaven.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Timo
 */
public class MancalaTest {
    
    private Bowl bowl1;
    
    public MancalaTest(){
        
    }
    
    @Before
    public void initialize(){
        bowl1 = new Bowl(4);
    }
    
    @Test
    public void testMultipleMoves(){
        Bowl bowl2 = (Bowl) bowl1.findNthField(2);
        Bowl bowl3 = (Bowl) bowl1.findNthField(3);
        Bowl bowl4 = (Bowl) bowl1.findNthField(4);
        Bowl bowl5 = (Bowl) bowl1.findNthField(5);
        Bowl bowl6 = (Bowl) bowl1.findNthField(6);
        Kalaha bowl7 = (Kalaha) bowl1.findNthField(7);
        Bowl bowl8 = (Bowl) bowl1.findNthField(8);
        Bowl bowl9 = (Bowl) bowl1.findNthField(9);
        Bowl bowl10 = (Bowl) bowl1.findNthField(10);
        Bowl bowl11 = (Bowl) bowl1.findNthField(11);
        Bowl bowl12 = (Bowl) bowl1.findNthField(12);
        Bowl bowl13 = (Bowl) bowl1.findNthField(13);
        Kalaha bowl14 = (Kalaha) bowl1.findNthField(14);
        bowl3.emptyAndPassStones();
        bowl1.emptyAndPassStones();
        bowl12.emptyAndPassStones();
        bowl2.emptyAndPassStones();
        bowl1.emptyAndPassStones(); // should not do this, not his turn
        bowl10.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl5.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl12.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl9.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl8.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl12.emptyAndPassStones();
        bowl13.emptyAndPassStones();
        bowl10.emptyAndPassStones();
        bowl3.emptyAndPassStones();
        bowl9.emptyAndPassStones();
        bowl2.emptyAndPassStones();
        bowl12.emptyAndPassStones();
        bowl5.emptyAndPassStones();
        
        
        
        assertEquals(26, bowl14.getStoneCount());
        assertEquals(22, bowl7.getStoneCount());
        
    }
}
