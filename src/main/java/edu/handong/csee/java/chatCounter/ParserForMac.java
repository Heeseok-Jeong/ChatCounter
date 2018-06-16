package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
//import java.lang.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * this class reads csv type files and makes its contents to HashMap
 * @author heeseok
 *
 */
public class ParserForMac implements Runnable{
	HashMap<String, ArrayList<NDMData>> map = new HashMap<String, ArrayList<NDMData>>();
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	File fileName;
	//String user = new String();
	boolean result = true;
	
	/*
	 * constructor to set fileName
	 */
	public ParserForMac(File fileName) {
		this.fileName = fileName;
	}
	
	@Override
	/**
	 * this method reads csv type files and makes its contents to HashMap, Override
	 */
	public void run() {
		Reader in = null;


		try {
			in = new FileReader(fileName);


			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);

			//RedundancyChecker rc = new RedundancyChecker();

			for (CSVRecord record : records) {
				String user = record.get(1);
				NDMData ndm = new NDMData(record.get(1), record.get(0).substring(11,16), record.get(2));

				if(!map.containsKey(ndm.getName())) {
					map.put(user, new ArrayList<NDMData>());
				}
				//rc.setNdmData(map.get(ndm.getName()));
				//user = ndm.getName();
				ndmData.add(ndm);
				map.get(ndm.getName()).add(ndm);
			}
			//				if(rc.checkRedundancy(ndm)) {
			//					ndmData.add(ndm);
			//					map.get(ndm.getName()).add(ndm);
			//				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			

	/**
	 * getter of ndmData
	 */
	public ArrayList<NDMData> getNdmData() {
		return ndmData;
	}

	/**
	 * getter of map
	 */
	public HashMap<String, ArrayList<NDMData>> getMap() {
		return map;
	}

	/**
	 * setter of map
	 */
	public void setMap(HashMap<String, ArrayList<NDMData>> map) {
		this.map = map;
	}

	/**
	 * setter of ndmData
	 */
	public void setNdmData(ArrayList<NDMData> ndmData) {
		this.ndmData = ndmData;
	}


}