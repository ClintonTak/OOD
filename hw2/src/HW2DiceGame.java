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
        System.out.printf("You have selected %d human player/s, %d timid computer player/s, and %d crafty computer player/s.",
                humanPlayerCount, timidPlayerCount, craftyPlayerCount);

    }


}