package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface MessageParser {
	HashMap<String, ArrayList<NDMData>> map = new HashMap<String, ArrayList<NDMData>>();
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();
	String user = new String();
	
	public void parse(File fileName) ;
}
