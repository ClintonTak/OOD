package hw3;

import java.util.*;
public class HW3DiceGame {

    public static void main(String args[]){
        private GameConnection conn = new GameConnection("clintonTakGameFile00.info");
        private Map<String,Player> players = conn.getMap();

        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Dice Game! \nEnter the names of human all the  human players you want here (separated by a comma and a space) and then press enter: ");
        String[] namesArray = reader.nextLine().split(",\\s");
        System.out.println("Now enter the number of timid computer players: ");
        int timidPlayerCount = reader.nextInt();
        System.out.println("Now Enter the number of crafty computer players: ");
        int craftyPlayerCount = reader.nextInt();
        //System.out.printf("You have selected %d human player/s, %d timid computer player/s, and %d crafty computer player/s.\n\n\n",
                //humanPlayerCount, timidPlayerCount, craftyPlayerCount);

        //TODO: move this to the game class and have the game class take in names, num of timid players and number of crafty players
        //Game game = new Game(humanPlayerCount, timidPlayerCount, craftyPlayerCount);
    }
}


