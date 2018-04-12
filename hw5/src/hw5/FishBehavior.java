package hw5;

public abstract class FishBehavior {


    protected double xspeed;
    protected double yspeed;
    protected double xDirectionChangePct;
    protected double yDirectionChangePct;

    public FishBehavior(double xspeed, double yspeed, double xDirectionChangePct, double yDirectionChangePct){
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.xDirectionChangePct = xDirectionChangePct;
        this.yDirectionChangePct = yDirectionChangePct;
    }

    public double getXspeed() {
        return xspeed;
    }

    public double getYspeed() {
        return yspeed;
    }

    public double getxDirectionChangePct() {
        return xDirectionChangePct;
    }

    public double getyDirectionChangePct() {
        return yDirectionChangePct;
    }

    public void changeXDir() {
        xspeed = -xspeed;
    }

    public void changeYDir() {
        yspeed = -yspeed;
    }

    abstract double xInitialPos(double tankWidth);
    abstract double yInitialPos(double tankHeight);
}
