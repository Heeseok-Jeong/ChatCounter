package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class can merge ndmData of pfwRunners into newMessages on checking redundancy
 * @author heeseok
 *
 */
public class RedundancyRemover {
	boolean result;
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	ArrayList<ParserForMac> pfmRunners;
	ArrayList<ParserForWindows> pfwRunners;

	/**
	 * constructor to set instance variables, pfmRunners and pfwRunners
	 */
	public RedundancyRemover(ArrayList<ParserForMac> pfmRunners, ArrayList<ParserForWindows> pfwRunners) {
		this.pfmRunners = pfmRunners;
		this.pfwRunners = pfwRunners;
	}

	/**
	 * this method checks that ndm includes ndmData and returns true or false
	 */
	private boolean checkRedundancy(NDMData ndm) {
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
	 * this method saves ndmData of pfmRunners and pfwRunners into newMessages on checking redundancy and returns newMessages
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
						newMessages.get(data.getName()).add(data);
					}
				}
			}
		}
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

