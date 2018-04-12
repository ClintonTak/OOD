package hw4;

import java.util.ArrayList;
import java.util.List;

public class DiningHall {
    private Cashier cashierType;

    private static final int CUST_ARRIVAL_PCT = 15;    // There is a 15% chance a customer arrives each second.


    private List<CashRegister> cashRegisterList;


    public DiningHall(int normal, int fast, String dist, int maxitems) {
        cashRegisterList = new ArrayList<>();
        ItemDistribution distributionType;
        if (dist.equals("d")){
            distributionType = new Bimodal(maxitems);
        }
        else{
            distributionType = new Uniform(maxitems);
        }

        Cashier normalSpeedCashier = new NormalSpeed();
        Cashier fastSpeedCashier = new Fast();
        for (int i = 0; i < normal; i++) {//make normal cashiers
            cashRegisterList.add(new CashRegister(i, normalSpeedCashier, distributionType));  //make normal registers
        }
        for (int r=normal; r<normal+fast; r++)//make fast cashiers
            cashRegisterList.add(new CashRegister(r, fastSpeedCashier, distributionType));
    }

    public void elapseOneSecond(int t) {
        if (aCustomerArrives()) {
            // The new customer goes into the smaller line.
            CashRegister chosenRegister = smallestLine();
            chosenRegister.addCustomer(t);
        }
        for (int r=0; r<cashRegisterList.size(); r++)
            cashRegisterList.get(r).elapseOneSecond(t);  // Simulate each register for one second.
    }

    public void printStatistics(String sorttype) {
        if (sorttype.equals("w")){
            cashRegisterList.sort( new CompareByWaitTime());
        }
        else if (sorttype.equals("c")){
            cashRegisterList.sort(new CompareByCustServed());
        }
        for (int r=0; r<cashRegisterList.size(); r++) {
            CashRegister reg = cashRegisterList.get(r);
            System.out.println(reg.statistics());
        }
    }

    private boolean aCustomerArrives() {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < CUST_ARRIVAL_PCT;
    }

    private CashRegister smallestLine() {
        CashRegister currentSmallest = cashRegisterList.get(0);
        for (int r=1; r<cashRegisterList.size(); r++) {
            CashRegister cr = cashRegisterList.get(r);
            if (cr.size() < currentSmallest.size())
                currentSmallest = cr;
        }
        return currentSmallest;
    }
}
