package hw5;

import javafx.scene.image.*;

public class Fish {

	private ImageView view = new ImageView(); // holds the image and current position
	private FishType fType;
	private FishBehavior fBehavior;
	public Fish(FishType type, FishBehavior behavior) {
		this.fBehavior = behavior;
		this.fType = type;
        view.setX(this.fBehavior.xInitialPos(Aquarium.INIT_TANK_WD));  // the initial fish location
        view.setY(this.fBehavior.yInitialPos(Aquarium.INIT_TANK_HT));
	}
	
public void move(double tankheight, double tankwidth) {
	Image image = getImage();
	view.setImage(image);
	double x = moveXY(view.getX(), fBehavior.getXspeed(), fBehavior.getxDirectionChangePct());
	double y = moveXY(view.getY(), fBehavior.getYspeed(), fBehavior.getyDirectionChangePct());
	if (legalMove(x, image.getWidth(), tankwidth))
		view.setX(x);
	else
		changeXdirection();
	if (legalMove(y, image.getHeight(), tankheight))
		view.setY(y);
	else
		changeYdirection();
}

	public ImageView getView() {
	   return view;
	}
	
	private Image getImage() {
		return movesRight() ? fType.rightImage() : fType.leftImage();
	}

	private double moveXY(double pos, double speed, double pct) {
	   if (changesDirection(pct) ) 
			return -1;
		else
			return pos + speed;
	}
	 
   private boolean legalMove(double pos, double size, double limit) {
      return (pos >=0) && (pos + size <= limit);
   }
   
   private void changeXdirection() {
      fBehavior.changeXDir();
   }
   
   private void changeYdirection() {
      fBehavior.changeYDir();
   }
   
	private boolean movesRight() {
		return Math.random() * 100 < 0;
	}

    private boolean changesDirection(double frequency) {
        return Math.random() * 100 < frequency;
    }
}
