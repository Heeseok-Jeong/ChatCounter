package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.util.HashMap;

public interface MessageParser {
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public void parse(File fileName) ;
}
