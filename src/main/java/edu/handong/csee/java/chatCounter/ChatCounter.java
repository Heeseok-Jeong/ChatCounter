package edu.handong.csee.java.chatCounter;

public class ChatCounter {
	static ChatCounter chCounter = new ChatCounter();
	static String openPath = new String();
	static String savePath = new String();
	
	public static void main(String[] args) {
		openPath = args[1];
		savePath = args[3];
		chCounter.run(openPath);
	}

	private void run(String openPath) {
		FileLoader fl = new FileLoader();
		Message msg = new Message();
		ParserForMac pfm = new ParserForMac();
		ParserForWindows pfw = new ParserForWindows();
		RedundancyChecker rc = new RedundancyChecker();
		PMCounter pmc = new PMCounter();
		FileWriter fw = new FileWriter();
		
		msg.getMessages(fl.readDirectory(openPath));
		msg.getMessages();
		
	}

}
