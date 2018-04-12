package hw1;

public class Customer {
   private int arrivalTime;
   private int serviceTime;
   
   public Customer(int t) {
      arrivalTime = t;
      int howmanyItems = 1 + (int)(Math.random() * 10);
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