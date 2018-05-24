package edu.handong.csee.java.chatCounter;

import java.util.HashMap;

public class MessageParser {
	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	public void parse(HashMap<String, String> messages) {
		for(String key : messages.keySet()) {
			for(NDMData message:users.get(key)) {
				System.out.println(message.getName( + " " + message.getMessage());
			}
		}
		
	}
}
