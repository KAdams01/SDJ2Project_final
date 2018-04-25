package view;

import java.rmi.RemoteException;
import java.util.Scanner;

import controller.Controller;

public class View {
	static Scanner keyboard = new Scanner(System.in);
	private Controller controller;

	public View() throws RemoteException {
		controller = new Controller(this);
		while (true) {
			printMainMenu();
			getNextAction();
		}
	}

	public static void printMainMenu() {
		System.out.println("Enter a value based on the following options:");
		System.out.println("1: Pay Fee (requires membership number)");
		System.out.println("2: Add New Member");
		System.out.println("3: Get All members that have not paid membership fee");
		System.out.println("0: Exit and save application");
	}

	public void show(String string) {
		System.out.println(string);
	}

	public void getNextAction() throws RemoteException {
		controller.handleAction(keyboard.nextInt());
	}
	public int getMemberNo() {
		return keyboard.nextInt();
	}
	public String getFirstName() {
		keyboard.nextLine();
		return keyboard.nextLine();
	}
	public String getLastName() {
		return keyboard.nextLine();
	}
}