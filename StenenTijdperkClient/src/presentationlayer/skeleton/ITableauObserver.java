package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;

/**
 * ITableauObserver.java<br>
 * De interface voor de view over de tableau observer.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public interface ITableauObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model Het model van de view (ITableau)
	 * @throws RemoteException
	 */
	public void modelChanged(ITableau model) throws RemoteException;
}
