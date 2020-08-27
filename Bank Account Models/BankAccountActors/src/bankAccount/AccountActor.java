package bankAccount;

import akka.actor.UntypedActor;
import bankAccount.TransactionActor.ExecuteTransaction;

public class AccountActor extends UntypedActor {
	private final int id;
	private int balance = 0;
	public AccountActor(int id, int balance) {
		this.id = id;
		this.balance = balance;
	}
	
	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof ExecuteTransaction){
			ExecuteTransaction execute = (ExecuteTransaction) message;
			int amount = execute.transaction.amount;
			
			if(this.balance < amount && Main.WITHDRAW_FAILABLE)
			{
				getSender().tell(new TransactionDone(amount, TransferStatus.FAILED), getSelf());
//				System.out.println(execute.transaction.id + " BAD " + Thread.currentThread().getName());
			}else
			{
				this.balance -= amount;
				//getSender().tell(new WithdrawSuccessful(withdraw.transactionId), getSelf());
//				System.out.println(execute.transaction.id + " OKAY " + Thread.currentThread().getName());
				execute.transaction.targetAccount.tell(new AccountActor.Deposit(execute.transaction.id, amount), getSender());
			}
			
		}
		else if(message instanceof Deposit){
			Deposit deposit = (Deposit) message;
			int amount = deposit.amount;
			this.balance += amount;
			//System.out.println("Transaction " + deposit.transactionId + " done");
			getSender().tell(new TransactionDone(amount, TransferStatus.COMPLETED), getSelf());
//			getSender().tell(new AccountActor.DepositSuccessful(deposit.transactionId), getSelf());
		}
//		else if(message instanceof Withdraw){
//			Withdraw withdraw = (Withdraw) message;
//			int amount = withdraw.amount;
//			if(this.balance < amount && Main.WITHDRAW_FAILABLE)
//			{
//				getSender().tell(new WithdrawFailed(withdraw.transactionId), getSelf());
//			}else
//			{
//				this.balance -= amount;
//				getSender().tell(new WithdrawSuccessful(withdraw.transactionId), getSelf());
//			}
//			
//		}
		else{
			
		}
	}
	
	static class ExecuteTransaction{
		Transaction transaction;
		public ExecuteTransaction(Transaction transaction) {
			this.transaction = transaction;
		}
	}
	
	static class TransactionDone{
		int id;
		TransferStatus status;
		public TransactionDone(int id, TransferStatus status) {
			this.id = id;
			this.status = status;
		}
	}
	
	public static class Deposit{
		int transactionId,amount;
		public Deposit(int transactionId,int amount) {
			this.transactionId = transactionId;
			this.amount = amount;
		}
	}
	public static class DepositSuccessful{
		int transactionId;
		public DepositSuccessful(int transactionId) {
			this.transactionId = transactionId;
		}
	}
	public static class Withdraw{
		int transactionId,amount;	
		public Withdraw(int transactionId,int amount) {
			this.transactionId = transactionId;
			this.amount = amount;
		}
	}
	public static class WithdrawSuccessful{
		int transactionId;
		public WithdrawSuccessful(int transactionId) {
			this.transactionId = transactionId;
		}
	}
	public static class WithdrawFailed{
		int transactionId;
		public WithdrawFailed(int transactionId) {
			this.transactionId = transactionId;
		}
	}
}
