package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.spoor.ISpoor;

/**
 * ISpoorObserver.java
 * De interface voor de view over de spoor observer.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public interface ISpoorObserver extends Remote {
	public void modelChanged(ISpoor model) throws RemoteException;
}
