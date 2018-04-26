package view;

import java.rmi.RemoteException;
import java.util.Scanner;

import controller.Controller;

public class View {
	static Scanner keyboard = new Scanner(System.in);
	private Controller controller;

	public View(Controller controller) throws RemoteException {
		this.controller = controller;
		while (true) {
			printMainMenu();
			handleInput(keyboard.nextInt());
		}
	}

	public void printMainMenu() {
		System.out.println("Enter a value based on the following options:");
		System.out.println("1: Pay Fee (requires membership number)");
		System.out.println("2: Add New Member");
		System.out.println("3: Get All members that have not paid membership fee");
		System.out.println("0: Exit and save application");
	}

	public void handleInput(int input) throws RemoteException {
		switch (input) {
		case 1: {
			System.out.println("Enter Membership Number");
			System.out.println(controller.payFee(keyboard.nextInt()));
			break;
		}
		case 2: {
			System.out.println("Add new Member:");
			keyboard.nextLine();
			System.out.println("Enter first name");
			String firstName = keyboard.nextLine();
			System.out.println("Enter last name");
			String lastName = keyboard.nextLine();
			controller.addMemberToList(firstName, lastName);
			System.out.println("Member Added.");
			break;
		}
		case 3: {
			System.out.println(controller.getUnpaidMembers());
			break;
		}
		case 0: {
			controller.save();
			System.exit(0);
		}
		default: {
			System.out.println("Invalid input.");
			break;
		}
		}
	}
}