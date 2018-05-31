package nl.sogyo.mancalamaven;

import java.util.ArrayList;
import java.util.List;
import nl.sogyo.mancalamaven.domain.Bowl;
import nl.sogyo.mancalamaven.domain.Field;

public class Mancala {
    
    List<Field> bowls;
    
    public Mancala(){
	this(4);
    }
    
    public Mancala(int stones){
        Bowl bowl1 = new Bowl(stones);
        bowls = new ArrayList<>();
        for(int i = 1; i <= 14; i++){
            bowls.add(bowl1.findNthField(i));
        }
    }

    public List<Field> getBowls() {
        return bowls;
    }
    
    public boolean gameOver(){
        boolean gameOver = true;
        for(int i = 0; i < 13; i++){
            if(i==6) continue;
            if(bowls.get(i).getStoneCount() != 0) gameOver = false;
        }
        return gameOver;
    }
    
    public static void main(String... args){
        Mancala mancala = new Mancala(4);
        System.out.println(mancala.getBowls().get(7).getStoneCount());
    }
    
    public int getField1(){
        return bowls.get(0).getStoneCount();
    }
    public int getField2(){
        return bowls.get(1).getStoneCount();
    }
    public int getField3(){
        return bowls.get(2).getStoneCount();
    }
    public int getField4(){
        return bowls.get(3).getStoneCount();
    }
    public int getField5(){
        return bowls.get(4).getStoneCount();
    }
    public int getField6(){
        return bowls.get(5).getStoneCount();
    }
    public int getField7(){
        return bowls.get(6).getStoneCount();
    }
    public int getField8(){
        return bowls.get(7).getStoneCount();
    }
    public int getField9(){
        return bowls.get(8).getStoneCount();
    }
    public int getField10(){
        return bowls.get(9).getStoneCount();
    }
    public int getField11(){
        return bowls.get(10).getStoneCount();
    }
    public int getField12(){
        return bowls.get(11).getStoneCount();
    }
    public int getField13(){
        return bowls.get(12).getStoneCount();
    }
    public int getField14(){
        return bowls.get(13).getStoneCount();
    }
}
