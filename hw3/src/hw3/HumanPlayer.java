package hw3;

import java.lang.reflect.Array;
import java.util.*;
public class HumanPlayer extends Player{
    public HumanPlayer(int player_ID){
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Human Player " + Integer.toString(player_ID);
    }

    public int getInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("If you want to roll again, enter 1, if you want to take the chips currently in the pot press 2.");
        int choice = reader.nextInt();
        if (choice == 2){//take the pot
            numberOfDiceRolled = 1;
        }
        else if (choice == 1){//rolls again
            System.out.println("You want to roll again.");
            numberOfDiceRolled++;
        }
        return choice;
    }

    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){
        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        if (diceOutcomes.contains(1)){//player rolled a one and their turn is over
            numberOfDiceRolled = 1;
            System.out.printf("You aced out. You have %d chips.\n\n\n", numberOfChips);
            return -1;
        }
        else{//player can keep going
            if (diceOutcomes.size() == 1){
                System.out.printf("You rolled 1 die and your outcome was: %s\n", diceOutcomes.toString());
            }
            else{
                System.out.printf("You rolled %d dice and your outcomes were: %s\n", diceOutcomes.size(), diceOutcomes.toString());
            }
            int input = getInput();
            if (input == 2){//takes the pot
                numberOfChips = numberOfChips + numberOfChipsInPot;
                System.out.printf("You want to take the pot. You now have %d chips.\n\n\n", numberOfChips);
            }
            return input;
        }
    }
}
