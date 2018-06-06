package edu.handong.csee.java.chatCounter;

/**
 * This class is my own Exception class. It'll checks about if there are files to read.
 * @author heeseok
 */
public class MessageZeroException extends Exception{
	/**
	 * default constructor of MessageZeroException
	 */
	public MessageZeroException() {
		super("edu.handong.csee.java.chatCounter.MessageZeroException occured!");
	}

	/**
	 * With String parameter constructor of MessageZeroException
	 */
	public MessageZeroException (String message)
	{
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
