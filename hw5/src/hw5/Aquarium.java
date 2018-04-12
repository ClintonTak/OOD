package hw5;

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aquarium extends Application {
    public static double INIT_TANK_HT = 300;
    public static double INIT_TANK_WD = 600;
   
    public void start(Stage stage) {
        Pane p = new Pane();
        p.setBackground(new Background(
            new BackgroundFill(Color.DARKTURQUOISE, null, null)));
        List<FishFactory> factories = Arrays.asList(
                new AngelFishFactory(), new MeanFishFactory(), new OctopusFactory(), new PufferFishFactory());
        FishTank tank = new FishTank(p, factories);
        MenuBar bar = createMenuBar(tank);
        p.getChildren().add(bar);

        Scene scene = new Scene(p, INIT_TANK_WD, INIT_TANK_HT);
        stage.setScene(scene);
        stage.setTitle("Fish Tank");
        stage.show();

        AnimationTimer timer = new FishAnimation(tank, p);
        timer.start();
    }

    private MenuBar createMenuBar(FishTank tank) {
        Menu animation = new Menu("Animation");
        MenuItem start = new MenuItem("start");
        start.setOnAction(e->tank.startAnimation());
        MenuItem stop = new MenuItem("stop");
        stop.setOnAction(e->tank.stopAnimation());
        animation.getItems().addAll(start, stop);

        Menu newfish = new Menu("New Fish");
        MenuItem angel = new MenuItem("angelfish");
        angel.setOnAction(e->tank.addFish(0));
        MenuItem meanie = new MenuItem("mean fish");
        meanie.setOnAction(e->tank.addFish(1));
        MenuItem octopus = new MenuItem("octopus");
        octopus.setOnAction(e->tank.addFish(2));

        MenuItem puffer = new MenuItem("puffer fish");
        puffer.setOnAction(e->tank.addFish(3));

        newfish.getItems().addAll(angel, meanie, octopus, puffer);

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(animation, newfish);
        return bar;
    }
   
   public static void main(String[] args) {
      Application.launch(args);
   }
}
