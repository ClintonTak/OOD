package hw1;
import java.util.*;

class CashRegister {
    //change to private and make gettershp 
    public ArrayList<Integer> arrivalTimes = new ArrayList<>();
    public ArrayList<Integer> serviceTimes = new ArrayList<>();

    CashRegister() {

    }
    public void addToArrival(int value){
        arrivalTimes.add(value);
    }
    public void addToService(int value){
        serviceTimes.add(value);
    }


}
