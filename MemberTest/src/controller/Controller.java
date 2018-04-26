package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ClientProxy;
import mediator.ModelManager;

public class Controller {
	private ModelManager modelManager;
	private ClientProxy client;

	public Controller() {
		client = new ClientProxy();
		modelManager = client.getModelManager();
	}

	public String payFee(int memberID) {
		modelManager.payFee(memberID);
		return modelManager.sendReturnMessage();
	}

	public void addMemberToList(String firstName, String lastName) {
		modelManager.addMemberToList(firstName, lastName);
	}

	public ArrayList<String> getUnpaidMembers() {
		return modelManager.getUnpaidMembers();
	}

	public void save() throws RemoteException {
		client.save();
	}
}
