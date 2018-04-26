package main;

import java.rmi.RemoteException;

import controller.Controller;
import view.View;

public class MainClient {
	public static void main(String[] args) throws RemoteException {
		@SuppressWarnings("unused")
		View view = new View(new Controller());
	}
}