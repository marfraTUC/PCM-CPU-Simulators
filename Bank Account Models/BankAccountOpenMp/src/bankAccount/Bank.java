package bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
	private final Map<Integer, Account> accounts = new HashMap<>();
	private final AtomicInteger lastAccountId = new AtomicInteger(-1);
	
	public Account createAccount(int balance){
		Account newAccount = new Account(this.lastAccountId.incrementAndGet(),balance);
		this.accounts.put(newAccount.getAccountId(), newAccount);
		return newAccount;
	}
	
	public Account accountByNumber(int accountNumber){
		return accounts.get(accountNumber);
	}
	
	public Map<Integer, Account> getAccounts() {
		return accounts;
	}
}
