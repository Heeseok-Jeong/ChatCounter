package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this class reads txt type files and makes its contents to HashMap
 * @author heeseok
 *
 */
public class ParserForWindows implements Runnable{
	HashMap<String, ArrayList<NDMData>> map = new HashMap<String, ArrayList<NDMData>>();
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	String date;
	File fileName;

	String user = new String();
	String name, message;
	int year, month, day, hour, min;

	/**
	 * getter of map
	 */
	public HashMap<String, ArrayList<NDMData>> getMap() {
		return map;
	}

	/**
	 * setter of map
	 */
	public void setMap(HashMap<String, ArrayList<NDMData>> map) {
		this.map = map;
	}

	/**
	 * getter of hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * setter of hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public ParserForWindows(File fileName) {
		this.fileName = fileName;
	}

	@Override
	/**
	 * this method overrides its interface and reads txt type files and makes its contents to HashMap, Override
	 */
	public void run() {
		String temp;
		BufferedReader br;

		try {
			br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), "UTF8"));


			//분류하
			String pKorMessage = "\\[(.+)\\]\\s\\[(.+)\\s([0-9]+):([0-9]+)\\]\\s(.+)";
			Pattern p1 = Pattern.compile(pKorMessage);
			String pKorDate = "-+\\s([0-9]+).\\s([0-9]+).\\s([0-9]+).\\s.+\\s-+";
			Pattern p2 = Pattern.compile(pKorDate);
			String pEngMessage = "\\[(.+)\\]\\s\\[([0-9]+):([0-9]+)\\s(.+)\\]\\s(.+)";
			Pattern p3 = Pattern.compile(pEngMessage);
			String pEngDate = "-+\\s.+,\\s(.+)\\s([0-9]+),\\s([0-9]+)\\s.+\\s-+";
			Pattern p4 = Pattern.compile(pEngDate);

			while((temp = br.readLine()) != null) {
				Matcher match1 = p1.matcher(temp);
				Matcher match3 = p3.matcher(temp);
				Matcher match2 = p2.matcher(temp);
				Matcher match4 = p4.matcher(temp);		

				if(match2.find()) {
					year = Integer.parseInt(match2.group(1));
					month = Integer.parseInt(match2.group(2));
					day = Integer.parseInt(match2.group(3));
					continue;
				}
				else if(match4.find()) {
					year = Integer.parseInt(match4.group(3));
					month = Integer.parseInt(convert(match4.group(1)));
					day = Integer.parseInt(match4.group(2));
					continue;
				}

				else if(match1.find()) {
					name = match1.group(1);
					message = match1.group(5);
					hour = Integer.parseInt(match1.group(3));					
					min = Integer.parseInt(match1.group(4));

					if(match1.group(2).equals("오후")) {
						if(hour == 12) ;
						else hour += 12;
					}
					if(match1.group(2).equals("오전") && hour == 12) hour = 0;
				}
				else if(match3.find()) {
					name = match3.group(1);
					message = match3.group(5);
					hour = Integer.parseInt(match3.group(2));
					min = Integer.parseInt(match3.group(3));	

					if(match3.group(4).equals("PM")) {
						if(hour == 12) ;
						else hour += 12;
					}
					if(match3.group(4).equals("AM") && hour == 12) hour = 0;
				}



				//				else if(match3.find()) {
				//					name = match3.group(1);
				//					message = match3.group(5);
				//					hour = Integer.parseInt(match3.group(2));
				//					min = Integer.parseInt(match3.group(3));	
				//					
				//					if(match1.group(4).equals("PM")) {
				//						if(hour == 12) ;						
				//						else hour += 12;
				//					}
				//					if(match1.group(4).equals("AM") && hour == 12) hour = 0;
				//				}
				else continue;


				date = String.format("%02d", hour) + ":" + String.format("%02d", min);
				NDMData ndm = new NDMData(name, date, message);
				//				if(ndmData != null) ndmData.add(ndm);
				if(!map.containsKey(ndm.getName())) {
					map.put(name, new ArrayList<NDMData>());
				}
				//RedundancyChecker rc = new RedundancyChecker();
				//rc.setNdmData(ndmData);
				//if(rc.checkRedundancy(ndm)) {
				ndmData.add(ndm);
				//					System.out.println("2");
				map.get(ndm.getName()).add(ndm);
				//					for(NDMData data:map.get(ndm.getName())) {
				//						System.out.println(data.getName());
				//						System.out.println(data.getDate());
				//						System.out.println(data.getMessage());
				//					}

			}//
			//ndmData.add(ndm);
			//map.put(name, ndmData);

			//할거 1. match1,3번 시간 am, pm, 오전, 오후 통일해주기
			//할거 2. 여기서 만든거 해쉬맵 넣
			//할거 3. FileWriter 구현하
			br.close();	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	} 


	//ndm 각각 어레이리스트에 저장하


	private String convert(String group) {
		String month = "0";

		switch(group) {
		case "January" : month = "1";
		case "Feburary" : month = "2";
		case "March" : month = "3";
		case "April" : month = "4";
		case "May" : month = "5";
		case "June" : month = "6";
		}
		return month;
	}

	

}
