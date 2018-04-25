package main;

import java.rmi.RemoteException;

import controller.Controller;
import view.View;

public class MainClient {
	public static void main(String[] args) throws RemoteException {
		Controller controller = new Controller();
		View view = new View(controller);

	}
}
