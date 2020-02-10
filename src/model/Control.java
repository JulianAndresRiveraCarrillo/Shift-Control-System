package model;

import java.util.ArrayList;

import com.sun.javafx.runtime.eula.Eula;

public class Control {

	//relations
	private ArrayList<User>users;
	private ArrayList<Turn>turns;
	//private char[] leters = {'A','B','C','D'};
	
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
	
	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}
	
	//methods 
	public char[] createArray() {
		char[] s = new char[26];
		for ( int i=0; i<26; i++) {
			s[i] = (char) ('A' + i );
		}
		return s;
	}
	
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
			if (searchUser(id) != null) {
				msg = "The user is already created";
			}else {
				users.add(u);
				msg = "The user has been created";
			}
		}
		return msg;
	}
	
	public User searchUser(String id) {
		User u = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) != null) {
				if (users.get(i).getId().equals(id)){
					u = users.get(i);
				}
			}
		}
		return u;
	}
	
	public String addTurn(String id) {
		char[] letters = createArray();
		int l = 0;
		String msg = "";
		User u = searchUser(id);
		if (u != null) {
			for (int i = 0; i < u.getTurn().length; i++) {
				if (u.turn[i] != null && u.turn[i].getStatus() == false) {
					msg = "the user " + u.getName() + " " + u.getLastName() + " has the turn " +u.turn[i] + " unanttended";
				}else {
					if (num() > 99) {
						l++;
					}
					u.turn[i] = new Turn(num(), letters[l]);
					msg = "the turn " + u.turn[i].toString() + " has been assigned to " + u.getName() + " " + u.getLastName();
				}
			}
		}else {
			msg = "Please, create the user and try again";
		}
		return msg;
	}
	
	public Turn turn() {
		Turn t = null;
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i) != null) {
				t = turns.get(i);
			}
		}
		return t;
	}
	
	public int num() {
		int n = 00;
		if (turn() != null && (turn().getNum() +1) <= 99) {
			n = turn().getNum() +1;
		}
		return n;
	}

}
