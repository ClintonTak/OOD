package hw3;

import java.util.*;
import java.io.*;
public class Game {
    private ArrayList<Player> playerArrayList;
    private Pot pot;
    private Map<String, Player> playerDatabase;
    private File f;
    private String fileName = "ClintonTak00.txt";
    public Game() {
        playerArrayList = new ArrayList<>();
        pot = new Pot();

        this.f = new File(fileName);
        if (!this.f.exists())
            this.playerDatabase = new HashMap<>();
        else {
            try {
                InputStream is = new FileInputStream(this.f);
                ObjectInputStream ois = new ObjectInputStream(is);
                this.playerDatabase = (Map<String,Player>) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex);
                throw new RuntimeException("Player record file is corrupt");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                throw new RuntimeException("Serialization problem");
            }
        }
    }

    public void play(){
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
        gameOver();
    }

    private void gameOver(){
        for (Player player : this.playerArrayList) {
            player.gameOver();
        }
    }


    public void savePlayerRecords() {
        for (Player player : this.playerArrayList) {
            this.playerDatabase.put(player.getPlayerID(), player);
        }

        try {
            OutputStream os = new FileOutputStream(this.f);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(this.playerDatabase);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException("Player record file is corrupt.");
        }
    }


    public boolean addPlayer(String name, int type) {
        if (type == 1) {//human player
            playerArrayList.add(new HumanPlayer(name));
            return true;
        }
        else if (type == 2){//timid player
            playerArrayList.add(new TimidPlayer(name));
            return true;
        }
        else if (type == 3 ){//crafty player
            playerArrayList.add(new CraftyPlayer(name));
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addKnownPlayer(String name){
        Player player = playerDatabase.get(name);
        if (player != null){
            playerArrayList.add(player);
            return true;
        }
        else {
            return false;
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
                playerArrayList.get(i).wonGame();//increment win
                return true;
            }
        }
        return false;
    }
}
