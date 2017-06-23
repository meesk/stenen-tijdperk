package domainlayer.skeleton.huttegels;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeler;

/**
 * Deze interface kan door de RMI worden gebruikt om huttegel-gegevens
 * op te halen.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface IHuttegel extends Remote {

	/** Het (her-)berekenen van de waarde van de tegel. */
	public void berekenWaarde() throws RemoteException;

	/**
	 * Het uitvoeren van een actie zoals beschreven op de huttegel.
	 * @param speler  De speler die de actie gaat uitvoeren.
	 * @return Een boolean of de actie is uitgevoerd.
	 */
	public boolean uitvoerenActie(ISpeler speler) throws RemoteException;

	/** @return De url van de asset. */
	public String getAsset() throws RemoteException;
}
