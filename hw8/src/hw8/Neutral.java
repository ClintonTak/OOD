package hw8;

public class Neutral implements StockAnalyst {
    private StockInfo stockInfo;
    private double confidence;
    private String reason;

    public Neutral(StockInfo stockInfo){
        this.stockInfo = stockInfo;
        confidence = .5;
        reason = "The market's future is unclear.";
    }

    public double confidenceLevel(){
        return confidence;
    }

    public String reasons(){
        return reason;
    }

    public StockInfo getStockInfo(){
        return stockInfo;
    }
}

