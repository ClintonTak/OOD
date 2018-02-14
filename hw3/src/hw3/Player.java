package hw3;

import java.io.Serializable;
abstract class Player {
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
    public void setNumberOfChips(int numberOfChips) {
        this.numberOfChips = numberOfChips;
    }
    public void wonGame() {
        this.wins++;
    }

    public void gameOver() {
        this.numberOfChips = 0;
        this.gamesPlayed++;
    }

    abstract int doTurn(int numberOfChipsInPot, int firstPlaceChipCount);
}

/*
    public int compareTo(Player player) {
        if (this.winRate().equals(player.winRate()))
            return this.name.compareTo(player.name);
        else
            return this.winRate().compareTo(player.winRate());
    }

    public Integer winRate() {
        if (this.gamesPlayed > 0) {
            float ratio = ((float) this.wins) / ((float) this.gamesPlayed);
            return ((int) Math.round(100.0 * ratio));
        } else
            return 0;
    }

    public String toString() {
        return this.name + ": " + this.playerType
                + "\n\twins:      " + this.wins
                + "\n\tlosses:    " + (this.gamesPlayed - this.wins)
                + "\n\tw/l ratio: " + this.winRate();
    }
}*/

