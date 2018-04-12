package hw5;

public class AngelFishFactory extends FishFactory {
    private static FishType fishType = new AngelFish();

    public Fish create() {
        return new Fish(fishType, new NormalBehavior());
    }
}