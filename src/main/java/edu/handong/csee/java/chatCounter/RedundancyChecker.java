package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;

public class RedundancyChecker {
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	boolean result = true;
	
	public boolean checkRedundancy(NDMData ndm) {
		if(ndmData.contains(ndm)) result = false;
		
		return result;
	}
//		boolean bool = true;
//		String check = "year+\"-\"+month+\"-\"+day+\" \"+hour+\":\"+min+\" \"+name+\" \"+message";
//		if(messages.contains(check)) {
//			messages.add(check);
//			bool = true;
//		}
//		if(bool) {
//			names.add(name);						
//			bool = false;
//		}
//		return bool;
//	}

	public ArrayList<NDMData> getNdmData() {
		return ndmData;
	}

	public void setNdmData(ArrayList<NDMData> ndmData) {
		this.ndmData = ndmData;
	}
}

