package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;

/**
 * this class can checks whether ndm includes in ndmData or not and return boolean result
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
		String compareName;
		String compareDate;
		String compareMessage;

		for(NDMData keys : ndmData) {
			compareDate = keys.getDate();
			compareMessage = keys.getMessage();
			compareName = keys.getName();
			String longMessage;
			String shortMessage;
			if(compareMessage.length() > message.length()) {
				longMessage = compareMessage;
				shortMessage = message;
			}
			else {
				longMessage = message;
				shortMessage = compareMessage;
			}
			if(compareDate.equals(date) && longMessage.trim().startsWith(shortMessage.trim()) && compareName.equals(name)) return false;

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

