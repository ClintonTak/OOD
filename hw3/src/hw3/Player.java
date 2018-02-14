package hw3;
import java.io.Serializable;

abstract class Player implements Comparable<Player>, Serializable{
    //Constants
    int numberOfChips;
    int numberOfDiceRolled;
    String playerID;
    int wins;
    int gamesPlayed;
    int playerType;

    //Methods
    Player(String name){
        playerID = name;
        numberOfChips = 0;
        numberOfDiceRolled = 1;
        wins = 0;
        gamesPlayed = 0;
    }

    public String getPlayerID(){
        return playerID;
    }
    public int getChipCount(){
        return numberOfChips;
    }
    public int getNumberOfDiceRolled() {
        return numberOfDiceRolled;
    }
    public void setNumberOfChips(int chips) {
        numberOfChips = chips;
    }
    public void wonGame() {
        wins++;
    }

    public void endGame() {
        numberOfChips = 0;
        gamesPlayed++;
    }

    abstract int doTurn(int numberOfChipsInPot, int firstPlaceChipCount);

    public int compareTo(Player player) {
        if (winRatio().equals(player.winRatio()))
            return playerID.compareTo(player.playerID);
        else
            return winRatio().compareTo(player.winRatio());
    }

    public Integer winRatio() {
        if (this.gamesPlayed > 0) {
            float ratio = ((float) wins) / ((float) gamesPlayed);
            return ((int) Math.round(100.0 * ratio));
        } else
            return 0;
    }

    public String toString() {
        String playerTypeString;
        if (playerType == 1){
            playerTypeString = "Human Player";
        }
        else if (playerType == 2){
            playerTypeString = "Timid Computer Player";
        }
        else{
            playerTypeString = "Crafty Computer Player";
        }
        return playerID + ": " + playerTypeString
                + "\n\twins:      " + wins
                + "\n\tlosses:    " + (gamesPlayed - wins)
                + "\n\tw/l ratio: " + winRatio();
    }

}


