package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.util.ArrayList;
//import java.util.HashMap;

public interface MessageParser {
//	HashMap<String, Integer> map = new HashMap<String, Integer>();
//	ArrayList<String> names = null;
//	ArrayList<String> dates = null;
//	ArrayList<String> messages = null;
	ArrayList<NDMData> ndmData = null;
	

	public void parse(File fileName) ;
}
