package bankAccount;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExperimentManager {
	
	/**
	 * CSV file writer which is used to write the measurements in a csv file
	 */
	private final CSVWriter writer;

	/**
	 * line record for the CSVWriter
	 */
	private String record;
	
	/**
	 * number of repetition - the experiment will be repeated x times
	 */
	private static final int EXPERIMENT_RUNS = 1;
	
	private List<Transaction> transactions;

	/**
	 * @throws IOException
	 *             when CSVWriter can not access file
	 */
	public ExperimentManager(List<Transaction> transactions) throws IOException {
		this.transactions = transactions;
		Transaction[] transactionsArray = this.transactions.toArray(new Transaction[this.transactions.size()]);
		
		writer = new CSVWriter(getDate() + ".csv");
		record = new StringBuilder().append("Run_Nr").append(";").append("Duration in ns").append(";")
				.append("Failed Transactions").toString();
		writer.writeLine(record);	
		
		// experiment RUN
		for(int i = 0; i < EXPERIMENT_RUNS;i++){
			System.out.println("Run " + i + ":");
			
			// execute transactions
			long start = System.nanoTime();
			processTransactions(transactionsArray);
			long totalDuration = System.nanoTime()-start;
			// fail counter
			int failedCount = 0;
			for (Transaction transaction : this.transactions) {
				if(transaction.getStatus() == TransferStatus.FAILED) failedCount++;
			}
			
			System.out.println("took " + totalDuration + "ns (" + failedCount + " failed of "+ this.transactions.size() +" transactions)");
			
			// write results
			record = new StringBuilder().append(i).append(";").append(totalDuration).append(";").append(failedCount).toString();
			writer.writeLine(record);
			
			int  count = 0;
			for (Transaction moneyTransfer : this.transactions) {
				writeResultToFile(count, moneyTransfer);
				count++;
			}
			resetTransactions();
		}

		int  count = 0;
		for (Transaction moneyTransfer : this.transactions) {
			writeResultToFile(count, moneyTransfer);
			count++;
		}
		
//		record = new StringBuilder().append("Total Time").append(";").append(totalDuration).toString();
//		writer.writeLine(record);
		writer.close();
	}

	private void writeResultToFile(int tranferNumber, Transaction transfer) {
//		Account src = transfer.getSourceAccount();
//		Account trg = transfer.getTargetAccount();
		long duration = transfer.getProcessDuration();
//		int amount = transfer.getAmount();
		TransferStatus status = transfer.getStatus();
		record = new StringBuilder().append(tranferNumber).append(";")
//				.append(src.getAccountId()).append(";")
//				.append(trg.getAccountId()).append(";")
//				.append(amount).append(";")
				.append(duration).append(";")
				.append(status.toString()).toString();
		writer.writeLine(record);
	}

	private void resetTransactions(){
		for (Transaction transaction : this.transactions) {
			transaction.reset();
		}
	}
	private String getDate() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

		Date today = Calendar.getInstance().getTime();

		return df.format(today);
	}


	private void processTransactions(Transaction[] transactions) {	
		System.out.println("Start process transactions");
		
		
		int length = transactions.length;
//		// omp parallel threadNum(2)
//		{
//			int partSize=length/OMP4J_NUM_THREADS;
//			Transaction[] part = new Transaction[partSize];
//			System.arraycopy(transactions, partSize* OMP4J_NUM_THREADS, part, 0, partSize);
//			for (int i = 0; i < partSize; i++) {
//				part[i].execute();
//			}			
//		}
		
		
		// single threaded
		for (int i = 0; i < length; i++) {
		transactions[i].execute();
		}		
	}
}
