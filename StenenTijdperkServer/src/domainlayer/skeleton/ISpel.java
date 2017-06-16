package domainlayer.skeleton;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import domainlayer.Tableau;
import domainlayer.enums.Kleur;

/**
 * ISpel.java
 * Een interface voor het spel aan de server kant.
 *
 * @author Enzo Campfens s1102421
 * @author Mees Kluivers s1102358
 * @author Tristan Caspers s1102755
 * @version 0.2
 */

public interface ISpel extends Remote {

	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch, Kleur kleur) throws RemoteException;

	//public int getAangegevenSpelers() throws RemoteException;

	public List<ISpeler> getSpelerLijst() throws RemoteException;

	public int getAangegevenSpelers() throws RemoteException;

	//public List<ISpeler> getSpelerLijst() throws RemoteException;

	public void opslaan() throws IOException;

	public void checkSpelers() throws RemoteException;
}
