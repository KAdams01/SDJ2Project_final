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
		int temp = keyboard.nextInt();
		keyboard.nextLine();
		controller.handleAction(temp);
	}
	public int getMemberNo() {
		int temp = keyboard.nextInt();
		return temp;
	}
	public String getStringInput() {
		String temp = keyboard.nextLine();
		return temp;
	}
}