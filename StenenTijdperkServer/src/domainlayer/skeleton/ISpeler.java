package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;
import domainlayer.Tableau;
import javafx.scene.paint.Color;

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

	public boolean getKlaar() throws RemoteException;

	public Tableau getTableau() throws RemoteException;

	public Spel getSpel() throws RemoteException;

	public void klaarVoorSpeler() throws RemoteException;

	public void ophalenGegevens() throws RemoteException;

	public void extraTelling() throws RemoteException;

}
