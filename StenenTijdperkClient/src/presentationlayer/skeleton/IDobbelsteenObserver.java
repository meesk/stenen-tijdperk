package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteen;

/**
 * De interface voor de dobbelsteen observer.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface IDobbelsteenObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model  Het model van de dobbelsteen
	 */
	public void modelChanged(IDobbelsteen model) throws RemoteException;
}
