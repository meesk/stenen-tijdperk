package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

/**
 * ISpel.java
 * Een interface voor het spel aan de server kant.
 * 
 * @author Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * @version 0.1
 */

public interface ISpel extends Remote {
	
	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch) throws RemoteException;

}
