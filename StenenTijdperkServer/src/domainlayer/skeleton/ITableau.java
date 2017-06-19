package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import presentationlayer.skeleton.ITableauObserver;

/**
 * @author Erwin Olie, s1103026
 * @version 0.3
 */

public interface ITableau extends Remote {
	public void registerObserver(ITableauObserver observer) throws RemoteException;

	public int[] getGereedschap() throws RemoteException;
	public boolean[] getGereedschapGebruikt() throws RemoteException;
}

