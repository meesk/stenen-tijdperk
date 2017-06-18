package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteen;

/**
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public interface IDobbelsteenObserver extends Remote {
	public void modelChanged(IDobbelsteen model) throws RemoteException;
}
