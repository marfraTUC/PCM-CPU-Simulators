package bankAccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
	public static final boolean WITHDRAW_FAILABLE = true;
	
	public static void main(String[] args) {
		
		final Config conf = ConfigFactory.load("application.conf");
		ActorSystem system = ActorSystem.create("BankAccount",conf.getConfig("akka"));
		Bank bank = new Bank(system);
		List<Transaction> transactions = new ArrayList<>();
		
		if(args.length > 0){
			System.out.println("from File");
			File file = new File(args[0]);
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				line = br.readLine();

				while(line != null && !line.isEmpty()){
					int amount = Integer.parseInt(line);
					bank.createAccount(amount);
					line = br.readLine();
				}
				
				int id = 0;
				line = br.readLine();
				while(line != null){
					String[] triple = line.split(" ");
					ActorRef source = bank.accountByNumber(Integer.parseInt(triple[0]));
					ActorRef target = bank.accountByNumber(Integer.parseInt(triple[1]));
					transactions.add(new Transaction(id,source, target, Integer.parseInt(triple[2])));
					line = br.readLine();
					id++;
				}
				br.close();
				
				ActorRef experimentManager = system.actorOf(Props.create(bankAccount.ExperimentManagerActor.class,transactions).withDispatcher("my-dispatcher"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("not from File");
			System.out.println(system.dispatchers());
			
			for (int i = 0; i < 1000; i++){
				bank.createAccount(100);
			}
			
			int id = 0;
			for(int i = 0; i < 500; i++){
				for(int j = 0; j < 5000; j++){
					ActorRef source = bank.accountByNumber(i);
					ActorRef target = bank.accountByNumber(i+500);
					transactions.add(new Transaction(id,source,target, 1));
					id++;
				}
			}
			
			ActorRef experimentManager = system.actorOf(Props.create(bankAccount.ExperimentManagerActor.class,transactions).withDispatcher("my-dispatcher"));
		}	
	}		
	/*
		if(args.length > 0){
			File file = new File(args[0]);
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				line = br.readLine();

				while(line != null && !line.isEmpty()){
					int amount = Integer.parseInt(line);
					bank.tell(new bankAccount.BankActor.CreateAccount(amount), ActorRef.noSender());
					line = br.readLine();
				}
				
				line = br.readLine();
				while(line != null){
					String[] triple = line.split(" ");
					ActorRef transaction = system.actorOf(Props.create(
							bankAccount.MoneyTransferActor.class,
							bank,
							Integer.parseInt(triple[0]),
							Integer.parseInt(triple[1]), 
							Integer.parseInt(triple[2])));
					transactions.add(transaction);
					line = br.readLine();
				}
				br.close();
				
				Thread.sleep(1000);
				ActorRef experimentManager = system.actorOf(Props.create(bankAccount.ExperimentManagerActor.class,transactions));
				//system.terminate();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}*/
}
