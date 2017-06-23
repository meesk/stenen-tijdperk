package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.spoor.ISpoor;

/**
 * De interface voor de view over de spoor observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ISpoorObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model  Het model dat is veranderd (ISpoor)
	 */
	public void modelChanged(ISpoor model) throws RemoteException;
}
