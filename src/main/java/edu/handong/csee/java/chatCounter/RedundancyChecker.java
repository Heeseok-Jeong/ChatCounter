package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;

public class RedundancyChecker {
	
	public boolean checkRedundancy(ArrayList<String> messages, ArrayList<String> names) {
		boolean bool = true;
		String check = "year+\"-\"+month+\"-\"+day+\" \"+hour+\":\"+min+\" \"+name+\" \"+message";
		if(messages.contains(check)) {
			messages.add(check);
			bool = true;
		}
		if(bool) {
			names.add(name);						
			bool = false;
		}
		return bool;
	}
}

