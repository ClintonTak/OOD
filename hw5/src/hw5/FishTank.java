package hw5;

import java.util.*;
import javafx.scene.layout.Pane;

public class FishTank {
   List<Fish> fishes = new ArrayList<>();
   Pane p;
   private List<FishFactory> factories;
   boolean suspended = false;

   public FishTank(Pane p, List<FishFactory> factories) {
      this.p = p;
      this.factories = factories;
   }

   public void addFish(int fishtype) {
      /*FishType f = null;
      if (fishtype == 0)
         f = new AngelFish();
      else if (fishtype == 1)
         f = new MeanFish();
      else if (fishtype == 2)
         f = new Octopus();
      else if (fishtype == 3)
         f = new PufferFish();

      fishes.add(f);
      p.getChildren().add(f.getView());*/
      Fish f = factories.get(fishtype).create();
      fishes.add(f);
      p.getChildren().add(f.getView());
   }

   public void startAnimation() {
      suspended = false;
   }

   public void stopAnimation() {
      suspended = true;
   }

   public void move(double height, double width) {
      if (!suspended) {
         for (Fish f : fishes) 
            f.move(height, width);
      }
   }
}
