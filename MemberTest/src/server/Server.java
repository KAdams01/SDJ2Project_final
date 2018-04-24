package server;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import adaptor.FileIO;
import mediator.ModelManager;

public class Server extends UnicastRemoteObject implements Serializable, RemoteInterface {
	private ModelManager modelManager;
	private FileIO file = new FileIO();

	public Server() throws RemoteException {
		modelManager = load();
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
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

	public void save(ModelManager modelManager) {
		file.setModel(modelManager);
	}

	public ModelManager load() {
		if (file.getModel() == null) {
			save(new ModelManager());
			return file.getModel();
		} else {
			return file.getModel();
		}
	}

}
