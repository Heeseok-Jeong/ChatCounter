package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class reads and parses all files with two different type logics and makes final HashMap
 * @author heeseok
 *
 */
public class Message implements Runnable{
//	private static ArrayList<File> fileNames;
//	private static void setFileNames(ArrayList<File> fileNames) {
//		Message.fileNames = fileNames;
//	}
//
//	private static ArrayList<File> getFileNames() {
//		return fileNames;
//	}
	private File fileName;

	public Message(File fileName) {
		this.fileName = fileName;
	}
	
	public Message() {};

	static private HashMap<String, ArrayList<NDMData>> allMessages = new HashMap<String, ArrayList<NDMData>>();
	private HashMap<String, ArrayList<NDMData>> newMessages = new HashMap<String, ArrayList<NDMData>>();
	
	/**
	 * getter of allMessages
	 */
	public HashMap<String, ArrayList<NDMData>> getAllMessages() {
		return allMessages;
	}

	/**
	 * setter of allMessages
	 */
	public void setAllMessages(HashMap<String, ArrayList<NDMData>> allMessages) {
		this.allMessages = allMessages;
	}

	/**
	 * it reads txt files and csv files and properly puts data into allMessages
	 * @param threads 
	 */
	public void setMessages(ArrayList<File> fileNames, int numThreads) throws IOException {
//		setFileNames(fileNames);
		//쓰레드 
		
		Thread[] threads = new Thread[numThreads];
		
//		for(File fileName : fileNames) {
//			for(int i=0; i<numThreads; i++) {
//				threads[i] = new Thread(new Message(fileName));
//				threads[i].start();
//			}
//		}
		int j;
		for(j = 0; j < fileNames.size();) {
			for(int i=0; i<numThreads; i++) {
				fileName = fileNames.get(j++);
				if(j == fileNames.size()) break;
				threads[i] = new Thread(new Message(fileName));
				threads[i].start();
			}
			for(Thread thread:threads) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		RedundancyChecker rc = new RedundancyChecker();
		newMessages = rc.checkRedundancy(allMessages);
		
		
	}

	//문제점 - 런 할 때 파일 하나만 읽어야하는데 어레이리스트로 다 읽어서 문제다.
	@Override
	public void run() {
		ParserForMac macParser = new ParserForMac();
		ParserForWindows winParser = new ParserForWindows();
		//		getFileNames();

		if(fileName.getName().contains(".csv") || fileName.getName().contains(".txt")) {
			if(fileName.getName().contains(".txt")){
				winParser.parse(fileName); 
				allMessages.putAll(winParser.getMap());
			}

			//macParser.setMap(allMessages);

			if(fileName.getName().contains(".csv")) {
				macParser.parse(fileName);
				allMessages.putAll(macParser.getMap());
			}
		}
	}
}
		
		
		//작업 
//		for(File fileName:fileNames) {
//			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
//				continue;
//			}
//			if(fileName.getName().contains(".txt")){
//				winParser.parse(fileName); 
//				allMessages.putAll(winParser.getMap());
//			}
//		}
//		macParser.setMap(allMessages);
//		for(File fileName : fileNames) {
//			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
//				continue;
//			}
//			if(fileName.getName().contains(".csv")) {
//				macParser.parse(fileName);
//				allMessages.putAll(macParser.getMap());
//			}
//		}
		//		allMessages.putAll(csvMessages);
		//		allMessages.putAll(txtMessages);
		//		allMessages = Stream.of(csvMessages, txtMessages).flatMap(m -> m.entrySet().stream())
		//			       .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

	

//		for(File fileName:fileNames) {
//			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
//				continue;
//			}
//			if(fileName.getName().contains(".txt")){
//				winParser.parse(fileName); 
//				allMessages.putAll(winParser.getMap());
//			}
//		}
//		macParser.setMap(allMessages);
//		for(File fileName : fileNames) {
//			if(!(fileName.getName().contains(".csv") || fileName.getName().contains(".txt"))) {
//				continue;
//			}
//			if(fileName.getName().contains(".csv")) {
//				macParser.parse(fileName);
//				allMessages.putAll(macParser.getMap());
//			}
//		}


