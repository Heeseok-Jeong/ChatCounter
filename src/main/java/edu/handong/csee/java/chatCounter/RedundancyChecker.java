package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;

/**
 * this class checks whether ndm includes in ndmData or not and return boolean result
 * @author heeseok
 *
 */
public class RedundancyChecker {
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	boolean result;

	/**
	 * this method checks ndm includes in ndmData and returns true or false
	 */
	public boolean checkRedundancy(NDMData ndm) {
		String name = ndm.getName();
		String date = ndm.getDate();
		String message = ndm.getMessage();
		String cName;
		String cDate;
		String cMessage;

		for(NDMData keys : ndmData) {
			cDate = keys.getDate();
			cMessage = keys.getMessage();
			cName = keys.getName();
			String longMessage;
			String shortMessage;
			if(cMessage.length() > message.length()) {
				longMessage = cMessage;
				shortMessage = message;
			}
			else {
				longMessage = message;
				shortMessage = cMessage;
			}
			if(cDate.equals(date) && longMessage.trim().startsWith(shortMessage.trim()) && cName.equals(name)) return false;

		}
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

