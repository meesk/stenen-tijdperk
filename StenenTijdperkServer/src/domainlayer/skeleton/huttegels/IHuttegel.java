package domainlayer.skeleton.huttegels;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public interface IHuttegel extends Remote {

	public void berekenWaarde() throws RemoteException;
	public void uitvoerenActie(ISpeler speler) throws RemoteException;
	
}
