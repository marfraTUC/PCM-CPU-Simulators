package bankAccount;

import akka.actor.ActorRef;

public class Transaction {
	ActorRef sourceAccount, targetAccount;
	int id,amount;
	public Transaction(int id,ActorRef sourceAccount, ActorRef targetAccount, int amount) {
		this.id = id;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
	}

}
