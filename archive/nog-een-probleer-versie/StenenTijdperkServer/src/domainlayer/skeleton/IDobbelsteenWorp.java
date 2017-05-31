package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDobbelsteenWorp extends Remote {
	public void werp(int aantal) throws RemoteException;
	public IDobbelsteen[] getDobbelstenen() throws RemoteException;
}
