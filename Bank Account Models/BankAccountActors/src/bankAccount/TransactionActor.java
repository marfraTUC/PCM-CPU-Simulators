package bankAccount;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import bankAccount.AccountActor.DepositSuccessful;
import scala.concurrent.Future;

public class TransactionActor extends UntypedActor {
	private ActorRef experimentManager;
	
	public TransactionActor(ActorRef experimentManager) {
		this.experimentManager = experimentManager;
	}
	
	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof ExecuteTransaction){
			ExecuteTransaction execute = (ExecuteTransaction) message;
			
			Future<Object> future = Patterns.ask(execute.transaction.sourceAccount,
					new AccountActor.Withdraw(execute.transaction.id,execute.transaction.amount), 1000000);
			
			future.onSuccess(new OnSuccess<Object>() {
				@Override
				public void onSuccess(Object result) {
					if (result instanceof AccountActor.WithdrawSuccessful) {
						execute.transaction.targetAccount.tell(new AccountActor.Deposit(execute.transaction.id,execute.transaction.amount), getSelf());
					} else if (result instanceof AccountActor.WithdrawFailed) {
						experimentManager.tell(new TransactionDone(execute.transaction.id, TransferStatus.FAILED), getSelf());
					} else {
						experimentManager.tell(new TransactionDone(execute.transaction.id, TransferStatus.FAILED), getSelf());
					}
				}
			}, context().dispatcher());

			future.onFailure(new OnFailure() {
				@Override
				public void onFailure(Throwable failure) {
					experimentManager.tell(new TransactionDone(execute.transaction.id, TransferStatus.FAILED), getSelf());
				}
			}, context().dispatcher());
		}
		else if(message instanceof DepositSuccessful){
			DepositSuccessful depositSuccess = (DepositSuccessful) message;
			//System.out.println(getSelf().path().name() + depositSuccess.transactionId);
			this.experimentManager.tell(new TransactionDone(depositSuccess.transactionId,TransferStatus.COMPLETED), getSelf());
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
}
