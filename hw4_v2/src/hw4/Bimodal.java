package hw4;

import java.util.Random;

public class Bimodal implements ItemDistribution {
    private int maxitems;

    public Bimodal(int maxItems){
        maxitems = maxItems;
    }

    public int generate(){
        Random random = new Random();
        int nextInt = random.nextInt(3);
        if (nextInt == 1){
            return maxitems/2;
        }
        else if (nextInt == 2){
            return maxitems;
        }
        else{
            return 1;
        }
    }
}
