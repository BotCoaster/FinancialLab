package SPoudel_Project;

class SavingsAccount extends FinancialAccount {
	private double savingsWithdrawalLimitFee = 5.0;
	private int monthlyWithdrawalLimit = 6;
	private final double interestRate = 0.01; //percentage

	public SavingsAccount(String name, int minimumBalance) {
		super(name, minimumBalance);
	}
	
	public void withdrawMoney(double amount, boolean isForeign, boolean isInNetwork) {
		if (amount <= 0) return;
		
		if (monthlyWithdrawalLimit > 0) {
			super.withdrawMoney(amount + savingsWithdrawalLimitFee, isForeign, isInNetwork);
			this.monthlyWithdrawalLimit--;
		}
	}
	
	public void addInterest() {
		this.depositMoney(this.getBalance() * interestRate);
	}
	
	public int getMonthlyWithdrawalLimit() {
		return this.monthlyWithdrawalLimit;
	}
	
	public void resetMonthlyWithdrawalLimit() {
		this.monthlyWithdrawalLimit = 6;
	}
}