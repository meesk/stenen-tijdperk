package domainlayer.skeleton;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import domainlayer.Tableau;

/**
 * ISpel.java
 * Een interface voor het spel aan de server kant.
 *
 * @author Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * Tristan Caspers s1102755
 * @version 0.2
 */

public interface ISpel extends Remote {

	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch) throws RemoteException;
	
	public int getAangegevenSpelers() throws RemoteException;
	
	public List<ISpeler> getSpelerLijst() throws RemoteException;
	
	public void opslaan() throws IOException;

}
