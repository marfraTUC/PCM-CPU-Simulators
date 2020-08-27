package bankAccount;


import javax.transaction.InvalidTransactionException;

import bankAccount.TransferStatus;


public class Transaction {
	private Account sourceAccount;
	private Account targetAccount;
	private int amount;
	private TransferStatus status = TransferStatus.OPEN;
	private long processDuration = -1;
	
	public Transaction(Bank bank, int sourceAccountId, int targetAccountId, int amount) {
		sourceAccount = bank.accountByNumber(sourceAccountId);
		targetAccount = bank.accountByNumber(targetAccountId);
		this.amount = amount;
	}
	
	public void execute(){
		long start = System.nanoTime();		
		try {
			sourceAccount.withdraw(this.amount);
			targetAccount.deposit(this.amount);
			this.processDuration = System.nanoTime() - start;
			this.status = TransferStatus.COMPLETED;
		} catch (InvalidTransactionException e) {
			this.processDuration = System.nanoTime() - start;
			this.status = TransferStatus.FAILED;
		}
	}
	
	public void reset(){
		this.sourceAccount.resetBalance();
		this.targetAccount.resetBalance();
		this.status = TransferStatus.OPEN;
	}
	
	public Account getSourceAccount() {
		return sourceAccount;
	}
	public Account getTargetAccount() {
		return targetAccount;
	}
	public int getAmount() {
		return amount;
	}
	public TransferStatus getStatus() {
		return status;
	}



	public long getProcessDuration() {
		return processDuration;
	}
}
