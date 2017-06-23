package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import domainlayer.skeleton.ISpel;

public interface ISpelObserver extends Remote {
	/**
	 * Veranderingen van het model doorzetten in de view
	 * @param spel Het model van de view (ISpel)
	 * @throws RemoteException
	 */
	public void modelChanged(ISpel spel) throws RemoteException;
}
