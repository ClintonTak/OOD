package hw8;

public class Bearish implements StockAnalyst {
    private StockInfo stockInfo;
    private double confidence;
    private String reason;

    public Bearish(StockInfo stockInfo){
        this.stockInfo = stockInfo;
        confidence = .3;
        reason = "I think the market is goin down.";
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
