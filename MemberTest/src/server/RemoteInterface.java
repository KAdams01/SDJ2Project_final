package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import mediator.ModelManager;

public interface RemoteInterface extends Remote{
	public void saveModelManager(ModelManager modelManager)  throws RemoteException;
	public ModelManager getModelManager() throws RemoteException;

}
