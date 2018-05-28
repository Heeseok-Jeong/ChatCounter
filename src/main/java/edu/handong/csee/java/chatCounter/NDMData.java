package edu.handong.csee.java.chatCounter;

/**
 * this class has informations of name, date and message and has getter and setter of all informations.
 * @author heeseok
 *
 */
public class NDMData {
	private String name;
	private String date;
	private String message;
	
	/**
	 * this constructor sets ndm
	 */
	public NDMData(String name, String date, String message) {
		this.name = name;
		this.date = date;
		this.message = message;
	}
	
	/**
	 * this is default type constructor
	 */
	public NDMData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * getter of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter of name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter of date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * setter of date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * getter of message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * setter of message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
