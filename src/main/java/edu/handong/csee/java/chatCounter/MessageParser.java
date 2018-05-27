package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.util.ArrayList;
//import java.util.HashMap;

public interface MessageParser {
	ArrayList<NDMData> ndmData = new ArrayList<NDMData>();

	public void parse(File fileName) ;
}
