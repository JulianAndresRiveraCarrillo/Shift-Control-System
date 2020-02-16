package ui;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import exception.InputException;
import exception.TurnNotFound;
import exception.UserNotFoundException;
import model.Control;

public class Main {
	static Control c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		c = new Control();
		System.out.println("--------------------------------");
		System.out.println("            Welcome...");
		System.out.println("--------------------------------");
		do {
			System.out.println("1. Add a user");
			System.out.println("2. Search a user");
			System.out.println("3. Generate a turn");
			System.out.println("4. Take a turn");
			System.out.println("0. Exit");
			int op = sc.nextInt();
			
			switch (op) {
			case 1:
				sc.nextLine();
				System.out.println("Write the document type:\n" + "Identification Card: CC\n" + "Foreigner ID: CE\n" + "Passport: PA\n" + "Identity: TI");
				String documentType = sc.nextLine();
				System.out.println("Write the id number");
				String id = sc.nextLine();
				System.out.println("Write the name");
				String name = sc.nextLine();
				System.out.println("Write the lastName");
				String lastName = sc.nextLine();
				System.out.println("Write the phone number");
				try {	
					long phone = sc.nextLong();
					sc.nextLine();
					System.out.println("Write the address");
					String address = sc.nextLine();
					System.out.println(c.addUser(documentType, id, name, lastName, phone, address));
				} catch (InputException e) {
					e.getMessage();
				}catch (InputMismatchException ex) {
					System.err.println("you wrote a invalid phone");
					sc.next();
				}
				break;

			case 2:
				sc.nextLine();
				System.out.println("Write the id of the user for search");
				String user = sc.nextLine();
				try {
					System.out.println(c.searchUser(user).toString());	
				} catch (Exception e) {
					System.err.println("User doesn't exist. Please add him/her");
				}
				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Write the id of the user");
				String u = sc.nextLine();
				try {
					System.out.println(c.addTurn(u));
				} catch (UserNotFoundException e) {
					e.getMsg();
				}
				break;
				
			case 4:
				sc.nextLine();
				System.out.println("The turns are as follows:\n" + c.showTurns());
				System.out.println("Please, write a '-' between the letter and number of the turn\n" + "*if no turns appear. Write 0-0*");
				String input = sc.nextLine();
				String []shift = input.split("-");
				char l = shift[0].charAt(0);
				int n = Integer.parseInt(shift[1]);
				System.out.println("If You attended a this turn write 'YES'. If you didn't do it, Write 'NO'");
				String action = sc.nextLine();
				try {
					System.out.println(c.setStatus(l, n, action));
				} catch (TurnNotFound e) {
					System.out.println(e.msg());
				}
				break;
			default:
				System.out.println("Good Bye...");
				exit = true;
				break;
			}
		} while (!exit);
		
	}

}
