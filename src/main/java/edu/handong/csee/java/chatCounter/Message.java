package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
	private HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();

	public HashMap<String, ArrayList<String>> getMessages() {
		return messages;
	};
	
	public void setMessages(ArrayList<File> fileNames) {
		String thisLine;
		String temp = null;
		for(File fileName:fileNames) {
			try {
		         BufferedReader br = new BufferedReader(
		                  new InputStreamReader(
		                               new FileInputStream(fileName), "UTF8"));
				while ((thisLine = br.readLine()) != null) { // while loop begins here
					temp += thisLine;
		         }
				if(!messages.containsKey(user)) {
					messages.put(user,  new ArrayList<String>());
				}
				
				NDMData ndmData = new NDMData(user, date, )
				messages.put(fileName.toString(), temp);
		        br.close();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		}
	}
}
