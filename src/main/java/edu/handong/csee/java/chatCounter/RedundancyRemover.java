package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * this class checks whether ndm includes or not and return boolean result
 * @author heeseok
 *
 */
public class RedundancyRemover {
	boolean result;
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	ArrayList<ParserForMac> pfmRunners;
	ArrayList<ParserForWindows> pfwRunners;

	public RedundancyRemover(ArrayList<ParserForMac> pfmRunners, ArrayList<ParserForWindows> pfwRunners) {
		this.pfmRunners = pfmRunners;
		this.pfwRunners = pfwRunners;
	}

	/**
	 * this method checks ndm includes ndmData and returns true or false
	 */
	private boolean checkRedundancy(NDMData ndm) {
		String name = ndm.getName();
		String date = ndm.getDate();
		String message = ndm.getMessage();
		String cName;
		String cDate;
		String cMessage;

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

		return true;
	}

	/**
	 * this method checks ndm includes ndmData and returns true or false
	 */
	public HashMap<String, ArrayList<NDMData>> removeRedundancy() {
		HashMap<String, ArrayList<NDMData>> newMessages = new HashMap<String, ArrayList<NDMData>>();

		//뉴메세지에 올메세지 키-밸류-어레이리스트에있는 각각의 데이터를 넣는데 중복체크를할거다 
		for(ParserForMac pfmRunner : pfmRunners) {
			for(String key : pfmRunner.map.keySet()) {
				if(!newMessages.containsKey(key)) {
					newMessages.put(key, new ArrayList<NDMData>());
				}
				setNdmData(newMessages.get(key));
				for(NDMData data : pfmRunner.map.get(key)) {
					if(checkRedundancy(data)) {
						//ndmData.add(data);
						newMessages.get(data.getName()).add(data);
					}
				}
			}
		}
		for(ParserForWindows pfwRunner : pfwRunners) {
			for(String key : pfwRunner.map.keySet()) {
				if(!newMessages.containsKey(key)) {
					newMessages.put(key, new ArrayList<NDMData>());
				}
				setNdmData(newMessages.get(key));
				for(NDMData data : pfwRunner.map.get(key)) {
					if(checkRedundancy(data)) {
						//ndmData.add(data);
						newMessages.get(data.getName()).add(data);
					}
				}
			}
		}
		//		String compareName;
		//		String compareDate;
		//		String compareMessage;
		//		for(String key : allMessages.keySet()) {
		//			Iterator<NDMData> iter = allMessages.get(key).iterator();
		//			while(iter.hasNext()) {
		//				NDMData data = iter.next();
		//				compareDate = data.getDate();
		//				compareMessage = data.getMessage();
		//				compareName = data.getName();
		//				String longMessage;
		//				String shortMessage;
		//				if(!newMessages.containsKey(compareName)) {
		//					newMessages.put(compareName, new ArrayList<NDMData>());
		//				}
		//				for(String key2 : newMessages.keySet()) {
		//					if(newMessages.get(key2).isEmpty())
		//						newMessages.get(key2).add(data);
		//					else {
		//						Iterator<NDMData> iter2 = allMessages.get(key).iterator();
		//						while(iter2.hasNext()) {
		//							NDMData data2 = iter2.next();
		//							String newDate = data2.getDate();
		//							String newMessage = data2.getMessage();
		//							String newName = data2.getName();
		//
		//							if(compareMessage.length() > newMessage.length()) {
		//								longMessage = compareMessage;
		//								shortMessage = newMessage;
		//							}
		//							else {
		//								longMessage = newMessage;
		//								shortMessage = compareMessage;
		//							}
		//							if(compareDate.equals(newDate) 
		//									&& longMessage.trim().startsWith(shortMessage.trim()) 
		//									&& compareName.equals(newName)) continue;
		//							else {
		//								newMessages.get(compareName).add(data);
		//								//							newMessages.put(key, data);
		//							}
		//						}
		//					}
		//				}
		//				
		//			}
		//		}

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

