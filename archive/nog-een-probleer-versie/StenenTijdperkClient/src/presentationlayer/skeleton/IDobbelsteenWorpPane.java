package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

public interface IDobbelsteenWorpPane extends Remote {
	public void updateModel(IDobbelsteenWorp model) throws RemoteException;
}
