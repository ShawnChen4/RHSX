public class Trader {
	
	private String traderID;
	private int sharesOwned;
	private int traderBalance;
	
	public Trader(String traderID, int sharesOwned, int traderBalance) {
		this.traderID = traderID;
		this.sharesOwned = sharesOwned;
		this.traderBalance = traderBalance;
	}
	
	public void printTraderInfo() {
		System.out.println("Trader ID: " + traderID);
		System.out.println("Shares Owned: " + sharesOwned);
		System.out.println("Trader Balance: " + traderBalance);
		System.out.println("------------------------------------");
	}
	public String getTraderID() {
		return traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public int getSharesOwned() {
		return sharesOwned;
	}

	public void setSharesOwned(int sharesOwned) {
		this.sharesOwned = sharesOwned;
	}

	public int getTraderBalance() {
		return traderBalance;
	}

	public void setTraderBalance(int traderBalance) {
		this.traderBalance = traderBalance;
	}
	
	
}
