package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import presentationlayer.skeleton.ITableauView;

/**
 * ITableau.java
 * Een interface voor het tableau aan de server kant.
 *
 * @author Erwin Olie, s1103026
 * @version 0.2
 */

public interface ITableau extends Remote {
	public void registerObserver(ITableauView observer) throws RemoteException;

	public int[] getGereedschap() throws RemoteException;
	public boolean[] getGereedschapGebruikt() throws RemoteException;
}

