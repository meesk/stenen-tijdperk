package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;


/**
 * De interface voor de view over de tableau observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ITableauObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model Het model van de view (ITableau)
	 */
	public void modelChanged(ITableau model) throws RemoteException;
}
