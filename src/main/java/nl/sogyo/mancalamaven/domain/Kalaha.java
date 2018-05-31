package nl.sogyo.mancalamaven.domain;


public class Kalaha extends Field{
    
    protected Kalaha(Bowl firstBowl, Player owner, int count) {
        super(0, owner);
        if(count == 7) nextField = new Bowl(firstBowl, owner.getOpponent(), ++count);
        else nextField = firstBowl;
    }

    @Override
    protected void passStones(int stonesPassed) {
        if(!owner.getTurn()){
            nextField.passStones(stonesPassed);
            return;
        }
        receiveStones(1);
        if(stonesPassed > 1) nextField.passStones(--stonesPassed);
        else if(!nextField.opponentHasMoves()) emptyAllBowls();
    }
    
    @Override
    protected boolean isBowl() {
        return false;
    }

    @Override
    protected boolean isKalaha() {
        return true;
    }

    @Override
    protected Kalaha findKalaha() {
        return this;
    }

    @Override
    protected Field findOppositeField() {
        return this;
    }

    @Override
    protected void emptyAllBowls(int count) {
        nextField.emptyAllBowls(++count);
    }
}