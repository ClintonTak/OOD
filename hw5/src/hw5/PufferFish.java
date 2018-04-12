package hw5;

import javafx.scene.image.Image;

public class PufferFish implements FishType {
    private Image leftimage, rightimage;

    public PufferFish() {

        leftimage  = new Image("images/Lpufferfish.gif");
        rightimage = new Image("images/Rpufferfish.gif");
    }

    public Image leftImage() {
        return leftimage;
    }

    public Image rightImage() {
        return rightimage;
    }
}
