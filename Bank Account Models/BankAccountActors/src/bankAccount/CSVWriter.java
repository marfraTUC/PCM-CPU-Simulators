package bankAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CSVWriter {

	private final PrintWriter writer;
	
	
	public CSVWriter(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(new FileOutputStream(
			    new File(filename), 
			    true /* append = true */)); 
	}
	
	public void writeLine(String line){
		writer.println(line);
		writer.flush();
	}
	
	public void close(){
		writer.close();		
	}
}
