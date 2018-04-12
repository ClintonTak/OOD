package hw1;

public class Simulation {
	private static final int SIMULATION_TIME = 100000;  // Simulate for 100,000 seconds.

	public static void main(String[] args) {
		DiningHall hall = new DiningHall();
		
		for (int t=0; t<SIMULATION_TIME; t++) 
			hall.elapseOneSecond(t);

		hall.printStatistics();
	}
}