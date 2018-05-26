package edu.handong.csee.java.chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ParserForWindows implements MessageParser{
	ArrayList<String> names = null;
	ArrayList<String> dates = null;
	ArrayList<String> messages = null;
	
	@Override
	public void parse(File fileName) { 
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
