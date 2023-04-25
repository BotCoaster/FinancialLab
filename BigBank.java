package SPoudel_Project;
import java.util.ArrayList;
import java.util.Random;

// 1. CheckingAccount "is-a" FinancialAccount and SavingsAccount "is-a" FinancialAccount
// 2. CheckingAccount "has-a" DebitCard
// 3. The objects stored in the accounts data structure have type FinancialAccount (during compile-time);
// 4. No, the declared type is FinancialAccount, but the run-time type will be SavingsAccount/CheckingAccount.
// 5. Using the instanceof operator
// 6. withdrawMoney was the only overridden method
// 7. Polymorphism was applied in the accounts data structure since the objects will have different types at compile-time
// and run-time.

public class BigBank {
	private ArrayList<FinancialAccount> accounts = new ArrayList<FinancialAccount>();
	
	public void applyGovernmentMandates() {
		for (FinancialAccount f : accounts) {
			if (f instanceof SavingsAccount) {
				f.depositMoney(777.77);
			} else if (f instanceof CheckingAccount) {
				f.withdrawMoney(f.getBalance() * 0.25, false, true);
			}
		}
	}

	public static void main(String[] args) {
		BigBank sujanBigBank = new BigBank();
		Random randGen = new Random();
				
		CheckingAccount account1 = new CheckingAccount("Sujan", 4214214);
		CheckingAccount account2 = new CheckingAccount("Dev", 421049958);
		CheckingAccount account3 = new CheckingAccount("Miftah", 84990910);
		SavingsAccount account4 = new SavingsAccount("Ronald", 50);
		SavingsAccount account5 = new SavingsAccount("Arnav", 60);
		SavingsAccount account6 = new SavingsAccount("Declan", 70);

		sujanBigBank.accounts.add(account1);
		sujanBigBank.accounts.add(account2);
		sujanBigBank.accounts.add(account3);
		sujanBigBank.accounts.add(account4);
		sujanBigBank.accounts.add(account5);
		sujanBigBank.accounts.add(account6);
	}
}