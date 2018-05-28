package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class reads and parses all files with two different type logics and makes final HashMap
 * @author heeseok
 *
 */
public class Message {
	private HashMap<String, ArrayList<NDMData>> messages = new HashMap<String, ArrayList<NDMData>>();

	/**
	 * getter of messages
	 */
	public HashMap<String, ArrayList<NDMData>> getMessages() {
		return messages;
	};
	
	public void setMessages(ArrayList<File> fileNames) throws IOException {
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();
		
		for(File fileName:fileNames) {
				if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
					continue;
				}
		        if(fileName.getName().contains(".csv")) {
		        	macParser.parse(fileName);
		        	messages.putAll(macParser.getMap());
		        }
		        else if(fileName.getName().contains(".txt")){
		        	winParser.parse(fileName); 
		        	messages.putAll(winParser.getMap());
		        }
		}
	}

	/**
	 * setter of messages
	 */
	public void setMessages(HashMap<String, ArrayList<NDMData>> messages) {
		this.messages = messages;
	}
}

