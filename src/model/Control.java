package model;

import java.util.ArrayList;

public class Control {

	//relations
	private ArrayList<User>users;
	private ArrayList<Turn>turns;
	
	//constructor
	public Control() {
		users = new ArrayList<User>();
		turns = new ArrayList<Turn>();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	//methods 
	public String addUser(String documentType, String id, String name, String lastName, int phone, String address) {
		String msg = "";
		User u = new User(documentType, id, name, lastName, phone, address);
		if (documentType == null) {
			msg = "The document Type is obligatory. Please, write it";
		}else if (id == null) {
			msg = "The id is obligatory. Please, write it";
		}else if (name == null) {
			msg = "The name is obligatory. Please, write it";
		}else if (lastName == null) {
			msg = "The lastName is obligatory. Please, write it";
		}else {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i) != null && users.get(i).getId().equals(id)) {
					msg = "The user is already created";
				}else {
					users.add(u);
				}
			}
		}
		return msg;
	}
	
}
