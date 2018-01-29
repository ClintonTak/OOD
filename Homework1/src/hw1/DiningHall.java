package hw1;
import java.util.*;

public class DiningHall {
    private static int customerArrivalPercent;    // There is a 15% chance a customer arrives each second.
    private static int numRegisters;

    ArrayList<Customer> customerList = new ArrayList<>();
    public ArrayList<CashRegister> cashRegisterList = new ArrayList<>();




    DiningHall(int num_Registers, int cust_Arrival_Percent){
        customerArrivalPercent = cust_Arrival_Percent;
        numRegisters = num_Registers;

        for (int r=0; r<numRegisters; r++) {
            customerList.add(new Customer());
            cashRegisterList.add(new CashRegister());
        }



    }

    public boolean aCustomerArrives() {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < customerArrivalPercent;
    }

    public void customerService(int chosenRegister, int t){
        customerList.get(chosenRegister).addToArrival(t);
        customerList.get(chosenRegister).addToService((2* Customer.howManyItems() + 10));
    }

    public int smallestRegister() {
        int currentSmallest = 0;
        for (int r=1; r<numRegisters; r++)
            if (customerList.get(r).getArrivalTimes().size() < customerList.get(currentSmallest).getArrivalTimes().size())
                currentSmallest = r;
        return currentSmallest;
    }
    //move to cashRegister
    public List<Integer> getArrivalTimes(int customer) {
        return customerList.get(customer).getArrivalTimes();
    }
    public List<Integer> getServiceTimes(int customer) {
        return customerList.get(customer).getServiceTimes();
    }
}
