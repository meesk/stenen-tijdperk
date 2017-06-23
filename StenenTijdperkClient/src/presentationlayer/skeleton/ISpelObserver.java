package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import domainlayer.skeleton.ISpel;

/**
 * De interface voor de view over de spel observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ISpelObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param spel Het model van de view (ISpel)
	 */
	public void modelChanged(ISpel spel) throws RemoteException;
}
