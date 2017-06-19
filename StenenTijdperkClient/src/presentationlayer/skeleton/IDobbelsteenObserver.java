package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteen;

/**
 * IDobbelsteenObserver.java<br>
 * De interface voor de dobbelsteen observer.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public interface IDobbelsteenObserver extends Remote {
	public void modelChanged(IDobbelsteen model) throws RemoteException;
}
