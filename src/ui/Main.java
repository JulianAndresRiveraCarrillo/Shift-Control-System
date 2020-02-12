package ui;

import java.io.BufferedReader;
import java.util.Scanner;

import exception.InputException;
import model.Control;

public class Main {
	static Control c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
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
				long phone = sc.nextLong();
				sc.nextLine();
				System.out.println("Write the address");
				String address = sc.nextLine();
				try {
					System.out.println(c.addUser(documentType, id, name, lastName, phone, address));
				} catch (InputException e) {
					e.getMessage();
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
