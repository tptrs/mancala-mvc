package nl.sogyo.mancalamaven.domain;

public class Bowl extends Field {
    
    protected Bowl(Bowl firstBowl, Player owner, int count) {
        super(firstBowl.getStoneCount(), owner);
        if ((count + 1) % 7 == 0) nextField = new Kalaha(firstBowl, owner, ++count);
        else nextField = new Bowl(firstBowl, owner, ++count);
        
    }

    public Bowl(int startAmountStones) {
        super(startAmountStones, new Player());
        nextField = new Bowl(this, owner, 2);
    }

    @Override
    protected void passStones(int stonesPassed) {
        receiveStones(1);
        if (stonesPassed > 1) {
            nextField.passStones(--stonesPassed);
            return;
        }else if (owner.getTurn()) {
            checkEndInEmptyBowl();
            checkEndOfGame();
        }

        owner.switchTurn();
    }

    private void checkEndOfGame() {
        if (!opponentHasMoves()) emptyAllBowls();
    }

    private void checkEndInEmptyBowl() {
        if (stones > 1) return;
        Kalaha kalaha = findKalaha();
        Bowl oppositeBowl = (Bowl) findOppositeField();
        oppositeBowl.emptyToKalaha(kalaha);
        emptyToKalaha(kalaha);
    }

    public void emptyAndPassStones() {
        if (stones == 0 || !owner.getTurn()) return;
        int passed = stones;
        stones = 0;
        nextField.passStones(passed);
    }

    @Override
    public Kalaha findKalaha() {
        return nextField.findKalaha();
    }

    protected void emptyToKalaha(Kalaha kalaha) {
        kalaha.receiveStones(stones);
        stones = 0;
    }
    
    @Override
    protected Field findOppositeField() {
        return nextField.findOppositeField().getNextField();
    }

    @Override
    protected void emptyAllBowls(int count) {
        if (count > 14) return;
        emptyToKalaha(findKalaha());
        nextField.emptyAllBowls(++count);
    }

    @Override
    protected boolean isBowl() {
        return true;
    }

    @Override
    protected boolean isKalaha() {
        return false;
    }
}
