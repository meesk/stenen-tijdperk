package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.locaties.ILocatie;

public interface ILocatieObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param model Het model van de view (ILocatie)
	 * @throws RemoteException
	 */
	public void modelChanged(ILocatie model) throws RemoteException;
}
