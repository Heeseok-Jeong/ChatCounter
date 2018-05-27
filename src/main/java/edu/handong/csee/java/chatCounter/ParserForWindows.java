package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserForWindows implements MessageParser{
	ArrayList<String> names = null;
	ArrayList<String> dates = null;
	ArrayList<String> messages = null;
	String name, message, temp;
	int year, month, day, hour, min;
	
	@Override
	public void parse(File fileName) { 
		boolean bool = true;
		BufferedReader br = null;
		try {
			br = new BufferedReader(
			          new InputStreamReader(
			                       new FileInputStream(fileName), "UTF8"));
		} catch (UnsupportedEncodingException e) {				
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//분류하
		String pattern1 = "\\[(.+)\\]\\s\\[(.+)\\s(\\d+):(\\d+)\\]\\s(.+)";
		Pattern p1 = Pattern.compile(pattern1);
		String pattern2 = "-+\\s(\\d+).\\s(\\d).\\s(\\d+).\\s.+\\s-+";
		Pattern p2 = Pattern.compile(pattern2);
		
		try {
			for(temp = br.readLine(); temp != null;) {
				Matcher match1 = p1.matcher(temp);
				Matcher match2 = p2.matcher(temp);
				if(match2.find()) {
					year = Integer.parseInt(match2.group(1));
					month = Integer.parseInt(match2.group(2));
					day = Integer.parseInt(match2.group(3));
				}
				
				if(match1.find()) {
					name = match1.group(1);
					message = match1.group(5);
					hour = Integer.parseInt(match1.group(3));					
					min = Integer.parseInt(match1.group(4));
				
					String check = "year+\"-\"+month+\"-\"+day+\" \"+hour+\":\"+min+\" \"+name+\" \"+message";
					
					if(match1.group(2).contains("오후") && hour != 12) {
						 hour = Integer.parseInt(match1.group(3)) + 12;
					 }
					 if(match1.group(2).contains("오전") && hour == 12) {
						 hour = 0;
					 }
					 
					 if(message.equals("사진")) {
						 message = "Photo";
					 }
					
					if(messages.contains(check)) {
						messages.add(check);
						bool = true;
					}
					if(bool) {
						names.add(name);						
						bool = false;
					}
					
				}
				br.close();	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ndm 각각 어레이리스트에 저장하
		
		
	    try {
			br.close();
		} catch (IOException e) {				
			e.printStackTrace();
		}	
		
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public ArrayList<String> getDates() {
		return dates;
	}

	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}

}
