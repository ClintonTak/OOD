package hw3;

import java.util.*;
public class Game {
    private ArrayList<Player> playerArrayList = new ArrayList<>();

    public Game(int numberOfHumanPlayers, int numberOfTimidPlayers, int numberOfCraftyPlayers){
        Pot pot = new Pot();
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
            System.out.printf("It is currently %s's turn. They have %d chip/s.\n", player.getPlayerID(), player.getChipCount());
            if (player instanceof HumanPlayer){
                while(true) {
                    pot.processOneTurn(player.getNumberOfDiceRolled());
                    int humanChoice = player.doTurn(pot.getNumberOfChips(), currentHighest);
                    if (humanChoice == -1){//human aced out
                        break;
                    }
                    if (humanChoice == 2){//human decides to take the pot
                        player.setNumberOfChips(player.getChipCount() + pot.getNumberOfChips());
                        pot.setNumberOfChips(0);
                        break;
                    }
                }
            }
            else{//computer player's turn
                while(true) {
                    pot.processOneTurn(player.getNumberOfDiceRolled());
                    if (player.doTurn(pot.getNumberOfChips(), currentHighest) == -1) {//ace out
                        break;
                    }
                    else {
                        player.setNumberOfChips(player.getChipCount() + pot.getNumberOfChips());//takes chips
                        pot.setNumberOfChips(0);
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
