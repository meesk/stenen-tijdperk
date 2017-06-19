package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IStamlid;

/**
 * Stamlid.java<br>
 * Een klasse waar de stamleden worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @version	1.0
 */
public class Stamlid extends UnicastRemoteObject  implements IStamlid{
	private Speler speler;

	public Stamlid(Speler speler) throws RemoteException {
		this.speler = speler;
	}

	public Speler getSpeler() {
		return speler;
	}
}
