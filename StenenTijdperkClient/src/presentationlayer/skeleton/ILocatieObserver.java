package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.locaties.ILocatie;

public interface ILocatieObserver extends Remote {
	public void modelChanged(ILocatie model) throws RemoteException;
}
