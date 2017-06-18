package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;

public interface ITableauView extends Remote {
	public void modelChanged(ITableau tableau) throws RemoteException;
}
