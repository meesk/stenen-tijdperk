package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;

/**
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public interface ITableauObserver extends Remote {
	public void modelChanged(ITableau model) throws RemoteException;
}
