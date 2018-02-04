package hw2;

public class Pot {
    private int numberOfChips = 1;

    public Pot(){}

    public int getNumberOfChips() {
        return numberOfChips;
    }

    public void setNumberOfChips(int numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    public void processOneTurn(int incrementAmount){
        numberOfChips = numberOfChips + incrementAmount;
        System.out.printf("There are currently %d chips in the pot.\n", numberOfChips);
    }



}
