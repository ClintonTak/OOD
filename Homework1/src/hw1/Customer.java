package hw1;
import java.util.*;

class Customer {
    Customer(){

    }


    public int howManyItems() {
        int n = (int) (Math.random() * 10);
        return n + 1;
    }
}
