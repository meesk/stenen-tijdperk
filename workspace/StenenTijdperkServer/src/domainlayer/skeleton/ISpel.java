package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ISpel extends Remote {
	
	public ISpeler maakSpeler(String naam) throws RemoteException;

}
