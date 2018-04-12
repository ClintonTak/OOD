package hw5;

public class BottomFeedingBehavior extends FishBehavior{

    public BottomFeedingBehavior(){
        super(2.0, 1.0, 0.1, 0.0);
    }

    public double xInitialPos(double tankWidth) {
        return tankWidth / 3;
    }

    public double yInitialPos(double tankHeight) {
        return tankHeight / 1.4;
    }
}
