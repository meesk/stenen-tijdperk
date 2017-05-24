package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteen;

public interface IDobbelsteenPane extends Remote {
	public void updateModel(IDobbelsteen model) throws RemoteException;
}
