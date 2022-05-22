public class Trader {

    private String name;
    private double bankRoll;
    private int numShares;
    private int tradeValuePositionLimit;
    private int sharePositionLimit;

    public Trader(String name, double bankRoll, int numShares, int tradeValuePositionLimit, int sharePositionLimit) {

        this.name = name;
        this.bankRoll = bankRoll;
        this.numShares = numShares;
        this.tradeValuePositionLimit = tradeValuePositionLimit;
        this.sharePositionLimit = sharePositionLimit;
    }

    //Generate Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBankRoll() {
        return bankRoll;
    }

    public void setBankRoll(double bankRoll) {
        this.bankRoll = bankRoll;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public int getTradeValuePositionLimit() {
        return tradeValuePositionLimit;
    }

    public void setTradeValuePositionLimit(int tradeValuePositionLimit) {
        this.tradeValuePositionLimit = tradeValuePositionLimit;
    }

    public int getSharePositionLimit() {
        return sharePositionLimit;
    }

    public void setSharePositionLimit(int sharePositionLimit) {
        this.sharePositionLimit = sharePositionLimit;
    }
    
}
