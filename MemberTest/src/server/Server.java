package server;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import adaptor.Adaptor;
import adaptor.FileIO;
import mediator.ModelManager;

public class Server extends UnicastRemoteObject implements Serializable, RemoteInterface {
	private ModelManager modelManager;
	private FileIO file = new FileIO();

	public Server() throws RemoteException {
		modelManager = load(); // needs to get from adaptor, not create new
//		addMembers();
	}

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			Server server = new Server();
			Naming.rebind("ModelManager", server);
			System.out.println("Server Started.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void saveModelManager(ModelManager modelManager) {
		this.modelManager = modelManager;
		save(modelManager);
	}
	public ModelManager getModelManager() {
		return modelManager;
	}
//	public void addMembers() {
//		for(int i = 0; i < 5; i++) {
//		modelManager.addMemberToList("member"+i, "memberL"+i);
//		}
//			System.out.println(modelManager.getUnpaidMembers());
//		}
	public void save(ModelManager modelManager) {
		file.setModel(modelManager);
	}
	public ModelManager load() {
		if (file.getModel() == null) {
			System.out.println("File not found, creating new file");
			save(new ModelManager());
			return file.getModel();
		}
		else
		{
			return file.getModel();
		}
	}
	
}
