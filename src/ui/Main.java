package ui;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		System.err.println("Welcome...");
		do {
			System.out.println("1. Add a user");
			System.out.println("2. Search a user");
			System.out.println("3. Generate a turn");
			System.out.println("4. Take a turn");
			System.out.println("0. Exit");
			int op = sc.nextInt();
			
			switch (op) {
			case 1:
				System.out.println();
				break;

			default:
				System.out.println("Good Bye...");
				exit = true;
				break;
			}
		} while (!exit);
		
	}

}
