package bankAccount;

import javax.transaction.InvalidTransactionException;

public class Account {
	private final int accountId;
	private int balance = 0;
	private int resetBalance = 0;
	
	public Account(int accountId, int balance) {
		this.accountId = accountId;
		this.balance = balance;
		this.resetBalance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void deposit(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void withdraw(int amount) throws InvalidTransactionException {
		if(this.balance < amount && Main.WITHDRAW_FAILABLE) throw new InvalidTransactionException();
		this.balance = this.balance - amount;
	}
	
	public void resetBalance(){
		this.balance = resetBalance;
	}
}
