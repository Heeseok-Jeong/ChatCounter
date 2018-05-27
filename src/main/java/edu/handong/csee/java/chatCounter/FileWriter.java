package edu.handong.csee.java.chatCounter;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWriter {
	HashMap<String, Integer> output = new HashMap<String, Integer>();
	ArrayList<String> kakaoID = new ArrayList<String>();
	
	public void writeCSV(String savePath) {
		try {
			BufferedWriter bw = new BufferedWriter(
			          new OutputStreamWriter(
			                       new FileOutputStream(savePath), "UTF8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bw.write
		 
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
