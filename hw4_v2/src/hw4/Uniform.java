package hw4;

public class Uniform implements ItemDistribution {


    private int maxitems;

    public Uniform(int maxItems){
        maxitems = maxItems;
    }

    public int generate(){
        return (1 + (int)(Math.random() * maxitems));
    }

}
