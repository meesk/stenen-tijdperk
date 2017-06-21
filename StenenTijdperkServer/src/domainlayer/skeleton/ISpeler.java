package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;
import domainlayer.enums.SpelerStatus;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * ISpeler.java
 * Een interface voor de klasse Speler.java aan de server kant
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens s1102421
 * @author Mees Kluivers s1102358
 * @version 0.1
 */

public interface ISpeler extends Remote {

	public String getNaam() throws RemoteException;

	public LocalDate getGeboorteDatum() throws RemoteException;

	public boolean getSpasme() throws RemoteException;

	public boolean isKlaar() throws RemoteException;

	public ITableau getTableau() throws RemoteException;

	public Spel getSpel() throws RemoteException;

	public void klaarVoorSpeler() throws RemoteException;

	public int ophalenGegevens() throws RemoteException;

	public int extraGegevens() throws RemoteException;

	public String getKleur() throws RemoteException;

	public void setStatus(SpelerStatus status) throws RemoteException;

	public SpelerStatus getStatus() throws RemoteException;

	public ILocatie getLaatsteLocatie() throws RemoteException;

	public void setLaatsteLocatie(ILocatie model) throws RemoteException;

}
