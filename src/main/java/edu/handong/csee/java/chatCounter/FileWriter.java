package edu.handong.csee.java.chatCounter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class writes a csv file with a HashMap
 * @author heeseok
 *
 */
public class FileWriter {
	HashMap<String, Integer> output = new HashMap<String, Integer>();
	ArrayList<String> kakaoID = new ArrayList<String>();
	String string = null;
	
	/**
	 * this method has two parameters and makes a csv file with them
	 */
	public void writeCSV(String savePath, HashMap<String, Integer> finalOutput) {
		try {
			BufferedWriter bw = new BufferedWriter(
			          new OutputStreamWriter(
			                       new FileOutputStream(savePath), "UTF8"));
			try {
				bw.write("Kakaotalk_id, Count");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//정렬 해야한다.
			//Iterator it = sortByValue(output).iterator();

			for(String keys : output.keySet()) {
				string = keys + ", " + output.get(keys);
				try {
					bw.write(string);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
//	    public CSVWrite() {
//	 
//	    public void writeCsv(List<String[]> data) {
//	        try {
//	            CSVWriter cw = new CSVWriter(new FileWriter(savePath), ',', '"');
//	            Iterator<String[]> it = data.iterator();
//	            try {
//	                while (it.hasNext()) {
//	                    String[] s = (String[]) it.next();
//	                    cw.writeNext(s);
//	                }
//	            } finally {
//	                cw.close();
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
		
		
	}

}
