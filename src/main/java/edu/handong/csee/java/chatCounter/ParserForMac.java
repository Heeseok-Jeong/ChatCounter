package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.Reader;

public class ParserForMac implements MessageParser{

	
	public void parse(File fileName) {
		
			Reader in;
			
			
				//in = new FileReader(file);
				Iterable<CSVRecord> records =CSVFormat.DEFAULT.withFirstRecordAsHeader().par;
				for (CSVRecord record : records) {
					String time = record.get(0).substring(11,16);
					String user = record.get(1);
					String strMessage = record.get(2);
					
					
				}
			
	}
}
