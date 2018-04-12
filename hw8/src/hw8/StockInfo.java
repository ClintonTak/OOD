package hw8;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class StockInfo {

    private String name;
    private String hq;
    private double earnings;
    private String marketSegment;
    private int price;
    private List<String> products;

    public StockInfo(String fname){
        products = new ArrayList<>();
        try{
            File file = new File(fname);
            FileReader fReader = new FileReader(file);
            BufferedReader bufferedReader  = new BufferedReader(fReader);
            String line;
            while (bufferedReader.readLine() != null){
                line = bufferedReader.readLine();
                String[] wordArray = line.replaceAll(" +", " ").split(" ");
                if (wordArray[0]== "name") {
                    name = wordArray[1];
                    break;
                }else if (wordArray[0]== "hq"){
                    hq = wordArray[1];
                    break;
                }else if (wordArray[0]== "earnings"){
                    earnings = Double.parseDouble(wordArray[1]);
                    break;
                }else if (wordArray[0]== "marketsegment"){
                    marketSegment = wordArray[1];
                    break;
                }else if (wordArray[0]== "price"){
                    price = Integer.parseInt(wordArray[1]);
                    break;
                }else if (wordArray[0]== "products"){
                    for (int i = 1; i<wordArray.length; i++)
                        products.add(wordArray[i]);
                    break;
                }else {
                    break;
                }
            }
            fReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }

    public String getHq() {
        return hq;
    }
    public double getEarnings(){
        return earnings;
    }

    public String getMarketSegment() {
        return marketSegment;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getProducts(){
        return products;
    }
}
