package hw2;

import java.util.ArrayList;
import java.util.Random;

public class CraftyPlayer implements Player {
    private int numberOfChips;
    private int numberOfDiceRolled;
    private String playerID;
    public CraftyPlayer(int PLAYERID){
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Crafty Player " + Integer.toString(PLAYERID);

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

    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){//only takes pot if it has more chips than anyone else
        numberOfDiceRolled = 1;
        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        while (true){//must roll until they ace out or the number of chips makes them in first place
            if (diceOutcomes.contains(1)){//player rolled a one and their turn is over
                return -1;
            }
            else if (numberOfChipsInPot + numberOfChips > firstPlaceChipCount){//takes pot
                return 1;
            }
            //reroll
            numberOfDiceRolled ++;
            diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        }
    }
}
