package hw1;

public class DiningHall {
	private static final int CUST_ARRIVAL_PCT = 15;    // There is a 15% chance a customer arrives each second.
	private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.

	private CashRegister[] registers = new CashRegister[NUM_REGISTERS];

	public DiningHall() {
		for (int r=0; r<NUM_REGISTERS; r++) 
			registers[r] = new CashRegister(r);
	}

	public void elapseOneSecond(int t) {
		if (aCustomerArrives()) {
			// The new customer goes into the smaller line.
			CashRegister chosenRegister = smallestLine(); 
			chosenRegister.addCustomer(t);
		}
		for (int r=0; r<NUM_REGISTERS; r++)
			registers[r].elapseOneSecond(t);  // Simulate each register for one second.
	}

	public void printStatistics() {
		for (int r=0; r<NUM_REGISTERS; r++) {
			CashRegister reg = registers[r];
			System.out.println(reg.statistics());
		}
	}

	private boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}

	private CashRegister smallestLine() {
		CashRegister currentSmallest = registers[0];
		for (int r=1; r<NUM_REGISTERS; r++) {
			CashRegister cr = registers[r];
			if (cr.size() < currentSmallest.size())
				currentSmallest = cr;
		}
		return currentSmallest;	
	}
}
