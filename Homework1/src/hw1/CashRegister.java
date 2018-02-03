package hw1;
import java.util.*;

class CashRegister {
<<<<<<< HEAD
    public int totalCustomersServed = 0;
    public int intTotalWaitTimes = 0;
    CashRegister(){

    }
=======

    // statistics about the cash registers
    public static ArrayList<Integer> customersServed = new ArrayList<>();
    public static ArrayList<Integer> totalWaitTimes = new ArrayList<>();


    CashRegister(int r) {
        customersServed.add(0);
        totalWaitTimes.add(0);
    }




>>>>>>> f55625acd1967d2a5df5b2fd9c5d35ee523d8d13
}
