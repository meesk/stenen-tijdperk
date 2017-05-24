package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDobbelsteen extends Remote {
	public void reset() throws RemoteException;
	public void werp() throws RemoteException;
	public int getOgen() throws RemoteException;
}
