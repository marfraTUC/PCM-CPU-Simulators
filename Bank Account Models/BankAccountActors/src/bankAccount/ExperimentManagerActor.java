package bankAccount;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;
import bankAccount.AccountActor.TransactionDone;

public class ExperimentManagerActor extends UntypedActor {

	/**
	 * CSV file writer which is used to write the measurements in a csv file
	 */
	private final CSVWriter writer;

	/**
	 * line record for the CSVWriter
	 */
	private String record;
	
	private ActorRef transactionActor;
	private List<Transaction> transactions;
	
	private int transactionCount;
	private int failedCount;
	private long start,end = -1;
	private AtomicInteger index = new AtomicInteger(0);
	
	public ExperimentManagerActor(List<Transaction> transactions) throws IOException {
		this.transactions = transactions;
		this.transactionCount = transactions.size();
		writer = new CSVWriter("BankActor" + ".csv");
//		record = new StringBuilder().append("Trans_Nr").append(";").append("Src_Id").append(";")
//				.append("Trg_Id").append(";").append("Amount").append(";").append("Duration").append(";")
//				.append("Status").toString();
//		writer.writeLine(record);
		ActorSystem system = getContext().system();
//		ActorRef transactionActor = system.actorOf(Props.create(bankAccount.TransactionActor.class,getSelf()), "transaction");
//		this.transactionActor = transactionActor;
		
		processTransactions();
	}
	
	public static String getDate() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

		Date today = Calendar.getInstance().getTime();

		return df.format(today);
	}
	
	private void writeResultToFile(long[] result) {
		record = new StringBuilder()
				.append(result[0]).append(";").toString();
		writer.writeLine(record);
	}
	
	private void processTransactions() {	
		System.out.println("start execute "+ transactions.size());
		this.start = System.nanoTime();

		for (int i=0;i<1;i++){
			transactions.get(this.index.get()).sourceAccount.tell(new AccountActor.ExecuteTransaction(transactions.get(this.index.get())), getSelf());
			this.index.incrementAndGet();
		}
	}	

	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof TransactionDone){
			if (index.get() < transactions.size())transactions.get(this.index.get()).sourceAccount.tell(new AccountActor.ExecuteTransaction(transactions.get(this.index.get())), getSelf());
			this.index.incrementAndGet();
			TransactionDone transaction = (TransactionDone) message;
			this.transactionCount--;
//			System.out.println(transactionCount);
			if(transaction.status == TransferStatus.FAILED) failedCount++;
			if(this.transactionCount == 0){
				this.end = System.nanoTime();
				
				long totalDuration = this.end-this.start;
				System.out.println(totalDuration + " " + this.failedCount + " failed");
//
				record = new StringBuilder().append("Time in ns").append(";").append(totalDuration).append(";").append(this.failedCount).toString();
				writer.writeLine(record);
				writer.close();
				context().system().terminate();
			}
		}
	}
}


