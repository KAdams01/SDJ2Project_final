package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import client.ClientProxy;
import mediator.ModelManager;
import view.View;

public class Controller {
	private ModelManager modelManager;
	private ClientProxy client;
	private View view;

	public Controller(View view) {
		this.view = view;
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

	public void handleAction(int input) throws RemoteException {
		switch (input) {
		case 1: {
			view.show("Enter Membership Number");
			view.show(payFee(view.getMemberNo()));
			break;
		}
		case 2: {
			view.show("Enter first name");
			String firstName = view.getFirstName();
			view.show("Enter last name");
			String lastName = view.getLastName();
			addMemberToList(firstName, lastName);
			view.show("Member Added.");
			break;
		}
		case 3: {
			for (int i = 0; i < getUnpaidMembers().size(); i++) {
				view.show(getUnpaidMembers().get(i));
			}
			break;
		}
		case 0: {
			save();
			System.exit(0);
		}
		default: {
			view.show("Invalid input");
			break;
		}
		}

	}
}
