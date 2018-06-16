package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class can reads and parses csv files and txt files with two different type logics 
 * and merges into one HashMap with redundancy checking
 * @author heeseok
 *
 */
public class Message{
	private HashMap<String, ArrayList<NDMData>> fileMessages = new HashMap<String, ArrayList<NDMData>>();
	private HashMap<String, ArrayList<NDMData>> newMessages = new HashMap<String, ArrayList<NDMData>>();

	/**
	 * getter of newMessages
	 */
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
	 * it reads txt files and csv files and properly puts data into each instances
	 */
	public void setMessages(ArrayList<File> fileNames, int numThreads) throws IOException {	
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

		RedundancyRemover rr = new RedundancyRemover(pfmRunners, pfwRunners);
		newMessages.putAll(rr.removeRedundancy());
	}		
}
