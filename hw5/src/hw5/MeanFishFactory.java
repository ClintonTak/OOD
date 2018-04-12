package hw5;

public class MeanFishFactory extends FishFactory {
    private static FishType fishType = new MeanFish();

    public Fish create() {
        return new Fish(fishType, new ErraticBehavior());
    }
}