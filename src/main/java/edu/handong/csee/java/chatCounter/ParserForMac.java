package edu.handong.csee.java.chatCounter;

import java.io.File;

public class ParserForMac extends MessageParser{

	
	public void readMacFile() {
		for(File file: directory.listFiles()) {
			if(file.getName().contains((".csv")) {
				Reader in;
				try {
					int = new FileReader(file);
					Iterable<CSVRecord> records =CSVFormat.DEFAULT.withFirstRecordAsHeader().par;
					for (CSVRecord record : records) {
						String time = record.get(0).substring(11,16);
						String user = record.get(1);
						String strMessage = record.get(2);
						
						
					}
				}
			}
		}
	}
}
