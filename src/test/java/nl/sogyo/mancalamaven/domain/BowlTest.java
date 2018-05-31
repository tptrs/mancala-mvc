package nl.sogyo.mancalamaven.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BowlTest {
    
    private Bowl firstBowl;
    
    public BowlTest() {
    }
    
    @Before
    public void initialize(){
        firstBowl = new Bowl(4);
    }
    
    @Test
    public void test7thFieldIsAKalaha() {
        Field field7 = firstBowl.findNthField(7);
        assertTrue(field7.getClass().equals(Kalaha.class));
    }
    
    @Test
    public void test14thFieldIsAKalaha() {
        Field field14 = firstBowl.findNthField(14);
        assertTrue(field14.getClass().equals(Kalaha.class));
    }
    
    @Test
    public void test15thFieldIsField1() {
        Field field15 = firstBowl.findNthField(15);
        assertTrue(firstBowl == field15);
    }
    
    @Test
    public void testPassOneToReceiveOne(){
        int stonesInFirstBowl = firstBowl.getStoneCount();
        firstBowl.passStones(1);
        assertEquals(stonesInFirstBowl + 1, firstBowl.getStoneCount());
    }
    
    @Test
    public void testPassOneDoesNotAddToNextField(){
        Field secondField = firstBowl.getNextField();
        int stonesInSecondField = secondField.getStoneCount();
        firstBowl.passStones(1);
        assertEquals(stonesInSecondField, secondField.getStoneCount());
    }
    
    @Test
    public void testIfTurnIsSwitchedWhenEndingInBowl(){
        Player player = firstBowl.getOwner();
        boolean turn = player.getTurn();
        firstBowl.passStones(1);
        assertNotEquals(turn, player.getTurn());
    }
    
    @Test
    public void testIfBowlEmptyAfterEmptyAndPass(){
        firstBowl.emptyAndPassStones();
        assertEquals(0, firstBowl.getStoneCount());
    }
    
    @Test
    public void testEmptyAndPassNotExecutedIfEmpty(){
        Player player = firstBowl.getOwner();
        boolean turn = player.getTurn();
        firstBowl.stones = 0;
        firstBowl.emptyAndPassStones();
        assertEquals(turn, player.getTurn());
    }
    
    @Test
    public void testSixthBowlNotAffectedByEmptyAndPass(){
        Field sixthField = firstBowl.findNthField(6);
        int sixthFieldStones = sixthField.getStoneCount();
        firstBowl.emptyAndPassStones();
        assertEquals(sixthFieldStones, sixthField.getStoneCount());
    }
    
    @Test
    public void testFifthBowlReceivesOneByEmptyAndPass(){
        Field fifthField = firstBowl.findNthField(5);
        int fifthFieldStones = fifthField.getStoneCount();
        firstBowl.emptyAndPassStones();
        assertEquals(fifthFieldStones + 1, fifthField.getStoneCount());
    }
    
    @Test
    public void testFindKalahaFindsNextKalahaSideOne(){
        Kalaha kalaha = firstBowl.findKalaha();
        Field seventhField = firstBowl.findNthField(7);
        assertEquals(seventhField, kalaha);
    }
    
    @Test
    public void testFindKalahaFindsNextKalahaSideTwo(){
        Field eightField = firstBowl.findNthField(8);
        Kalaha kalaha = ((Bowl) eightField).findKalaha();
        Field fourteenthField = firstBowl.findNthField(14);
        assertEquals(fourteenthField, kalaha);
    }
    
    @Test
    public void testEmptyToKalahaEmptiesBowl(){
        int stonesInFirstBowl = firstBowl.getStoneCount();
        firstBowl.emptyToKalaha(firstBowl.findKalaha());
        assertEquals(0, firstBowl.getStoneCount());
    }
    
    @Test
    public void testEmptyToKalahaChangesStonesKalaha(){
        int stonesInFirstBowl = firstBowl.getStoneCount();
        Kalaha kalaha = firstBowl.findKalaha();
        int stonesInKalaha = kalaha.getStoneCount();
        firstBowl.emptyToKalaha(firstBowl.findKalaha());
        assertEquals(stonesInFirstBowl + stonesInKalaha, kalaha.getStoneCount());
    }
    
    @Test
    public void testFindOppositeBowlFindsOpposite(){
        Field opposite = firstBowl.findOppositeField();
        Field bowl13 = firstBowl.findNthField(13);
        assertEquals(opposite, bowl13);
    }
    
    @Test
    public void testFindOppositeBowlFindsOpposite2(){
        Field bowl6 = firstBowl.findNthField(6);
        Field opposite = bowl6.findOppositeField();
        Field bowl10 = firstBowl.findNthField(8);
        assertEquals(opposite, bowl10);
    }
    
    @Test
    public void testFindNthField(){
        Field field4 = firstBowl.findNthField(4);
        assertEquals(firstBowl.getNextField().getNextField().getNextField(), field4);
    }
    
    @Test
    public void testBowlEmptiedIfEndingInEmptyOwnBowl(){
        Bowl bowl4 = (Bowl) firstBowl.findNthField(4);
        bowl4.stones = 0;
        bowl4.passStones(1);
        assertEquals(0, bowl4.stones);
    }
    
    @Test
    public void testOppositeBowlEmptiedIfEndingInEmptyOwnBowl(){
        Bowl bowl4 = (Bowl) firstBowl.findNthField(4);
        Bowl bowl4Opposite = (Bowl) firstBowl.findNthField(4).findOppositeField();
        bowl4.stones = 0;
        bowl4.passStones(1);
        assertEquals(0, bowl4Opposite.stones);
    }
    
    @Test
    public void testRightAmountIsAddedToKalahaIfEndingInEmptyOwnBowl(){
        Bowl bowl4 = (Bowl) firstBowl.findNthField(4);
        bowl4.stones = 0;
        bowl4.passStones(1);
        assertEquals(5, bowl4.findKalaha().getStoneCount());
    }
    
    @Test
    public void testOpponentHasMoves(){
        assertTrue(firstBowl.opponentHasMoves());
    }
    
    @Test
    public void testOpponentHasMoves2(){
        Bowl firstBowl2 = new Bowl(0);
        assertFalse(firstBowl2.opponentHasMoves());
    }
    
    @Test
    public void testEmptyAllBowlsEmptiesBowls(){
        firstBowl.emptyAllBowls();
        System.out.println(firstBowl.opponentHasMoves());
        assertFalse(firstBowl.opponentHasMoves());
    }
    
    @Test
    public void testEmptyAllBowlsAddsToKalaha(){
        firstBowl.emptyAllBowls();
        Kalaha kalaha = firstBowl.findKalaha();
        assertEquals(24, kalaha.getStoneCount());
    }
    
    @Test
    public void testIfAllBowlsAreEmptiedIfNoMoreOpponentMoves(){
        Bowl firstBowl2 = new Bowl(0);
        firstBowl2.receiveStones(4);
        firstBowl2.nextField.receiveStones(4);
        firstBowl2.emptyAndPassStones();
        assertEquals(0, firstBowl2.nextField.getStoneCount());
    }
    
    @Test
    public void testIfAllBowlsAreEmptiedIfNoMoreOpponentMoves2(){
        Bowl firstBowl2 = new Bowl(0);
        firstBowl2.receiveStones(4);
        firstBowl2.nextField.receiveStones(4);
        firstBowl2.emptyAndPassStones();
        assertEquals(8, firstBowl2.findKalaha().getStoneCount());
    }
}
    

