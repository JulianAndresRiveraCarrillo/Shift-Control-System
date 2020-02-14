package model;

import java.util.ArrayList;

import exception.InputException;
import exception.TurnNotFound;
import exception.UserNotFoundException;

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
	/*public char[] createArray() {
		char[] s = new char[25];
		for ( int i=0; i<25; i++) {
			s[i] = (char) ('A' + i );
		}
		return s;
	}*/
	
	public String addUser(String documentType, String id, String name, String lastName, long phone, String address) throws InputException{
		String msg = "";
		User u = new User(documentType, id, name, lastName, phone, address);
		if (documentType.equals("")) {
			throw new InputException(1);
		}if (id.equals("")) {
			throw new InputException(2);
		}else if (name.equals("")) {
			throw new InputException(3);
		}else if (lastName.equals("")) {
			throw new InputException(4);
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
	
	public User searchUser(String id)  {
		User u = null;
		boolean found = true;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) != null) {
				if (users.get(i).getId().equals(id)){
					u = users.get(i);
					found = false;
				}
			}
		}
		return u;
	}
	
	public String addTurn(String id) throws UserNotFoundException {
		char letters = 'A';
		boolean added = false;
		String msg = "";
		User u = searchUser(id);
		if (u != null) {
			for (int i = 0; i < u.getTurn().length && !added; i++) {
				if (u.turn[i] != null && u.turn[i].getStatus() == false) {
					msg += "the user " + u.getName() + " " + u.getLastName() + " has the turn " +u.turn[i] + " unanttended\n";
				}else {
					if (num() > 99) {
						letters++;
						if (letters == 'Z') {
							letters = 'A';
						}
					}
					Turn t = new Turn(num(), letters);
					u.turn[i] = t;
					turns.add(t);
					added = true;
					msg += "the turn " + u.turn[i].toString() + " has been assigned to " + u.getName() + " " + u.getLastName() + "\n";
				}
			}
			msg = "you don't can generate more turns today for " + u.getName() + " " + u.getLastName();
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
		int n = 0;
		if (turn() != null && (turn().getNum()+1) <= 99) {
			n = turn().getNum() + 1;
		}
		return n;
	}
	
	public String showTurns() {
		String turn = "";
		int i = 0;
		while(i < turns.size()) {
			if (turns.get(i).getStatus() == false) {
				turn += turns.get(i).toString();
			}
			i++;
		}
		return turn;
	}
	
	public void setStatus(char l, int n,String action) throws TurnNotFound {
		for (int i = 0; i < turns.size(); i++) {
			if (l == '0'&& n == 0) {
				throw new TurnNotFound();
			}else if(Character.toUpperCase(l) == turns.get(i).getLetter() && n == turns.get(i).getNum()){
				if (action.equalsIgnoreCase("SI") || action.equalsIgnoreCase("YES")) {
					turns.get(i).setStatus(true);
				}
			}
		}
	}

}
