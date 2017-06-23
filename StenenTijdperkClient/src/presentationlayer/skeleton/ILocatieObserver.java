package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.locaties.ILocatie;

/**
 * De interface voor de view over de locatie observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ILocatieObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model Het model van de view (ILocatie)
	 */
	public void modelChanged(ILocatie model) throws RemoteException;
}
