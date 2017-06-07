package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpeler extends Remote{
	
	public void getNaam() throws RemoteException;
	
	public void getGeboorteDatum() throws RemoteException;
	
	public void getSpasme() throws RemoteException;

}
