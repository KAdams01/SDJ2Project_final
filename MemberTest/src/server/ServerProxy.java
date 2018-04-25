package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import adaptor.FileIO;
import mediator.ModelManager;

@SuppressWarnings("serial")
public class ServerProxy extends UnicastRemoteObject implements RemoteInterface {
	private ModelManager modelManager;
	private FileIO file = new FileIO();

	public ServerProxy() throws RemoteException {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("ModelManager", this);
			System.out.println("Server Started.");
			modelManager = load();
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
