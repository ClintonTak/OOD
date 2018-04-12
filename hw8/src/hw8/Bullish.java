package hw8;

public class Bullish implements StockAnalyst {
    private StockInfo stockInfo;
    private double confidence;
    private String reason;
    public Bullish(StockInfo stockInfo){
        this.stockInfo = stockInfo;
        confidence = .7;
        reason = "I think the market is going up.";
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
