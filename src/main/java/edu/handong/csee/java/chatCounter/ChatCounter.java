package edu.handong.csee.java.chatCounter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.IOException;
import java.util.*;

/**
 * This class is for main method to run. 
 * First, reads an input path and divides fileNames. 
 * Second, there are two types of file 'txt' and 'csv', so it gonna treat each properly.
 * Third, saves all data into hash map with redundancy check and merge both of them 
 * Fourth, reads that hash map and counts all arraylists amount per person
 * Finally, sort and write csv file with fourth step's output
 * @author heeseok
 *
 */
public class ChatCounter {
	static ChatCounter chCounter = new ChatCounter();

	HashMap<String, ArrayList<NDMData>> messages = new HashMap<String, ArrayList<NDMData>>();
	HashMap<String, Integer> finalOutput = new HashMap<String, Integer>();
	String input;
	String output;
	int numThreads;
	boolean help;

	/**
	 * this method is main method to run.
	 */
	public static void main(String[] args) {
//		openPath = args[1];
//		savePath = args[3];
//		threadAmounts = Integer.parseInt(args[5]);
		//chCounter.run("/Users/heeseok/Documents/한동대/수업/2-1학기/자바 프로그래밍/카카오톡 채팅파일");
		chCounter.doJob(args);
	}

	private void doJob(String[] args) {
		FileLoader fl = new FileLoader();
		Message msg = new Message();
		FileWriter fw = new FileWriter();

		//APACHE COMMONS CLI
		Options options = createOptions();
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + input + "\" as the value of the option i");

			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + output + "\" as the value of the option o");
		}

		try {
//			msg.setMessages(fl.readDirectory(openPath));
			msg.setMessages(fl.readDirectory(input), numThreads);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		messages = msg.getAllMessages();
		if(messages.size() == 0)
			try {
				throw new MessageZeroException("Please Input correct Path!");
			} catch (MessageZeroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//test
		//		for(NDMData data : messages.get("남재창")) {
		//			System.out.println(data.getDate());
		//			System.out.println(data.getMessage());
		//		}

		//실행파트 
		PMCounter pmc = new PMCounter();

		finalOutput = pmc.computePM(messages);

//		fw.writeCSV(savePath, finalOutput);
		fw.writeCSV(output, finalOutput);

	}


	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			numThreads = Integer.parseInt(cmd.getOptionValue("c"));
			input = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();
		

		// add options by using OptionBuilder
		options.addOption(Option.builder("c").longOpt("thread")
				.desc("Set amounts of using threads")
				.hasArg()
				.argName("Thread Numbers")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set a directory path that contains input files")
				.hasArg()
				.argName("Directory Path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a directory path that output file are saved")
				.hasArg()
				.argName("Directory Path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Counting messages of CacaoTalk per person program";
		String footer ="\nPlease report issues at dldydldy@naver.com";
		formatter.printHelp("CountMessages", header, options, footer, true);
	}

}
