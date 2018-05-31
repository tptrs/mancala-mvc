package nl.sogyo.mancalamaven.domain;

abstract public class Field {
    
    protected int stones;
    protected Player owner;
    protected Field nextField;
    
    Field(int stones, Player owner) {
        if(stones < 0) throw new IllegalArgumentException("number of stones should be positive");
        if(owner == null) throw new IllegalArgumentException("player cannot be null");
        this.stones = stones;
        this.owner = owner;
    }

    public int getStoneCount() {
        return stones;
    }
    
    protected void receiveStones(int received){
        if(received < 0) throw new IllegalArgumentException("the number of stones received should be positive");
        stones += received;
    }
    
    public Player getOwner(){
        return owner;
    }
    
    protected abstract void passStones(int stones);
    
    protected Field getNextField(){
        return nextField;
    }
    
    public Field findNthField(int n){
        if(n == 1) return this;
        else return nextField.findNthField(--n);
    }
    
    protected boolean opponentHasMoves(){
        return nextField.opponentHasMoves(owner, 0);
    }
    
    protected boolean opponentHasMoves(Player player, int count){
        if(count == 6) return false;
        else if(owner != player && stones > 0) return true;
        else if(owner != player) count++;
        return nextField.opponentHasMoves(player, count);
    }
    
    abstract protected boolean isKalaha();
    
    abstract protected boolean isBowl();
    
    abstract protected Kalaha findKalaha();
    
    abstract protected Field findOppositeField();
    
    abstract protected void emptyAllBowls(int count);
    
    protected void emptyAllBowls(){
        emptyAllBowls(1);
    }
}