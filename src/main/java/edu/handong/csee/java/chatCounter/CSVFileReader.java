package edu.handong.csee.java.chatCounter;

import java.io.*;

public class CSVFileReader implements Runnable {
	File file;
	
	public CSVFileReader(File file) {
		this.file = file;
	}
	
	@Override
	public void run() {
		Thread csvFileReader = new Thread(new CSVFileReader(file));
	}

}
