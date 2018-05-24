package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParserForMac implements MessageParser{
//	ArrayList<String> names = null;
//	ArrayList<String> dates = null;
//	ArrayList<String> messages = null;
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	
	public void parse(File fileName) {
		
			Reader in = null;
			
			
			//in = new FileReader(file);
			Iterable<CSVRecord> records = null;
			try {
				records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (CSVRecord record : records) {
//				names.add(record.get(1));
//				dates.add(record.get(0).substring(11,16));
//				messages.add(record.get(2));
				this.ndmData(record.get(1), record.get(0).substring(11,16), record.get(2));
				//NDMData배열을 만들어서 내용을 넣고 싶은데... records의 역할이 뭐지?
			}
			
	}
}
