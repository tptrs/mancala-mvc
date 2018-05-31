/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.sogyo.mancalamaven.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tpeters
 */
public class KalahaTest {
    
    private Bowl firstBowl;
    private Kalaha firstKalaha;
    private Kalaha secondKalaha;
    
    public KalahaTest() {
    }
    
    @Before
    public void initialize(){
        firstBowl = new Bowl(4);
        firstKalaha = (Kalaha) firstBowl.findNthField(7);
        secondKalaha = (Kalaha) firstBowl.findNthField(14);
    }
    
    @Test
    public void testStonesPassedThroughOwnKalahaAddsOne(){
        int stonesInKalaha = firstKalaha.getStoneCount();
        firstKalaha.passStones(2);
        assertEquals(stonesInKalaha + 1, firstKalaha.getStoneCount());
    }
    
    @Test
    public void testStonesPassedThroughOwnKalahaSuccesfullyPasses(){
        Field fieldAfterKalaha = firstKalaha.getNextField();
        int stonesInBowlAfterKalaha = fieldAfterKalaha.getStoneCount();
        firstKalaha.passStones(2);
        assertEquals(stonesInBowlAfterKalaha + 1, fieldAfterKalaha.getStoneCount());
    }
    
    @Test
    public void testStonesPassedThroughOpponentKalahaDoesNotReceive(){
        int stonesInKalaha = secondKalaha.getStoneCount();
        secondKalaha.passStones(1);
        assertEquals(stonesInKalaha, secondKalaha.getStoneCount());
    }
    
    @Test
    public void testEndingInKalahaDoesNotSwitchTurn(){
        Player player = firstKalaha.getOwner();
        boolean turn = player.getTurn();
        firstKalaha.passStones(1);
        assertEquals(turn, player.getTurn());
    }
    
    @Test
    public void testPassingOneToOpponentKalahaDoesSwitchTurn(){
        Player player = secondKalaha.getOwner();
        boolean turn = player.getTurn();
        secondKalaha.passStones(1);
        assertNotEquals(turn, player.getTurn());
    }
    
    @Test
    public void testIfLastStoneInKalahaEndsGame(){
        Bowl firstBowl2 = new Bowl(0);
        Bowl bowl6 = (Bowl) firstBowl2.findNthField(6);
        Bowl bowl9 = (Bowl) firstBowl2.findNthField(9);
        bowl6.receiveStones(1);
        bowl9.receiveStones(5);
        bowl6.emptyAndPassStones();
        assertEquals(0, bowl9.getStoneCount());
    }
}
