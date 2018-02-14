package hw3;
import java.util.*;

public class HumanPlayer extends Player{

    public HumanPlayer(String player_ID){
        super(player_ID);
        playerType = 1;
    }

    public int getInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("If you want to take the pot, enter 1, if you want to roll again press 2.");
        int choice = reader.nextInt();
        if (choice == 1){//take the pot
            numberOfDiceRolled = 1;
        }
        else if (choice == 2){//rolls again
            System.out.println("You want to roll again.");
            numberOfDiceRolled++;
        }
        return choice;
    }

    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){
        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        while(!diceOutcomes.contains(1)){
            int input = getInput();
            if (input == 1) {//takes the pot
                numberOfChips = numberOfChips + numberOfChipsInPot;
                System.out.printf("You want to take the pot. You now have %d chips.\n\n\n", numberOfChips);
                return input;
            }
            else if (diceOutcomes.size() == 2){//rolls again
                diceOutcomes = Dice.rollDice(numberOfDiceRolled);
                System.out.printf("You rolled 1 die and your outcome was: %s\n", diceOutcomes.toString());
            }
            else{
                diceOutcomes = Dice.rollDice(numberOfDiceRolled);
                System.out.printf("You rolled %d dice and your outcomes were: %s\n", diceOutcomes.size(), diceOutcomes.toString());
            }

        }
        //aced out
        numberOfDiceRolled = 1;
        System.out.printf("You aced out. You have %d chips.\n\n\n", numberOfChips);
        return -1;
    }
}
