package bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Bank {
	private final Map<Integer, ActorRef> accounts = new HashMap<>();
	private final AtomicInteger lastAccountId = new AtomicInteger(-1);
	private ActorSystem system;
	
	public Bank(ActorSystem system) {
		this.system = system;
	}
	public ActorRef createAccount(int balance) {
		ActorRef newAccount = system.actorOf(Props.create
				(AccountActor.class,this.lastAccountId.incrementAndGet(),balance), "" + this.lastAccountId.get());
		this.accounts.put(this.lastAccountId.get(), newAccount);
		return newAccount;
	}
	
	public ActorRef accountByNumber(int accountNumber){
		return accounts.get(accountNumber);
	}
}
