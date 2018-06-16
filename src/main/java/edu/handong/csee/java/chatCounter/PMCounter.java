package edu.handong.csee.java.chatCounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class can counts each people's talking amounts
 * @author heeseok
 *
 */
public class PMCounter {
	HashMap<String, Integer> count = new HashMap<String, Integer>();
	ArrayList<String> string = new ArrayList<String>();
	ArrayList<Integer> integer = new ArrayList<Integer>();
	Integer size;

	/**
	 * this method makes count HashMap with input messages and returns count 
	 */
	public HashMap<String, Integer> computePM(HashMap<String, ArrayList<NDMData>> messages) {
		for(String keys : messages.keySet()) {
			size = messages.get(keys).size();
			//			if(count.containsKey(keys) != messages.containsKey(keys)) {
			count.put(keys, size);
			//			}

		}

		return count;
	}

}
