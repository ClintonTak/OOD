package hw2;
public interface Player {
    //Constants

    //Methods
    int doTurn(int numberOfChipsInPot, int firstPlaceChipCount);
    String getPlayerID();
    int getChipCount();
    int getNumberOfDiceRolled();
    void setNumberOfChips(int numberOfChips);
}
