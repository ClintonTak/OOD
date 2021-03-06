package hw2;

import java.util.ArrayList;

public class CraftyPlayer implements Player {
    private int numberOfChips;
    private int numberOfDiceRolled;
    private String playerID;
    public CraftyPlayer(int player_ID) {
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Crafty Player " + Integer.toString(player_ID);

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
                System.out.printf("%s Aced out\n\n\n", playerID, numberOfChips);
                numberOfDiceRolled = 1;
                return -1;
            }
            else if (numberOfChipsInPot + numberOfChips > firstPlaceChipCount){//takes pot
                numberOfChips = numberOfChips + numberOfChipsInPot;
                numberOfDiceRolled = 1;
                System.out.printf("%s decided to take the pot. It now has %d chips.\n\n\n", playerID, numberOfChips);
                return 1;
            }
            numberOfDiceRolled ++;
            diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        }
    }
}
