package hw2;
import java.util.*;
public class HW2DiceGame {
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Dice Game! \nEnter the number of human players you want here and then press enter: ");
        int humanPlayerCount = reader.nextInt();
        System.out.println("Now enter the number of timid computer players: ");
        int timidPlayerCount = reader.nextInt();
        System.out.println("Now Enter the number of crafty computer players: ");
        int craftyPlayerCount = reader.nextInt();
        System.out.printf("You have selected %d human player/s, %d timid computer player/s, and %d crafty computer player/s.\n\n\n",
                humanPlayerCount, timidPlayerCount, craftyPlayerCount);

        //TODO: move this to the game class and have the game class take in names, num of timid players and number of crafty players
        Game game = new Game(humanPlayerCount, timidPlayerCount, craftyPlayerCount);
    }
}