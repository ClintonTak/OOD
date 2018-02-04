package hw2;
import java.lang.reflect.Array;
import java.util.*;
public class HumanPlayer implements Player{


    private int numberOfChips;
    private int numberOfDiceRolled;
    private String playerID;
    public HumanPlayer(int PLAYERID){
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        playerID = "Human Player " + Integer.toString(PLAYERID);
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

    public String getPlayerID(){
        return playerID;
    }

    public int getNumberOfDiceRolled() {
        return numberOfDiceRolled;
    }



    public int getInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("If you want to roll again, enter 1, if you want to take the chips currently in the pot press 2.");
        int choice = reader.nextInt();
        if (choice == 2){
            numberOfDiceRolled = 1;
        }
        else if (choice == 1){
            numberOfDiceRolled++;
        }
        return choice;
    }

    public int doTurn(int numberOfChipsInPot, int firstPlaceChipCount){
        ArrayList<Integer> diceOutcomes = Dice.rollDice(numberOfDiceRolled);
        if (diceOutcomes.contains(1)){//player rolled a one and their turn is over
            numberOfDiceRolled = 1;
            return -1;
        }
        else{//player can keep going
            if (diceOutcomes.size() == 1){
                System.out.printf("You rolled 1 die and your outcome was: %s\n", diceOutcomes.toString());
            }
            else{
                System.out.printf("You rolled %d dice and your outcomes were: %s\n", diceOutcomes.size(), diceOutcomes.toString());
            }

            return getInput();
        }
    }
}
