package SPoudel_Project;

class CheckingAccount extends FinancialAccount {
	private final int overdraftFee = 35;
	private DebitCard associatedDebitCard;
	
	public CheckingAccount(String name, int minimumBalance) {
		super(name, minimumBalance);
	}
	
	public void withdrawMoney(int amount, boolean isForeign, boolean isInNetwork) {
		if (amount <= 0) return;
		if (!isInNetwork) super.withdrawMoney(this.getOutOfNetworkFee(), isForeign, false);
		
		if (this.getBalance() - amount < 0) {
			super.withdrawMoney(amount + overdraftFee, isForeign, true);
		} else {
			super.withdrawMoney(amount,  isForeign, true);
		}
	}
	
	public String issuePaperCheck(String payee, int amount, String memo) {
		this.withdrawMoney(amount + 0.01, false, true);
		return "From: " + this.getName() + "; To " + payee + ", $" + amount + " for " + memo;
	}
	
	public void issueDebitCard() {
		associatedDebitCard = new DebitCard();
	}
	
	public DebitCard getDebitCard() {
		return this.associatedDebitCard;
	}
	
}