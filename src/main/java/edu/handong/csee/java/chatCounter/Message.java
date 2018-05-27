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
//		String thisLine;
//		String temp = null;
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();
		
		for(File fileName:fileNames) {
		        if(fileName.getName().contains(".csv"))
		        	macParser.parse(fileName);
		        else 
		        	winParser.parse(fileName);     
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

