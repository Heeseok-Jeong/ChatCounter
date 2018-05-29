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
		String date = ndm.getDate();
		String message = ndm.getMessage();
		String cDate;
		String cMessage;
		//result = true;
		for(NDMData keys : ndmData) {
			cDate = keys.getDate();
			cMessage = keys.getMessage();
			if(cDate.equals(date) && cMessage.equals(message)) return false;
		}
		//if(ndmData.contains(ndm)) result = false;
		
		return true;
	}

	/**
	 * getter of ndmData
	 */
	public ArrayList<NDMData> getNdmData() {
		return ndmData;
	}

	/**
	 * setter of ndmData
	 */
	public void setNdmData(ArrayList<NDMData> ndmData) {
		this.ndmData = ndmData;
	}
}

