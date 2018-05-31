package nl.sogyo.mancalamaven.domain;

//package mancala.domain;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class FieldTest {
//    
//    public FieldTest() {
//    }
//    
//    @Test
//    public void testConstructorAndGetStoneCount() {
//        int stones = 4;
//        Field field = new Field(stones, new Player());
//        assertEquals(stones, field.getStoneCount());
//    }
//    
//    @Test
//    public void testConstructorAndGetStoneCount2() {
//        int stones = 5;
//        Field field = new Field(stones, new Player());
//        assertEquals(stones, field.getStoneCount());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorShouldNotAcceptNegatives(){
//        Field field = new Field(-1, new Player());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorShouldNotAcceptNegatives2(){
//        Field field = new Field(-10000, new Player());
//    }
//    
//    @Test
//    public void testIfStonesCanBeReceived(){
//        int stones = 2;
//        Field field = new Field(0, new Player());
//        field.receiveStones(stones);
//        assertEquals(stones, field.getStoneCount());
//    }
//    
//    @Test
//    public void testIfStonesCanBeReceived2(){
//        int stones = 3;
//        Field field = new Field(0, new Player());
//        field.receiveStones(stones);
//        assertEquals(stones, field.getStoneCount());
//    }
//    
//    @Test
//    public void testIfStonesCanBeReceived3(){
//        int stones = 3;
//        Field field = new Field(1, new Player());
//        field.receiveStones(stones);
//        assertEquals(stones + 1, field.getStoneCount());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testThatNoNegativeAmountOfStonesCanBeReceived(){
//        Field field = new Field(0, new Player());
//        field.receiveStones(-1);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testThatNoNegativeAmountOfStonesCanBeReceived2(){
//        Field field = new Field(0, new Player());
//        field.receiveStones(-100);
//    }
//    
//    @Test
//    public void testConstructorAndGetOwner(){
//        Player player = new Player();
//        Field field = new Field(0,player);
//        assertEquals(player, field.getOwner());
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorDoesNotAcceptNullForPlayer(){
//        Field field = new Field(0,null);
//    }
//}
