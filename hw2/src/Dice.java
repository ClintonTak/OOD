package hw2;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    public static ArrayList<Integer> rollDice(int numberOfDiceRolled){
        ArrayList<Integer> outcomesList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfDiceRolled; i ++){
            Integer rollOutcome = random.nextInt(4) + 1; //diceroll between 1 and 4 inclusive
            outcomesList.add(rollOutcome);
        }
        return outcomesList;
    }
}
