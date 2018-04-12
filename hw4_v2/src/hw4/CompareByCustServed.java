package hw4;

import java.util.Comparator;

public class CompareByCustServed implements Comparator<CashRegister> {

    public int compare(CashRegister cashRegister1, CashRegister cashRegister2){
        int comparision = Integer.compare(cashRegister1.getNumserved(),cashRegister2.getNumserved());
        return comparision;
    }
}
