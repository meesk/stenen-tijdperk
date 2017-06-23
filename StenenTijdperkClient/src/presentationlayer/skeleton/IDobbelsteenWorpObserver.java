package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

/**
 * De interface voor de view over de dobbelsteenworp observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface IDobbelsteenWorpObserver extends Remote {
	
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model  Het model dat veranderd is (IDobbelsteenWorp)
	 */
	public void modelChanged(IDobbelsteenWorp model) throws RemoteException;
}
