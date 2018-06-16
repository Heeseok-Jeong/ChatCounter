package edu.handong.csee.java.chatCounter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.*;

/**
 * this class writes a csv file with a HashMap to savePath
 * @author heeseok
 *
 */
public class FileWriter {
	ArrayList<String> kakaoID = new ArrayList<String>();
	String string = null;

	/**
	 * this method has two parameters and makes a csv file with them
	 */
	public void writeCSV(String savePath, HashMap<String, Integer> finalOutput) {


		BufferedWriter bw;
		try {
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(savePath), "UTF8"));


			bw.write("Kakaotalk_id, Count\n");


			/*
			 * 할거 1. window용 파서 안돌아감 2. 중복체크되는지확인 3.정
			 */
			HashMap<String, Integer> sortedMap = sortedByComparator(finalOutput, false);
			for(String keys : sortedMap.keySet()) {
				string = keys + ", " + sortedMap.get(keys) + "\n";
				bw.write(string);
			}
			bw.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private HashMap<String, Integer> sortedByComparator(HashMap<String, Integer> finalOutput, boolean b) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(finalOutput.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Integer>>()
		{
			/**
			 * compare two types
			 */
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2)
			{
				if (b)
				{
					return o1.getValue().compareTo(o2.getValue());
				}
				else
				{
					return o2.getValue().compareTo(o1.getValue());

				}
			}
		});

		// Maintaining insertion order with the help of LinkedList
		HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list)
		{
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
} 

