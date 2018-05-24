package edu.handong.csee.java.chatCounter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ChatCounter {
	static ChatCounter chCounter = new ChatCounter();
	static String openPath = new String();
	static String savePath = new String();
	
	String input;
	String output;
	boolean help;

	
	public static void main(String[] args) {
		openPath = args[1];
		savePath = args[3];
		//chCounter.run("/Users/heeseok/Documents/한동대/수업/2-1학기/자바 프로그래밍/카카오톡 채팅파일");
		chCounter.run(openPath, savePath, args);
	}

	private void run(String openPath, String savePath, String[] args) {
		FileLoader fl = new FileLoader();
		Message msg = new Message();
//		MessageParser msgp = new MessageParser();
//		ParserForMac pfm = new ParserForMac();
//		ParserForWindows pfw = new ParserForWindows();
//		RedundancyChecker rc = new RedundancyChecker();
//		PMCounter pmc = new PMCounter();
//		FileWriter fw = new FileWriter();
		
		msg.setMessages(fl.readDirectory(openPath));
		
		msgp.parse(msg.getMessages());
		
		fw.writeCSV(savePath);
		
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
//			if(verbose) {
//				
//				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
//			}
		}
		
	}
	

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

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
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set a directory path that contains input files")
				.hasArg()
				.argName("Directory Path")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a directory path that contains output files")
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
