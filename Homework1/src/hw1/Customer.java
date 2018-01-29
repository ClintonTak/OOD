package hw1;
import java.util.*;

class Customer {
    private ArrayList<Integer> arrivalTimes = new ArrayList<>();
    private ArrayList<Integer> serviceTimes = new ArrayList<>();


    //each cash register should have a list of customer objects that each have
    Customer() {

    }
    public void addToArrival(int value){
        arrivalTimes.add(value);
    }
    public void addToService(int value){
        serviceTimes.add(value);
    }

    public static int howManyItems() {
        int n = (int) (Math.random() * 10);
        return n + 1;
    }


    //getter and setter methods
    public ArrayList<Integer> getServiceTimes() {
        return serviceTimes;
    }

    public ArrayList<Integer> getArrivalTimes() {
        return arrivalTimes;
    }




}
