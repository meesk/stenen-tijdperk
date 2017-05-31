package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import proceslayer.skeleton.IDobbelsteenWorpController;

public interface ISpel extends Remote {
	public IDobbelsteenWorpController getDobbelsteenWorpController() throws RemoteException;
}
