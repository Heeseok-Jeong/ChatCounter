package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParserForMac implements MessageParser{
	static ArrayList<String> names = null;
	static ArrayList<String> dates = null;
	static ArrayList<String> messages = null;
	//ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	
	public void parse(File fileName) {
			Reader in = null;
			try {
				in = new FileReader(fileName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//in = new FileReader(file);
			Iterable<CSVRecord> records = null;
			try {
				records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RedundancyChecker rc = new RedundancyChecker();
			
			for (CSVRecord record : records) {
				NDMData ndm = new NDMData(record.get(1), record.get(0).substring(11,16), record.get(2));
				if(rc.checkRedundancy(messages, names) {
				
				}
				names.add(ndm.getName());
				dates.add(ndm.getDate());
				messages.add(ndm.getMessage());
//				names.add(record.get(1));
//				dates.add(record.get(0).substring(11,16));
//				messages.add(record.get(2));
				//this.ndmData(record.get(1), record.get(0).substring(11,16), record.get(2));
				//NDMData배열을 만들어서 내용을 넣고 싶은데... records의 역할이 뭐지?
			}
	}

	public static ArrayList<String> getNames() {
		return names;
	}

	public static void setNames(ArrayList<String> names) {
		ParserForMac.names = names;
	}

	public static ArrayList<String> getDates() {
		return dates;
	}

	public static void setDates(ArrayList<String> dates) {
		ParserForMac.dates = dates;
	}

	public static ArrayList<String> getMessages() {
		return messages;
	}

	public static void setMessages(ArrayList<String> messages) {
		ParserForMac.messages = messages;
	}
	
}