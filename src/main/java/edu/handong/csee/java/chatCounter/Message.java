package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class can reads and parses csv files and txt files with two different type logics on checking redundancy
 * and saves into a HashMap allMessages
 * @author heeseok
 *
 */
public class Message {
	private HashMap<String, ArrayList<NDMData>> allMessages = new HashMap<String, ArrayList<NDMData>>();

	/**
	 * getter of allMessages
	 */
	public HashMap<String, ArrayList<NDMData>> getAllMessages() {
		return allMessages;
	}

	/**
	 * setter of allMessages
	 */
	public void setAllMessages(HashMap<String, ArrayList<NDMData>> allMessages) {
		this.allMessages = allMessages;
	}

	/**
	 * it reads txt files and csv files and properly puts data into allMessages
	 */
	public void setMessages(ArrayList<File> fileNames) throws IOException {
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();

		for(File fileName:fileNames) {
			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
				continue;
			}
			if(fileName.getName().contains(".txt")){
				winParser.parse(fileName); 
				allMessages.putAll(winParser.getMap());
			}
		}
		macParser.setMap(allMessages);
		for(File fileName : fileNames) {
			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
				continue;
			}
			if(fileName.getName().contains(".csv")) {
				macParser.parse(fileName);
				allMessages.putAll(macParser.getMap());
			}
		}

	}

}

