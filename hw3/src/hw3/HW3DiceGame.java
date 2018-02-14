package hw3;

import java.util.*;
import java.io.*;
public class HW3DiceGame {

    public static void main(String args[]){
        Game game = new Game();
        File file = new File("test.txt");
        String name;
        int type;
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Dice Game! \nEnter the names of all the players you want here (separated by a comma and a space) and then press enter: ");
        String[] namesArray = reader.nextLine().split(",\\s");
        for (int i = 0; i <namesArray.length ; i++) {
            name = namesArray[i];
            if (!game.addKnownPlayer(name)){
                System.out.printf("If %s is a human, press 1 and enter, if they are a timid computer, enter 2, and if they are a crafty computer enter 3.\n", name);
                type = reader.nextInt();
                game.addPlayer(name, type);
            }
        }

        game.play();
        game.savePlayerRecords();
        //TODO: move this to the game class and have the game class take in names, num of timid players and number of crafty players

    }
}


