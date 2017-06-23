package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;

/**
 * Stamlid.java
 * Een klasse waar de stamleden worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @version	1.0
 */
public class Stamlid extends UnicastRemoteObject implements IStamlid {
	private ISpeler speler;

	/**
	 * Het initialiseren van een stamlid
	 * @param speler  De speler die hoort bij een speler
	 * @throws RemoteException
	 */
	public Stamlid(ISpeler speler) throws RemoteException {
		this.speler = speler;
	}

	@Override
	public ISpeler getSpeler() {
		return speler;
	}
}
