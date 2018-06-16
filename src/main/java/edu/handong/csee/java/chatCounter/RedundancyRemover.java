package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class checks whether ndm includes or not and return boolean result
 * @author heeseok
 *
 */
public class RedundancyRemover {
//	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	boolean result;

	/**
	 * this method checks ndm includes ndmData and returns true or false
	 */
	public HashMap<String, ArrayList<NDMData>> removeRedundancy(HashMap<String, ArrayList<NDMData>> allMessages) {
		HashMap<String, ArrayList<NDMData>> newMessages = new HashMap<String, ArrayList<NDMData>>();
		
		String compareName;
		String compareDate;
		String compareMessage;
		for(String key : allMessages.keySet()) {
			for(NDMData data : allMessages.get(key)) {
				compareDate = data.getDate();
				compareMessage = data.getMessage();
				compareName = data.getName();
				String longMessage;
				String shortMessage;
				if(!newMessages.containsKey(compareName)) {
					newMessages.put(compareName, new ArrayList<NDMData>());
				}
				for(String key2 : newMessages.keySet()) {
					if(newMessages.get(key2).isEmpty())
						newMessages.get(key2).add(data);
					else
						for(NDMData data2 : newMessages.get(key2)) {
							String newDate = data2.getDate();
							String newMessage = data2.getMessage();
							String newName = data2.getName();

							if(compareMessage.length() > newMessage.length()) {
								longMessage = compareMessage;
								shortMessage = newMessage;
							}
							else {
								longMessage = newMessage;
								shortMessage = compareMessage;
							}
							if(compareDate.equals(newDate) 
									&& longMessage.trim().startsWith(shortMessage.trim()) 
									&& compareName.equals(newName)) continue;
							else {
								newMessages.get(compareName).add(data);
								//							newMessages.put(key, data);
							}
						}
				}
				
			}
		}

//		String name = allMessages.getName();
//		String date = allMessages.getDate();
//		String message = allMessages.getMessage();
		
//		for(NDMData keys : ndmData) {
//			cDate = keys.getDate();
//			cMessage = keys.getMessage();
//			cName = keys.getName();
//			String longMessage;
//			String shortMessage;
//			if(cMessage.length() > message.length()) {
//				longMessage = cMessage;
//				shortMessage = message;
//			}
//			else {
//				longMessage = message;
//				shortMessage = cMessage;
//			}
//			if(cDate.equals(date) && longMessage.trim().startsWith(shortMessage.trim()) && cName.equals(name)) return false;


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
//		for(NDMData keys : ndmData) {
//			cDate = keys.getDate();
//			cMessage = keys.getMessage();
//			cName = keys.getName();
//			String longMessage;
//			String shortMessage;
//			if(cMessage.length() > message.length()) {
//				longMessage = cMessage;
//				shortMessage = message;
//			}
//			else {
//				longMessage = message;
//				shortMessage = cMessage;
//			}
//			if(cDate.equals(date) && longMessage.trim().startsWith(shortMessage.trim()) && cName.equals(name)) return false;

			//if(cDate.equals(date) && cMessage.equals("cmd창에서 gradle -v 입력하니까 에러 메세지가 뜹니당..")) return false;
			//if(cDate.equals(date) && cMessage.contains(message)) return false;
			//if(date.equals(cDate) && message.contains(cMessage)) return false;
		
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

