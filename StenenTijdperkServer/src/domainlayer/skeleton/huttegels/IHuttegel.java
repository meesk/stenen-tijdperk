package domainlayer.skeleton.huttegels;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public interface IHuttegel extends Remote {

	public void berekenWaarde() throws RemoteException;
	public boolean uitvoerenActie(ISpeler speler) throws RemoteException;
	public String getAsset() throws RemoteException;
}
