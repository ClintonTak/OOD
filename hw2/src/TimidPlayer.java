package hw2;

import java.util.ArrayList;
import java.util.Random;

public class TimidPlayer implements Player{
    private int numberOfChips;
    private int numberOfDiceRolled;
    private String playerID;

    public TimidPlayer(int PLAYERID){
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Timid Player " + Integer.toString(PLAYERID);

    }
    public boolean playTurn(){
        return true;
    }

    public int getChipCount(){
        return numberOfChips;
    }
    public void setNumberOfChips(int numberOfChips) {
        this.numberOfChips = numberOfChips;
    }
    public int getNumberOfDiceRolled() {
        return numberOfDiceRolled;
    }

    public String getPlayerID(){
        return playerID;
    }
    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){//only takes the pot

        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        if (diceOutcomes.contains(1)){//player rolled a one and their turn is over
            numberOfDiceRolled = 1;
            return -1;
        }

        return 1;
    }


}
