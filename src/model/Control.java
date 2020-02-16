package model;
/**
 * Control.java
 * 
 * This is the principal class of the project
 * 
 * @author julian andres rivera
 */
import java.util.ArrayList;

import exception.InputException;
import exception.TurnNotFound;
import exception.UserNotFoundException;

public class Control {

	/**
	 * These are the relations of the principal class with the model.<br>
	 */
	private ArrayList<User>users;
	private ArrayList<Turn>turns;
	
	/**
	 * This is the constructor of the class.<br>
	 * The arraylist of users and turns are initialized.<br>
	 */
	public Control() {
		users = new ArrayList<User>();
		turns = new ArrayList<Turn>();
	}

	/**
	 * this method receives the user arraylist.<br> 
	 * @return the value of arraylist of users.<br>
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * this method receives the arraylist of turns.<br>
	 * @return the value of the arralisst of turns.<br>
	 */
	public ArrayList<Turn> getTurns() {
		return turns;
	}

	/**
	 * this method adds a user to the system.<br>
	 * @param documentType receive the document type of the user.<br>
	 * @param id receive the id number of user.<br>
	 * @param name receive the name of user.<br>
	 * @param lastName receive the last name of the user.<br>
	 * @param phone receive the phone number of the user.<br>
	 * @param address receive the address of the user's house.<br>
	 * @return a message informing, if the user was added or not.<br>
	 * @throws InputException if the document type, id, name or last name are not entered.<br>
	 */
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
	
	/**
	 * This method searches for a user to know if it exists or not.<br>
	 * @param id receive the id number of the user to search.<br>
	 * @return null if the user doesn't exist in the system or the user with the same id entered.<br>
	 */
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
	/**
	 * this method adds a turn to the system and to a specific user.<br>
	 * @param id receive the id number of the user to be assigned the turn.<br>
	 * @return a message if the user has a turn that it is not attended, if you  can´t added more turns or the user doesn´t exist.<br> 
	 * @throws UserNotFoundException it is throws if the user doesn't exist.<br>
	 */
	public String addTurn(String id) throws UserNotFoundException {
		char letters = 'A';
		boolean added = false;
		String msg = "";
		User u = searchUser(id);
		if (u != null) {
			for (int i = 0; i < u.getTurn().length && !added; i++) {
				if (u.turn[i] != null && u.turn[i].getStatus() == false) {
					msg += "the user " + u.getName() + " " + u.getLastName() + " has the turn " +u.turn[i] + " unanttended\n";
					added = true;
				}else if (i == u.turn.length -1 && u.turn[i] != null){
					msg = "you don't can generate more turns today for " + u.getName() + " " + u.getLastName();
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
			
		}else {
			throw new UserNotFoundException();
		}
		return msg;
	}
	
	/**
	 * this method search a turn for to generate a consecutive turn.<br>
	 * @return the last existing turn.<br>
	 */
	public Turn turn() {
		Turn t = null;
		for (int i = 0; i < turns.size(); i++) {
			if (turns.get(i) != null) {
				t = turns.get(i);
			}
		}
		return t;
	}
	
	/**
	 * This method allows the number of each turn to be made consecutive.<br>
	 * @return the number that remains on the waiting list.<br>
	 */
	public int num() {
		int n = 0;
		if (turn() != null && (turn().getNum()+1) <= 99) {
			n = turn().getNum() + 1;
		}
		return n;
	}
	
	/**
	 * This method shows in console the turns that have not yet been attended.<br>
	 * @return each of the unattended turns.<br>
	 */
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
	
	/**
	 * This method allows you to change the status of a turn that is displayed on the screen when it is attended.<br>
	 * @param l is the letter o f the turn.<br>
	 * @param n is the number of the turn.<br>
	 * @param action receive if the turn was attended or not.<br>
	 * @throws TurnNotFound if the turn doesn't exist.<br>
	 */
	public String setStatus(char l, int n,String action) throws TurnNotFound {
		String msg = "";
		for (int i = 0; i < turns.size(); i++) {
			if (l == '0'&& n == 0) {
				throw new TurnNotFound();
			}else if(Character.toUpperCase(l) == turns.get(i).getLetter() && n == turns.get(i).getNum()){
				if (action.equalsIgnoreCase("SI") || action.equalsIgnoreCase("YES")) {
					turns.get(i).setStatus(true);
					msg = "the " + turns.get(i).toString() + " had been attended";
				}
			}
		}
		return msg;
	}

}
