package hw3;

import java.io.Serializable;
abstract class Player implements Comparable<Player>, Serializable {
    //Constants
    int numberOfChips;
    int numberOfDiceRolled;
    String playerID;
    //Methods
    public String getPlayerID(){
        return playerID;
    }
    public int getChipCount(){
        return numberOfChips;
    }
    public int getNumberOfDiceRolled() {
        return numberOfDiceRolled;
    }
    public void setNumberOfChips(int numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    abstract int doTurn(int numberOfChipsInPot, int firstPlaceChipCount);
}
