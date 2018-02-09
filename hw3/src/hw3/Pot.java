package hw3;

public class Pot {
    private int numberOfChips = 0;

    public Pot(){}

    public int getNumberOfChips() {
        return numberOfChips;
    }

    public void setNumberOfChips(int numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    public void processOneTurn(int incrementAmount){
        numberOfChips = numberOfChips + incrementAmount;
        if (numberOfChips == 1){
            System.out.printf("There is currently 1 chip in the pot. \n");
        }
        else {
            System.out.printf("There are currently %d chips in the pot.\n", numberOfChips);
        }
    }



}
