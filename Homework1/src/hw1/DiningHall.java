package hw1;
import java.util.*;

public class DiningHall {
    private static int customerArrivalPercent;    // There is a 15% chance a customer arrives each second.
    private static int numRegisters;

    private static Customer customer = new Customer();



    // info about customers waiting at the cash registers
    private static List<Integer>[] arrivalTimes;
    private static List<Integer>[] serviceTimes;


    DiningHall(int num_Registers, int cust_Arrival_Percent){
        customerArrivalPercent = cust_Arrival_Percent;
        numRegisters = num_Registers;
        arrivalTimes = (List<Integer>[]) new List[numRegisters];
        serviceTimes = (List<Integer>[]) new List[numRegisters];

        for (int r=0; r<numRegisters; r++) {
            //create the register objects in here
            arrivalTimes[r] = new LinkedList<Integer>();
            serviceTimes[r] = new LinkedList<Integer>();
        }



    }

    public boolean aCustomerArrives() {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < customerArrivalPercent;
    }

    public void customerService(int chosenRegister, int t){
        arrivalTimes[chosenRegister].add(t);
        serviceTimes[chosenRegister].add(2*customer.howManyItems() + 10);
    }

    // The lists "arrivalTimes" and "serviceTimes" are associated with each register.
    // These lists have the same size, which is the number of people in line for that register.
    // We can use either list to determine the register having the smallest line.
    public int smallestRegister() {
        int currentSmallest = 0;
        for (int r=1; r<numRegisters; r++)
            if (arrivalTimes[r].size() < arrivalTimes[currentSmallest].size())
                currentSmallest = r;
        return currentSmallest;
    }

    public static List<Integer> getArrivalTimes(int reg) {
        return arrivalTimes[reg];
    }
    public static List<Integer> getServiceTimes(int reg) {
        return serviceTimes[reg];
    }

}
