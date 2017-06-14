package domainlayer;

import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.IStamlid;

/**
 * Tableau.java
 * De model klassen voor het Tableau
 * @author Mees Kluivers, s1102358
 * @version 0.1
 *
 */

public class Tableau extends UnicastRemoteObject implements ITableau{
	
	private int gereedschap;
	private ISpeler speler;
	private List<IStamlid> stamleden;
	private Middel middelen;

	protected Tableau() throws RemoteException {

	}

}
