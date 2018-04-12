package hw4;

import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister> {

    public int compare(CashRegister cashRegister1, CashRegister cashRegister2){
        int comparision = Integer.compare(cashRegister1.avgWaitTime(),cashRegister2.avgWaitTime());
        return comparision;
    }
}
