package hw1;

public class Simulation {



    private static final int SIMULATION_TIME = 100000;  // A simulation is for 100,000 seconds.
    private static final int CUST_ARRIVAL_PCT = 15;    // There is a 15% chance a customer arrives each second.
    private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.

    private static DiningHall hall = new DiningHall(NUM_REGISTERS,CUST_ARRIVAL_PCT);

    public static void main(String[] args) {
        // Then perform the simulation for the specified number of seconds.
        for (int t=0; t<SIMULATION_TIME; t++) {
            if (hall.aCustomerArrives()) {
                // The new customer goes into the smaller line.
                int chosenRegister = hall.smallestRegister();
                hall.customerService(chosenRegister, t);

            }
            for (int r=0; r<NUM_REGISTERS; r++)
                elapseOneSecond(r, t);  // Simulate each register for one second.
        }

        // Print out the statistics.
        for (int r=0; r<NUM_REGISTERS; r++) {
            System.out.println("Register " + r);
            System.out.println("\tNumber of arrivals = " + hall.customersServed[r]);
            System.out.println("\tAverage wait time = " + (hall.totalWaitTimes[r] / hall.customersServed[r]));
        }
    }


    private static void elapseOneSecond(int reg, int currentTime) {
        // If the list is empty, there are no customers to process.
        if (hall.getArrivalTimes(reg).size() == 0)
            return;

        // Otherwise, the first customer in line gets processed.
        int timeLeft = hall.getServiceTimes(reg).get(0) - 1;
        if (timeLeft > 0) {
            hall.getServiceTimes(reg).set(0, timeLeft);
        }
        else { // We are done with this customer.
            // First update the register's statistics.
            hall.customersServed[reg]++;
            hall.totalWaitTimes[reg] += currentTime - hall.getArrivalTimes(reg).get(0);

            // Then remove the customer.
            hall.getArrivalTimes(reg).remove(0);
            hall.getServiceTimes(reg).remove(0);
        }
    }
}
