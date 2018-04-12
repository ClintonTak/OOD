package hw4;

public class Customer {
    private int arrivalTime;
    private int serviceTime;

    public Customer(int t, ItemDistribution itemDistribution) {
        arrivalTime = t;
        int howmanyItems = itemDistribution.generate();
        serviceTime = 2*howmanyItems + 10;
    }

    public void elapseOneSecond() {
        serviceTime --;
    }

    public boolean isFinished() {
        return serviceTime == 0;
    }

    public int arrivalTime() {
        return arrivalTime;
    }
}