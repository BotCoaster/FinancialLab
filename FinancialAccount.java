package SPoudel_Project;

class FinancialAccount {
	private final int monthlyMaintenanceFee = 20;
	private final int outOfNetworkFee = 2;
	private final double foreignTransactionFee = 1.02; //percentage
	private int minimumBalance;	
	private int balance;
	private String name;
	
	public FinancialAccount(String name, int minimumBalance) {
		this.minimumBalance = minimumBalance;
		this.name = name;
	}
	
	public void depositMoney(double amount) {
		if (amount <= 0) return;
		
		balance += amount;
	}
	
	public void withdrawMoney(double amount, boolean isForeign, boolean isInNetwork) {
		if (amount <= 0) return;
		if (!isInNetwork) balance -= outOfNetworkFee;
		
		if (isForeign) {
			balance -= amount * foreignTransactionFee;
		} else {
			balance -= amount;
		}
	}
	
	public String alertBalance() {
		if (this.balance < this.minimumBalance) {
			return "Balance below minimum!";
		}
		return "Balance above minimum!";
	}
	
	public void chargeMonthlyMaintenanceFee() {
		this.balance -= monthlyMaintenanceFee;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public double getForeignTransactionFee() {
		return this.foreignTransactionFee;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getOutOfNetworkFee() {
		return this.outOfNetworkFee;
	}
	
}