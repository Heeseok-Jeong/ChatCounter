package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParserForMac implements MessageParser{
	HashMap<String, ArrayList<NDMData>> map = new HashMap<String, ArrayList<NDMData>>();
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	String user = new String();
	boolean result = true;
	
	public void parse(File fileName) {
			Reader in = null;
			try {
				in = new FileReader(fileName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
				NDMData ndm = new NDMData(record.get(1), record.get(0).substring(10,16), record.get(2));
				rc.setNdmData(ndmData);
				user = ndm.getName();
				if(result = rc.checkRedundancy(ndm)) {
					ndmData.add(ndm);
					map.put(user, ndmData);
				}
			}

	}

	public ArrayList<NDMData> getNdmData() {
		return ndmData;
	}

	public HashMap<String, ArrayList<NDMData>> getMap() {
		return map;
	}

	public void setMap(HashMap<String, ArrayList<NDMData>> map) {
		this.map = map;
	}

	public void setNdmData(ArrayList<NDMData> ndmData) {
		this.ndmData = ndmData;
	}

	
	
}