package model;

import java.util.ArrayList;

public class User {

	//constants 
	public final static String ID = "CC";
	public final static String FOREIGNERID = "CE";
	public final static String PASSPORT = "PA";
	public final static String IDENTITY = "TI";
	
	//atributes
	private String documentType;
	private int id;
	private String name;
	private String lastName;
	private int phone;
	private String address;
	
	//relations
	public ArrayList<Turn>turns;
	
	//constructor
	public User(String documentType, int id, String name, String lastName, int phone, String address) {
		this.documentType = documentType;
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		turns = new ArrayList<Turn>();
	}
	
	//getters and setters
	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
