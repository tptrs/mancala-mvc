package nl.sogyo.mancalamaven.domain;

public class Player {
    
    private boolean turn;
    private Player opponent;
    
    public Player(){
        this.turn = true;
        opponent = new Player(this);
    }
    
    public Player(Player opponent){
        this.turn = false;
        this.opponent = opponent;
    }

    public boolean getTurn() {
        return turn;
    }
    
    public Player getOpponent(){
        return opponent;
    }
    
    public void switchTurn(){
        turn = !turn;
        if(turn == opponent.getTurn()) opponent.switchTurn();
    }
}