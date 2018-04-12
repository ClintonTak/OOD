package hw5;

public class NormalBehavior extends FishBehavior{
    public NormalBehavior(){
        super(2.0, 1.0, 0.1, 0.5);
    }

    public double xInitialPos(double tankWidth) {
        return tankWidth / 3;
    }

    public double yInitialPos(double tankHeight) {
        return tankHeight / 3;
    }
}
