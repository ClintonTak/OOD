package hw5;

public class PufferFishFactory extends FishFactory {
    private static FishType fishType = new PufferFish();

    public Fish create() {
        return new Fish(fishType, new ErraticBehavior());
    }
}