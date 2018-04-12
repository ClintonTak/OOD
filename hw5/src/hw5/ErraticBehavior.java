package hw5;
import java.util.Random;

public class ErraticBehavior extends FishBehavior {
    public ErraticBehavior(){
        super(3.0, 2.0, 0.75, 0.75);
    }
    public double xInitialPos(double tankWidth) {
        Random r = new Random();
        double randomValue = 10 + (tankWidth - 10) * r.nextDouble();
        return randomValue;
    }

    public double yInitialPos(double tankHeight) {
        Random r = new Random();
        double randomValue = 0 + (tankHeight - 0) * r.nextDouble();
        return randomValue;
    }

}