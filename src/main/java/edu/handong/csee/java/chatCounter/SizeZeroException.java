package edu.handong.csee.java.chatCounter;

/**
 * This class is my own Exception class. It checks about size is 0
 * @author heeseok
 *
 */
public class SizeZeroException extends Exception{
	/**
	 * default constructor of SizeZeroException
	 */
	public SizeZeroException() {
		super("edu.handong.csee.java.chatCounter.SizeZeroException occured!");
	}

	/**
	 * With String parameter constructor of SizeZeroException
	 */
	public SizeZeroException (String message)
	{
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
