package proceslayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import presentationlayer.skeleton.IDobbelsteenWorpPane;

public interface IDobbelsteenWorpController extends Remote {
	public void register(IDobbelsteenWorpPane view) throws RemoteException;
	public void onDobbelsteenWerp() throws RemoteException;
}
