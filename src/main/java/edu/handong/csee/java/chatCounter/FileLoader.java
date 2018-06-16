package edu.handong.csee.java.chatCounter;

import java.io.File;
import java.util.ArrayList;


/**
 * this class can gets all files from input path.
 * @author heeseok
 *
 */
public class FileLoader {
	public ArrayList<File> readDirectory(String path) {
		//get files from path
		ArrayList<File> fileNames = getFileNames(path);
		return fileNames;
	}

	private ArrayList<File> getFileNames(String path) {
		ArrayList<File> fileNames = new ArrayList<File>();

		//get file names in the directory
		File myPath = new File(path);

		for(File fileName:myPath.listFiles()) {
			fileNames.add(fileName);
		} 

		return fileNames;
	}

}
