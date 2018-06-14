package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class checks whether ndm includes or not and return boolean result
 * @author heeseok
 *
 */
public class RedundancyChecker {
//	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	boolean result;

	/**
	 * this method checks ndm includes ndmData and returns true or false
	 */
	public HashMap<String, ArrayList<NDMData>> checkRedundancy(HashMap<String, ArrayList<NDMData>> allMessages) {
		HashMap<String, ArrayList<NDMData>> newMessages;
		String name = allMessages.getName();
		String date = allMessages.getDate();
		String message = allMessages.getMessage();
		String cName;
		String cDate;
		String cMessage;

//		for(String key : newMessages.keySet()) {
//			for(int i = 0; i < newMessages.get(key).size(); i++) {
//				new 
//				String nameOfData = data.getName();
//				String dateOfData = data.getDate();
//				String messageOfData = data.getMessage();
//				for(NDMData compareData : )
//				if(cDate.equals(date) && longMessage.trim().startsWith(shortMessage.trim()) && cName.equals(name)) {
//					
//				}
//			}
//		}
		
		//result = true;
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

			//if(cDate.equals(date) && cMessage.equals("cmd창에서 gradle -v 입력하니까 에러 메세지가 뜹니당..")) return false;
			//if(cDate.equals(date) && cMessage.contains(message)) return false;
			//if(date.equals(cDate) && message.contains(cMessage)) return false;
		}
		//if(ndmData.contains(ndm)) result = false;

		return newMessages;
	}

//	/**
//	 * getter of ndmData
//	 */
//	public ArrayList<NDMData> getNdmData() {
//		return ndmData;
//	}
//
//	/**
//	 * setter of ndmData
//	 */
//	public void setNdmData(ArrayList<NDMData> ndmData) {
//		this.ndmData = ndmData;
//	}
}

