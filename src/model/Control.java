package model;

import java.util.ArrayList;

public class Control {

	//relations
	private ArrayList<User>users;
	
	//constructor
	public Control() {
		users = new ArrayList<User>();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
}
