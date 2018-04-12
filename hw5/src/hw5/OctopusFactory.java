package hw5;

public class OctopusFactory extends FishFactory {
    private static FishType fishType = new Octopus();

    public Fish create() {
        return new Fish(fishType, new BottomFeedingBehavior());
    }
}