package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;

/**
 * this class checks whether ndm includes or not and return boolean result
 * @author heeseok
 *
 */
public class RedundancyChecker {
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	boolean result;
	
	/**
	 * this method checks ndm includes ndmData and returns true or false
	 */
	public boolean checkRedundancy(NDMData ndm) {
		result = true;
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

