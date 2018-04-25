package main;

import java.rmi.RemoteException;

import server.ServerProxy;

public class MainServer {
	public static void main(String[] args) throws RemoteException {
		@SuppressWarnings("unused")
		ServerProxy server = new ServerProxy();
	}
}