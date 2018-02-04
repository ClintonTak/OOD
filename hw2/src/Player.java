package hw2;

import java.util.ArrayList;

public interface Player {
    //Constants

    //Methods
    boolean playTurn();
    int getChipCount();
    int getNumberOfDiceRolled();
    int doTurn(int numberOfChipsInPot, int firstPlaceChipCount);

    void setNumberOfChips(int numberOfChips);
    String getPlayerID();



}
