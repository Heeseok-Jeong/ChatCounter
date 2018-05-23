package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
	private HashMap<String, String> messages = new HashMap<String, String>();

	public HashMap<String, String> getMessages() {
		return messages;
	};
	
	public void setMessages(ArrayList<File> fileNames) {
		String thisLine;
		for(File fileName:fileNames) {
			try {
		         BufferedReader br = new BufferedReader(
		                  new InputStreamReader(
		                               new FileInputStream(fileName), "UTF8"));
				while ((thisLine = br.readLine()) != null) { // while loop begins here
					messages.put(fileName.toString(), thisLine);
		         }
		         br.close();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		}
	}
}
