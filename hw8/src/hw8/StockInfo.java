package hw8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockInfo {
    private String name;
    private String hq;
    private double earnings;
    private String marketSegment;
    private int price;
    private List<String> products;

    public StockInfo(String filename) {
        products = new ArrayList<>();
        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordsArray = line.replaceAll(" +", " ").split(" ");
                if (wordsArray[0].equals("name")){
                    name = wordsArray[1];
                }
                if (wordsArray[0].equals("hq")){
                    hq = wordsArray[1];
                }
                if (wordsArray[0].equals("earnings")){
                    earnings = Double.parseDouble(wordsArray[1]);
                }
                if (wordsArray[0].equals("marketsegment")){
                    marketSegment = wordsArray[1];
                }
                if (wordsArray[0].equals("shareprice")){
                    price = Integer.parseInt(wordsArray[1]);
                }
                if (wordsArray[0].equals("products")){
                    for (int i = 1; i < wordsArray.length; i++) {
                        products.add(wordsArray[i]);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("here " + name + hq + Double.toString(earnings) +  marketSegment + products);
    }

    public String getName() {
        return name;
    }

    public String getHq() {
        return hq;
    }

    public String getMarketSegment() {
        return marketSegment;
    }

    public double getEarnings() {
        return earnings;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getProducts() {
        return products;
    }
}
