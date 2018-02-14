package hw3;
import java.util.ArrayList;

public class CraftyPlayer extends Player {

    public CraftyPlayer(String player_ID) {
        //playerID = player_ID;
        super(player_ID);
        playerType = 3;
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
