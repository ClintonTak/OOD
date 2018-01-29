package hw1;
import java.util.*;

class CashRegister {


    //change to private and make gettershp
    private ArrayList<Integer> arrivalTimes = new ArrayList<>();
    private ArrayList<Integer> serviceTimes = new ArrayList<>();

    CashRegister() {

    }
    public void addToArrival(int value){
        arrivalTimes.add(value);
    }
    public void addToService(int value){
        serviceTimes.add(value);
    }


    //getter and setter methods
    public ArrayList<Integer> getServiceTimes() {
        return serviceTimes;
    }

    public ArrayList<Integer> getArrivalTimes() {
        return arrivalTimes;
    }




}
