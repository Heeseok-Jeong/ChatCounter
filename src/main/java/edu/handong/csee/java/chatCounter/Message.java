package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
	private HashMap<String, ArrayList<NDMData>> messages = new HashMap<String, ArrayList<NDMData>>();

	public HashMap<String, ArrayList<NDMData>> getMessages() {
		return messages;
	};
	
	public void setMessages(ArrayList<File> fileNames) throws IOException {
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();
		
		for(File fileName:fileNames) {
		        if(fileName.getName().contains(".csv")) {
		        	macParser.parse(fileName);
		        	messages.putAll(macParser.getMap());
		        }
		        else {
		        	winParser.parse(fileName); 
		        	messages.putAll(winParser.getMap());
		        }
		}
	}
}

