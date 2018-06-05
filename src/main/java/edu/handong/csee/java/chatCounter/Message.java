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
		//		allMessages.putAll(csvMessages);
		//		allMessages.putAll(txtMessages);
		//		allMessages = Stream.of(csvMessages, txtMessages).flatMap(m -> m.entrySet().stream())
		//			       .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

	}

}
//
//public HashMap<String, ArrayList<NDMData>> deepMerge(HashMap<String, ArrayList<NDMData>> original, HashMap<String, ArrayList<NDMData>> newMap) {
//    for (Object key : newMap.keySet()) {
//        if (newMap.get(key) instanceofMap && original.get(key) instanceof Map) {
//            Map originalChild = (Map) original.get(key);
//            Map newChild = (Map) newMap.get(key);
//            original.put(key, deepMerge(originalChild, newChild));
//        } else {
//            original.put(key, newMap.get(key));
//        }
//    }
//    return original;
//}

