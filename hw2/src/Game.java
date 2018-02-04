package hw2;
import java.util.*;
public class Game {

    public int chipsInPot;
    private ArrayList<Player> playerArrayList = new ArrayList<>();
    public Game(int numberOfHumanPlayers, int numberOfTimidPlayers, int numberOfCraftyPlayers){
        chipsInPot = 0;
        for (int i = 0; i < numberOfHumanPlayers; i++){
            playerArrayList.add(new HumanPlayer(i));
        }
        for (int i = 0; i < numberOfTimidPlayers; i++){
            playerArrayList.add(new TimidPlayer(i));
        }
        for (int i = 0; i < numberOfCraftyPlayers; i++){
            playerArrayList.add(new CraftyPlayer(i));
        }
        int i = 0;
        while(!winConditionSatisfied()){
            int currentHighest =  findFirstPlaceChipCount();
            int currentPlayerTurn = i % playerArrayList.size();
            Player player = playerArrayList.get(currentPlayerTurn);
            System.out.printf("It is currently %s's turn.\n", player.getPlayerID());
            if (player instanceof HumanPlayer){
                while(true) {// move this to humanPlayer
                    processOneTurn(player.getNumberOfDiceRolled());
                    int humanChoice = player.doTurn(chipsInPot, currentHighest);
                    if (humanChoice == -1){
                        System.out.printf("You aced out. You have %d chips.\n\n\n", player.getChipCount());
                        break;
                    }
                    else if (humanChoice == 1){
                        System.out.println("You want to roll again.");
                    }
                    else{
                        player.setNumberOfChips(player.getChipCount() + chipsInPot);
                        chipsInPot = 0;
                        System.out.printf("You want to take the pot. You now have %d chips.\n\n\n", player.getChipCount() );
                        break;
                    }
                }
            }
            else if (player instanceof TimidPlayer){
                System.out.println("Running Timid Players Turn.");
                while(true) {
                    processOneTurn(player.getNumberOfDiceRolled());
                    if (player.doTurn(chipsInPot, currentHighest) == -1) {
                        System.out.printf("%s aced out. It has %d chips.\n\n\n", player.getPlayerID(), player.getChipCount());
                        break;
                    }
                    else {
                        player.setNumberOfChips(player.getChipCount() + chipsInPot);
                        chipsInPot = 0;
                        System.out.printf("%s decided to take the pot. It now has %d chips.\n\n\n", player.getPlayerID(), player.getChipCount());
                        break;
                    }
                }
            }
            else{
                while(true){
                    processOneTurn(player.getNumberOfDiceRolled());
                    System.out.println("Running Crafty Players turn.");
                    if (player.doTurn(chipsInPot, currentHighest) == -1){//ace out
                        System.out.printf("%s Aced out\n\n\n", player.getPlayerID(), player.getChipCount());
                        break;
                    }
                    else{//decides to take the pot
                        player.setNumberOfChips(player.getChipCount() + chipsInPot);
                        chipsInPot = 0;
                        System.out.printf("%s decided to take the pot. It now has %d chips.\n\n\n", player.getPlayerID(), player.getChipCount());
                        break;
                    }
                }
            }
            i++;
        }
    }
    private int findFirstPlaceChipCount(){
        int currentHighestChipCount = 0;
        for (int i = 0; i <playerArrayList.size() ; i++) {
            if (playerArrayList.get(i).getChipCount() > currentHighestChipCount){
                currentHighestChipCount = playerArrayList.get(i).getChipCount();
            }
        }
        return currentHighestChipCount;
    }
    public void processOneTurn(int incrementAmount){
        chipsInPot = chipsInPot + incrementAmount;
        System.out.printf("There are currently %d chips in the pot.\n", chipsInPot);
    }

    private boolean winConditionSatisfied(){
        for (int i = 0; i < playerArrayList.size(); i++){
            if (playerArrayList.get(i).getChipCount()>29){
                System.out.printf("Player %s has won with %d chips!", playerArrayList.get(i).getPlayerID(), playerArrayList.get(i).getChipCount());
                return true;
            }
        }
        return false;
    }
}
