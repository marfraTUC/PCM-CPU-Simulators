package bankAccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static final boolean WITHDRAW_FAILABLE = true;
	
	public static void main(String[] args) {
		Bank bank = new Bank();
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
				
				line = br.readLine();
				while(line != null){
					String[] triple = line.split(" ");
					transactions.add(new Transaction(bank,Integer.parseInt(triple[0]), Integer.parseInt(triple[1]), Integer.parseInt(triple[2])));
					line = br.readLine();
				}
				br.close();
				
				new ExperimentManager(transactions);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("not from File");
			for (int i = 0; i < 1000; i++){
				bank.createAccount(100);
			}
		
			for(int i = 0; i < 500; i++){
				for(int j = 0; j < 1000; j++){
					transactions.add(new Transaction(bank, i, i+500, 1));
				}
			}
		
			try {
				new ExperimentManager(transactions);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}	
	


