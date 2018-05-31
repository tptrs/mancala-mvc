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
public class PlayerTest {
    
    private Player firstPlayer;
    
    public PlayerTest() {
    }
    
    @Before
    public void initialize(){
        firstPlayer = new Player();
    }
    
    @Test
    public void testFirstPlayerHasTurn() {
        assertTrue(firstPlayer.getTurn());
    }
    
    @Test
    public void testSecondPlayerNotTurn(){
        assertFalse(firstPlayer.getOpponent().getTurn());
    }
    
    @Test
    public void testSecondPlayersOpponentIsFirstPlayer(){
        assertEquals(firstPlayer, firstPlayer.getOpponent().getOpponent());
    }
    
    @Test
    public void testFirstPlayerLosesTurnWhenSwitched(){
        firstPlayer.switchTurn();
        assertFalse(firstPlayer.getTurn());
    }
    
    @Test
    public void testSecondPlayerGainsTurnWhenSwitched(){
        firstPlayer.switchTurn();
        assertTrue(firstPlayer.getOpponent().getTurn());
    }
}
