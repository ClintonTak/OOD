package hw4;

import java.util.LinkedList;
import java.util.List;

public class Fast implements Cashier {

    int speed = 2;
    public String cashierType(){
        return "Fast Speed";
    }

    public void elapseOneSecond(Customer customer) {
        for (int i = 0; i < speed; i++) {
            customer.elapseOneSecond();
        }
    }

}
