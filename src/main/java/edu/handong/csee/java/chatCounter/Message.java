package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class reads and parses all files with two different type logics and makes final HashMap
 * @author heeseok
 *
 */
public class Message{
//	private static ArrayList<File> fileNames;
//	private static void setFileNames(ArrayList<File> fileNames) {
//		Message.fileNames = fileNames;
//	}
//
//	private static ArrayList<File> getFileNames() {
//		return fileNames;
//	}
	
	public Message() {};

	private HashMap<String, ArrayList<NDMData>> fileMessages = new HashMap<String, ArrayList<NDMData>>();
	private HashMap<String, ArrayList<NDMData>> newMessages = new HashMap<String, ArrayList<NDMData>>();
	
	public HashMap<String, ArrayList<NDMData>> getNewMessages() {
		return newMessages;
	}

	/**
	 * getter of fileMessages
	 */
	public HashMap<String, ArrayList<NDMData>> getFileMessages() {
		return fileMessages;
	}

	/**
	 * setter of fileMessages
	 */
	public void setAllMessages(HashMap<String, ArrayList<NDMData>> fileMessages) {
		this.fileMessages = fileMessages;
	}

	/**
	 * it reads txt files and csv files and properly puts data into allMessages
	 * @param threads 
	 */
	public void setMessages(ArrayList<File> fileNames, int numThreads) throws IOException {
//		setFileNames(fileNames);
		//쓰레드 
		
//		Thread[] threads = new Thread[numThreads];
		
//		for(File fileName : fileNames) {
//			for(int i=0; i<numThreads; i++) {
//				threads[i] = new Thread(new Message(fileName));
//				threads[i].start();
//			}
//		}
		
		ArrayList<ParserForMac> pfmRunners = new ArrayList<ParserForMac>();
		ArrayList<ParserForWindows> pfwRunners = new ArrayList<ParserForWindows>();

		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		
		for(File fileName : fileNames) {
			if(fileName.getName().contains(".csv") || fileName.getName().contains(".txt")) {
				if(fileName.getName().contains(".csv")) {
					Runnable worker = new ParserForMac(fileName);
					executor.execute(worker);
					pfmRunners.add((ParserForMac)worker);
				}
				if(fileName.getName().contains(".txt")){
					Runnable worker = new ParserForWindows(fileName);
					executor.execute(worker);
					pfwRunners.add((ParserForWindows)worker);
				}
			}
		}
		
		executor.shutdown(); // no new tasks will be accepted.
		
		while (!executor.isTerminated()) {
        }

		for(ParserForMac runner:pfmRunners) {
			fileMessages.putAll(runner.getMap());
		}
		for(ParserForWindows runner:pfwRunners) {
			fileMessages.putAll(runner.getMap());
		}
		
		
//		for(j = 0; j < fileNames.size();) {
//			for(int i=0; i<numThreads; i++) {
//				fileName = fileNames.get(j++);
//				if(j == fileNames.size()) break;
//				threads[i] = new Thread(new Message(fileName));
//				threads[i].start();
//			}
//			for(Thread thread:threads) {
//				try {
//					thread.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		RedundancyRemover rr = new RedundancyRemover();
		newMessages.putAll(rr.removeRedundancy(getFileMessages()));
	}		
}
//문제점 : 쓰레드 돌리고 나온 allMessages가 왜 메인쓰레드에선 텅비었을
//	@Override
//	public void run() {
//		ParserForMac macParser = new ParserForMac();
//		ParserForWindows winParser = new ParserForWindows();
//		//		getFileNames();
//
//		if(fileName.getName().contains(".csv") || fileName.getName().contains(".txt")) {
//			if(fileName.getName().contains(".txt")){
//				winParser.parse(fileName); 
//				allMessages.putAll(winParser.getMap());
//			}
//			//macParser.setMap(allMessages);
//			if(fileName.getName().contains(".csv")) {
//				macParser.parse(fileName);
//				allMessages.putAll(macParser.getMap());
//			}
//		}
//		
//	}
//}
//		
		
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


