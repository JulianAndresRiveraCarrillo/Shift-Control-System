package model;

import java.util.Arrays;

/**
 * this is the User Class.<br>
 * @author julian andres rivera
 *
 */
public class User {

	/**
	 * these are the documents types that a user can have.<br>
	 */
	//constants 
	public final static String ID = "CC";
	public final static String FOREIGNERID = "CE";
	public final static String PASSPORT = "PA";
	public final static String IDENTITY = "TI";
	
	/**
	 * these the attributes of a User.<br>
	 */
	private String documentType;
	private String id;
	private String name;
	private String lastName;
	private long phone;
	private String address;
	
	/**
	 * this is a array of turn.<br>
	 */
	//relations
	public Turn[] turn;
	
	/**
	 * this the constructor method of the class.<br>
	 * @param documentType the document type of a user.<br>
	 * @param id the id number of the user.<br>
	 * @param name the name of the user.<br>
	 * @param lastName the last name of the user.<br>
	 * @param phone the phone number of the user.<br>
	 * @param address the address of the user's house.<br>
	 */
	public User(String documentType, String id, String name, String lastName, long phone, String address) {
		this.documentType = documentType;
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		turn = new Turn[5];
	}
	
	//getters and setters
	/**
	 * this method receive the document type of the user.<br>
	 * @return the document type of the user.<br>
	 */
	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	/**
	 * the method receive the id of the user.<br>
	 * @return the id number of the user.<br>
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * this method receive the name of the user.<br>
	 * @return the name of the user.<br>
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method receive the last name of the user.<br>
	 * @return the last name of the user.<br>
	 */
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * this method receive the phone number of the user.<br>
	 * @return the phone number of the user.<br>
	 */
	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * this method receive the address of the user.<br>
	 * @return the addres of the user.<br>
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * this method receive all turns.<br>
	 * @return the array with the turns.<br>
	 */
	public Turn[] getTurn() {
		return turn;
	}

	/**
	 * this method help to show in the screen the user data.<br>
	 */
	@Override
	public String toString() {
		return "User [documentType=" + documentType + "\nid=" + id + "\nname=" + name + "\nlastName=" + lastName
				+ "\nphone=" + phone + "\naddress=" + address + "\nturn=" + Arrays.toString(turn) + "]";
	}
}
