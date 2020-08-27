package bankAccount;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CSVWriter {

	private final PrintWriter writer;
	
	
	public CSVWriter(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		writer = new PrintWriter(filename, "UTF-8");
	}
	
	public void writeLine(String line){
		writer.println(line);
		writer.flush();
	}
	
	public void close(){
		writer.close();		
	}
}
