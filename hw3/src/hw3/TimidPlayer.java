package hw3;

import java.util.ArrayList;

public class TimidPlayer extends Player{

    public TimidPlayer(int player_ID){
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Timid Player " + Integer.toString(player_ID);

    }

    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){//only takes the pot
        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        if (diceOutcomes.contains(1)){//player rolled a one and their turn is over
            numberOfDiceRolled = 1;
            System.out.printf("%s aced out. It has %d chips.\n\n\n", playerID, numberOfChips);
            return -1;
        }
        numberOfChips = numberOfChips + numberOfChipsInPot ;
        System.out.printf("%s decided to take the pot. It now has %d chips.\n\n\n", playerID, numberOfChips);
        return 1;
    }


}
