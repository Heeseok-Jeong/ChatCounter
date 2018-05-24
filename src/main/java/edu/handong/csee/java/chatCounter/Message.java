package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
	private HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();

	public HashMap<String, ArrayList<String>> getMessages() {
		return messages;
	};
	
	public void setMessages(ArrayList<File> fileNames) throws IOException {
//		String thisLine;
//		String temp = null;
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();
		
		for(File fileName:fileNames) {
		        BufferedReader br = null;
				try {
					br = new BufferedReader(
					          new InputStreamReader(
					                       new FileInputStream(fileName), "UTF8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        if(fileName.getName().contains(".csv")) {
		        	macParser.parse(fileName);
		        }
		        else 
		        	winParser.parse(fileName);
		
		        br.close();	
		}
		
	}
}
//	while ((thisLine = br.readLine()) != null) { // while loop begins here
//	temp += thisLine;
// }
//
//if(!messages.containsKey(user)) {
//	messages.put(user, new ArrayList<String>());
//}
//
//NDMData ndmData = new NDMData(user, date, )
//messages.put(fileName.toString(), temp);
//br.close();
//} catch (IOException e) {
// e.printStackTrace();
//}

