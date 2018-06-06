package edu.handong.csee.java.chatCounter;

/**
 * This class is my own Exception class. It checks about size is 0
 * @author heeseok
 */
public class MessageZeroException extends Exception{
	/**
	 * default constructor of SizeZeroException
	 */
	public MessageZeroException() {
		super("edu.handong.csee.java.chatCounter.MessageZeroException occured!");
	}

	/**
	 * With String parameter constructor of SizeZeroException
	 */
	public MessageZeroException (String message)
	{
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
