package client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import mediator.ModelManager;
import server.RemoteInterface;

public class ClientProxy {
	private static RemoteInterface remote;
	private ModelManager modelManager;
	
	public ClientProxy() {
		try {
			
			remote = (RemoteInterface) Naming.lookup("rmi://localhost:1099/ModelManager");
			modelManager = remote.getModelManager();
			System.out.println("Connected to Server.");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ModelManager getModelManager() {
		return this.modelManager;
	}
	public void save() throws RemoteException {
		remote.saveModelManager(this.modelManager);
	}


}
