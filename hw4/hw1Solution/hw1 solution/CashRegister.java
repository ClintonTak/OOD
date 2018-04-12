package hw1;

import java.util.*;

public class CashRegister {
   private int whoami;  // identifies the cash register
   private List<Customer> custs = new LinkedList<Customer>();
   private int numserved = 0;
   private int totalWaitTime = 0;
   private Customer currentCust = null;

   public CashRegister(int n) {
      whoami = n;
   }

   public void addCustomer(int t) {
      Customer c = new Customer(t);
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

   private int avgWaitTime() { 
      return totalWaitTime / numserved; 
   }
}
