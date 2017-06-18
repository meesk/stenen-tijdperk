package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

/**
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public interface IDobbelsteenWorpObserver extends Remote {
	public void modelChanged(IDobbelsteenWorp model) throws RemoteException;
}
