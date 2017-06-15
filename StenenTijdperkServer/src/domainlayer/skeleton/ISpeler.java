package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;
import domainlayer.Tableau;

/**
 * ISpeler.java
 * Een interface voor de klasse Speler.java aan de server kant
 *
 * @author Erwin Olie, s1103026
 * Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * @version 0.1
 */

public interface ISpeler extends Remote {

	public String getNaam() throws RemoteException;

	public LocalDate getGeboorteDatum() throws RemoteException;

	public boolean getSpasme() throws RemoteException;

	public Tableau getTableau() throws RemoteException;
	
	public void klaarVoorSpeler() throws RemoteException;

}
