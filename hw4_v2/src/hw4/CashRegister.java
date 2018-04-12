package hw4;
import java.util.*;

public class CashRegister {
    private int whoami;  // identifies the cash register
    private List<Customer> custs = new LinkedList<Customer>();
    private int numserved = 0;
    private int totalWaitTime = 0;
    private Customer currentCust = null;

    private Cashier cashierType;
    private ItemDistribution distributionType;
    public CashRegister(int n, Cashier type, ItemDistribution distribution) {
        whoami = n;
        cashierType = type;
        distributionType = distribution;
    }

    public void addCustomer(int t) {
        Customer c = new Customer(t, distributionType);
        custs.add(c);
        if (currentCust == null)
            currentCust = c;
    }

    public void elapseOneSecond(int currentTime) {
        // Return if there is no current customer.
        if (currentCust == null)
            return;

        // Otherwise, process the current customer.
        currentCust.elapseOneSecond();
        if (currentCust.isFinished()) {
            numserved++;
            totalWaitTime += currentTime - currentCust.arrivalTime();

            // Remove the finished customer and make the next customer current.
            custs.remove(0);
            currentCust = custs.size() > 0 ? custs.get(0) : null;
        }
    }

    public int size() {
        return custs.size();
    }

    public String statistics() {
        return "Register " + whoami
                + "\tNumber served = " + numserved
                + "\tAverage wait time = " + avgWaitTime();
    }

    public int avgWaitTime() {
        return totalWaitTime / numserved;
    }

    public int getNumserved(){
        return numserved;
    }
}

