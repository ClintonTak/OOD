package hw4;

import java.util.LinkedList;
import java.util.List;

public class NormalSpeed implements Cashier {

    public String cashierType(){
        return "Normal Speed";
    }
    public void elapseOneSecond(Customer customer) {
        customer.elapseOneSecond();
    }
}
